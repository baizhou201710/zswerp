package com.zsw.service.busi;

import com.zsw.base.ServiceException;
import com.zsw.baseTest.SpringCaseTest;
import com.zsw.busi.entity.Goods;
import com.zsw.busi.entity.GoodsDetail;
import com.zsw.busi.service.GoodsService;
import com.zsw.sys.service.BaseService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/15 9:43
 */
public class GoodsServiceTest extends SpringCaseTest {

    @Resource
    private GoodsService goodsService;

    @Resource
    private BaseService baseService;
    /**
     * 1.新增不存在型号，且无详细信息
     */
   // @Test
    public void add1(){

      /*  Goods goods =new Goods("MAX495CPA","3号盒子","公司库房",90.00f);
        goods.setId(baseService.uuid());
        try {
            Map map=goodsService.addGoods(goods);
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
*/

    }

    /**
     * 2.新增不存在型号，且有详细信息
     */
    //@Test
    public void add2(){

        Goods goods =new Goods("DSP56F826BU80E","1号盒子","公司库房",54.00f);
        String goodsId=baseService.uuid();
        goods.setId(goodsId);
        goods.setCreator("bz");
        GoodsDetail detail = null;//new GoodsDetail(goodsId,"DALLAS","DIP-28","0612+",7,58.00f,"201711121155","");
        detail.setId(baseService.uuid());
        List<GoodsDetail> details = new ArrayList<GoodsDetail>();
        details.add(detail);
        goods.setGoodsDetails(details);
       /* try {
            Map map = goodsService.addGoods(goods);
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
*/
    }

    /**
     * 3.新增已存在型号
     */
    //@Test
    public void add3(){

        Goods goods =new Goods("DS1225Y-100IND","1号盒子","公司库房",54.00f);
        goods.setId(baseService.uuid());
        goods.setCreator("bz");
       /* try {
            Map map=goodsService.addGoods(goods);
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/

    }

    /**
     * 修改
     */
    //@Test
    public void upd(){

        Goods goods =new Goods("DS1225Y-100IND","1号盒子","公司库房12",59.00f);
        goods.setId("57d0f779c9d311e79665382c4a1d600b");
        goods.setModifier("bz");
      /*  try {
            Map map=goodsService.updGoods(goods);
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/

    }

    /**
     * 删除
     */
    //@Test
    public void del(){

       /* try {
            Map map=goodsService.del("57d0f779c9d311e79665382c4a1d600b");
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/

    }

    /**
     * 根据goodsId查询总库存
     */
    //@Test
    public void countStockByGoodsId(){

        try {
            int stock=goodsService.countStockByGoodsId("91bac4f0c9b211e79665382c4a1d600b");
            System.out.println(stock);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据型号模糊查询
     */
    @Test
    public void queryByGoodsNo(){
        try {
            List<Goods> goodsList = goodsService.queryByGoodsNo("MAX");
            System.out.println(goodsList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
