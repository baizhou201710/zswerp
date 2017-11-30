package com.zsw.busi.controller;

import com.alibaba.fastjson.JSON;
import com.zsw.base.Constant;
import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.busi.entity.Goods;
import com.zsw.busi.entity.GoodsDetail;
import com.zsw.busi.service.GoodsDetailService;
import com.zsw.busi.service.GoodsService;
import com.zsw.sys.service.BaseService;
import com.zsw.util.Empty;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 元器件Controller
 *
 * @author baizhou
 * @create 2017-11-20 10:48
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;
    @Resource
    private BaseService baseService;
    @Resource
    private GoodsDetailService goodsDetailService;

    /**
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "busi/goods/goodsList";
    }

    /**
     * goods列表
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public String goodsList(HttpServletRequest request,
                            @RequestParam(value = "key", required = false) String key,
                            @RequestParam(value = "pageSize") int pageSize,
                            @RequestParam(value = "pageNo") int pageNo) {


        Result result = new Result();
        try {
            //封装查询条件

            Map condition = new HashMap();
            if (!Empty.isEmpty(key)) {
                condition.put("goodsNo", key);
            }
            condition.put("pageSize", pageSize);
            condition.put("limit", (pageNo - 1) * pageSize);
            condition.put("state", Constant.STATE_VAILD);


            //count记录总数
            int tolRecord = goodsService.countByCondition(condition);
            Map page = new HashMap();
            page.put("tolRecord", tolRecord);//总记录数
            page.put("pageNo", pageNo);//当前页数
            if (tolRecord % pageSize == 0) {
                page.put("tolPage", tolRecord / pageSize);//总页数
            } else {
                page.put("tolPage", tolRecord / pageSize + 1);//总页数
            }

            //查询记录
            List<Goods> goodsList = goodsService.queryByCondition(condition);
            //拼接批次号
            if (!Empty.isEmpty(goodsList)) {

                for (Goods goods : goodsList) {
                    if (!Empty.isEmpty(goods.getGoodsDetails())) {
                        String batches = "";
                        for (GoodsDetail detail : goods.getGoodsDetails()) {
                            Set<String> set = new HashSet<String>();

                            if (!Empty.isEmpty(detail.getBatch()) && !set.contains(detail.getBatch())) {
                                set.add(detail.getBatch());
                                batches = batches + "/" + detail.getBatch();
                            }
                        }
                        if (batches.startsWith("/")) {

                            goods.setBatches(batches.substring(1, batches.length()));
                        } else {
                            goods.setBatches(batches);
                        }


                    } else {
                        goods.setBatches("");
                    }
                }
            }
            result.setCode(Constant.RESULT_SUCCESS);
            Map contentsMap = new HashMap();
            contentsMap.put("goodsList", goodsList);
            contentsMap.put("page", page);
            result.setContent(contentsMap);

        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg(Constant.SYS_ERR);

        }
        return JSON.toJSONString(result);
    }

    /**
     * 该型号基本信息，新增，修改页面
     *
     * @return
     */
    @RequestMapping(value = "/goodsInfo", method = RequestMethod.GET)
    public String goodsInfo() {
        return "busi/goods/goodsInfo";
    }

    @RequestMapping(value = "/queryGoodsInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String queryGoodsInfo(@RequestParam(value = "id", required = false) String id) {

        Result result = new Result();
        Goods goods = null;
        try {
            goods = goodsService.getById(id);
            if (!Empty.isEmpty(goods)) {
                goods.setTolStock(goodsService.countStockByGoodsId(id));
            }
            result.setCode(Constant.STATE_VAILD);
            result.setContent(goods);
        } catch (ServiceException e) {
            e.printStackTrace();
            e.printStackTrace();
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg(Constant.SYS_ERR);
        }


        return JSON.toJSONString(result);
    }

    /**
     * 新增，修改
     *
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(HttpServletRequest request,
                       @RequestParam(value = "id", required = false) String id,
                       @RequestParam(value = "goodsNo") String goodsNo,
                       @RequestParam(value = "brand") String brand,
                       @RequestParam(value = "packageType") String packageType,
                       @RequestParam(value = "salePrice", required = false) float salePrice,
                       @RequestParam(value = "stock", required = false) Integer stock,
                       @RequestParam(value = "location", required = false) String location,
                       @RequestParam(value = "description", required = false) String description,
                       @RequestParam(value = "batch", required = false) String batch,
                       @RequestParam(value = "purchasePrice", required = false) Float purchasePrice,
                       @RequestParam(value = "detailDescription", required = false) String detailDescription,
                       @RequestParam(value = "inStock", required = false) String inStock) {

        Result result = new Result();


        try {
            //封装信息
            Goods newGoods = new Goods();
            newGoods.setGoodsNo(goodsNo);
            newGoods.setState(Constant.STATE_VAILD);
            newGoods.setBrand(brand);
            newGoods.setPackageType(packageType);
            newGoods.setLocation(location);
            newGoods.setDescription(description);
            newGoods.setSalePrice(salePrice);
            if (Empty.isEmpty(id)) {
                newGoods.setId(baseService.uuid());
                newGoods.setCreator("bz");

                if (inStock.equals("0")) {//有入库操作
                    //校验入库操作参数完整性
                    if (Empty.isEmpty(stock) || stock.intValue() > 0) {//校验入库数量
                        result.setCode(Constant.RESULT_FAILURE);
                        result.setMsg("入库数量必须大于0！");
                        return JSON.toJSONString(result);
                    }
                    if (Empty.isEmpty(purchasePrice) || purchasePrice.floatValue() <= 0.00f) {//入库价格
                        result.setCode(Constant.RESULT_FAILURE);
                        result.setMsg("入库价格必须大于0！");
                        return JSON.toJSONString(result);
                    }

                    if (Empty.isEmpty(batch)) {//型号批次
                        result.setCode(Constant.RESULT_FAILURE);
                        result.setMsg("入库批次不能为空！");
                        return JSON.toJSONString(result);
                    }

                    List<GoodsDetail> details = new ArrayList<GoodsDetail>();
                    GoodsDetail detail = new GoodsDetail();
                    detail.setId(baseService.uuid());
                    detail.setGoodsId(newGoods.getId());
                    detail.setBatch(batch);//生产批次号
                    detail.setStock(stock.intValue());
                    detail.setPurchasePrice(purchasePrice.floatValue());
                    detail.setState(Constant.STATE_VAILD);
                    //入库批次号
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmm");
                    detail.setInStorageBatch(sdf.format(new Date()));
                    detail.setCreator("bz");
                    detail.setDescription(!Empty.isEmpty(detailDescription) ? detailDescription : "");
                    details.add(detail);
                    newGoods.setGoodsDetails(details);
                }
            } else {
                newGoods.setId(id);
                newGoods.setModifier("bz");
            }

            if (!Empty.isEmpty(id)) {//修改
                result = goodsService.updGoods(newGoods);
            } else {//新增
                result = goodsService.addGoods(newGoods);
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg(Constant.SYS_ERR);
        }

        //记录日志


        return JSON.toJSONString(result);
    }

    /**
     * 删除，修改状态为3
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    @ResponseBody
    public String del(@RequestParam(value = "id", required = false) String id) {
        Result result = new Result();
        if (!Empty.isEmpty(id)) {
            try {
                Goods goods = goodsService.getById(id);
                if (!Empty.isEmpty(goods)) {
                    goodsService.del(id);
                    result.setCode(Constant.RESULT_SUCCESS);
                } else {
                    result.setCode(Constant.RESULT_FAILURE);
                    result.setMsg("不存在该型号！");
                }

            } catch (ServiceException e) {
                e.printStackTrace();
                result.setCode(Constant.RESULT_FAILURE);
                result.setMsg(Constant.SYS_ERR);
            }
        } else {
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg("id不能为空！");
        }

        return JSON.toJSONString(result);
    }

    /**
     * 入库
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/inStock", method = RequestMethod.POST)
    @ResponseBody
    public String inStock(@RequestParam(value = "goodsId") String goodsId,
                          @RequestParam(value = "stock", required = false) Integer stock,
                          @RequestParam(value = "description", required = false) String description,
                          @RequestParam(value = "batch", required = false) String batch,
                          @RequestParam(value = "purchasePrice", required = false) Float purchasePrice) {
        Result result = new Result();
        //入库参数校验
        if (Empty.isEmpty(goodsId)) {

            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg("id不能为空！");
            return JSON.toJSONString(result);
        }
        if (Empty.isEmpty(stock) || stock.intValue() <= 0) {//校验入库数量
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg("入库数量必须大于0！");
            return JSON.toJSONString(result);
        }
        if (Empty.isEmpty(purchasePrice) || purchasePrice.floatValue() <= 0.00f) {//入库价格
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg("入库价格必须大于0！");
            return JSON.toJSONString(result);
        }

        if (Empty.isEmpty(batch)) {//型号批次
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg("入库批次不能为空！");
            return JSON.toJSONString(result);
        }


        try {
            Goods goods = goodsService.getById(goodsId);
            if (!Empty.isEmpty(goods)) {
                GoodsDetail detail = new GoodsDetail();
                detail.setId(baseService.uuid());
                detail.setGoodsId(goodsId);
                detail.setStock(stock);
                detail.setPurchasePrice(purchasePrice.floatValue());
                detail.setCreator("bz");
                detail.setDescription(description);
                detail.setBatch(batch);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmm");
                detail.setInStorageBatch(sdf.format(new Date()));
                result = goodsDetailService.inStock(detail);
                result.setCode(Constant.RESULT_SUCCESS);
            } else {
                result.setCode(Constant.RESULT_FAILURE);
                result.setMsg("不存在该型号！");
            }

        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg(Constant.SYS_ERR);
        }


        return JSON.toJSONString(result);
    }

    /**
     * 入库页面
     *
     * @return
     */
    @RequestMapping(value = "/inStockInfo", method = RequestMethod.GET)
    public String inStockInfo() {
        return "busi/goods/goodsInStock";
    }

    /**
     * 出库
     *
     * @return
     */
    @RequestMapping(value = "/outStock", method = RequestMethod.POST)
    @ResponseBody
    public String outStock(@RequestParam(value = "id", required = true) String id,
                           @RequestParam(value = "stock", required = true) Integer stock,
                           @RequestParam(value = "type", required = true) String type) {

        Result result = new Result();
        //入库参数校验
        if (Empty.isEmpty(id)) {

            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg("id不能为空！");
            return JSON.toJSONString(result);
        }


        //
        try {
            if (type.equals("1")) {//出库
                if (Empty.isEmpty(stock) || stock.intValue() <= 0) {//校验入库数量
                    result.setCode(Constant.RESULT_FAILURE);
                    result.setMsg("入库数量必须大于0！");
                    return JSON.toJSONString(result);
                }
                result = goodsDetailService.outStock(id, stock);
            } else if (type.equals("2")) {//库存调整
                if (Empty.isEmpty(stock) || stock.intValue() <= 0) {//校验入库数量
                    result.setCode(Constant.RESULT_FAILURE);
                    result.setMsg("库存数量必须大于0！");
                    return JSON.toJSONString(result);
                }
                result = goodsDetailService.adjustStock(id, stock);
            }

        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg(Constant.SYS_ERR);
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/delDetail", method = RequestMethod.GET)
    @ResponseBody
    public String delDetail(@RequestParam(value = "id", required = true) String id) {
        Result result = new Result();
        //入库参数校验
        if (Empty.isEmpty(id)) {

            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg("id不能为空！");
            return JSON.toJSONString(result);
        }

        try {
            result = goodsDetailService.del(id);

        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg(Constant.SYS_ERR);
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/exportGoodsInfo",method = RequestMethod.GET)
    public String exportGoodsInfo(){
        return "busi/goods/exportGoods";
    }

    @RequestMapping(value = "/export",method = RequestMethod.POST)
    @ResponseBody
    public String export(HttpServletRequest request,String key){
        Result result = new Result();
        Map condition = new HashMap();
        if (!Empty.isEmpty(key)) {
            condition.put("goodsNo", key);
        }

        condition.put("state", Constant.STATE_VAILD);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyMMddHHmm");
            String rootPath=request.getSession().getServletContext().getRealPath("/");
            String filePath="files"+File.separator+sdf.format(new Date())+"stock.xls";

            File xlsFile = new File(rootPath+filePath);
            // 创建一个工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
            // 创建一个工作表
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            List<Goods> goodsList =goodsService.queryByCondition(condition);
            sheet.addCell(new Label(0, 1, "型号"));//表头
            sheet.addCell(new Label(1, 1, "品牌"));//表头
            sheet.addCell(new Label(2, 1, "封装"));//表头
            sheet.addCell(new Label(3, 1, "批号"));//表头
            sheet.addCell(new Label(4, 1, "数量"));//表头
            sheet.addCell(new Label(5, 1, "位置"));//表头
            sheet.addCell(new Label(6, 1, "备注"));//表头
            sheet.addCell(new Label(7, 1, "卖价"));//表头
            sheet.addCell(new Label(8, 1, "进价"));//表头



            if (!Empty.isEmpty(goodsList)){
                int count=goodsList.size();
                for (int i=0;i<count;i++){

                    sheet.addCell(new Label(0, i+1,goodsList.get(i).getGoodsNo() ));
                    sheet.addCell(new Label(1, i+1, goodsList.get(i).getBrand()));
                    sheet.addCell(new Label(2, i+1, goodsList.get(i).getPackageType()));
                    sheet.addCell(new Label(3, i+1, goodsList.get(i).getBatches()));
                    sheet.addCell(new Label(4, i+1,Integer.toString(goodsList.get(i).getTolStock()) ));
                    sheet.addCell(new Label(5, i+1, goodsList.get(i).getLocation()));
                    sheet.addCell(new Label(6, i+1, goodsList.get(i).getDescription()));
                    sheet.addCell(new Label(7, i+1, Float.toString(goodsList.get(i).getSalePrice())));
                    sheet.addCell(new Label(8, i+1, Float.toString(goodsList.get(i).getSalePrice())));

                }
            }
            workbook.write();
            workbook.close();
            result.setCode(Constant.RESULT_SUCCESS);
            result.setContent(filePath.replaceAll("\\\\","/"));
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg(Constant.SYS_ERR);
        }

        return JSON.toJSONString(result);
    }
}
