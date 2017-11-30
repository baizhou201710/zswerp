package com.zsw.busi.service.impl;

import com.zsw.base.Constant;
import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.busi.dao.GoodsDao;
import com.zsw.busi.dao.GoodsDetailDao;
import com.zsw.busi.entity.Goods;
import com.zsw.busi.entity.GoodsDetail;
import com.zsw.busi.service.GoodsDetailService;
import com.zsw.sys.dao.BaseDao;
import com.zsw.sys.service.BaseService;
import com.zsw.util.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:50
 */

@Service
@Transactional
@SuppressWarnings("unchecked")
public class GoodsDetailServiceImpl implements GoodsDetailService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsDetailDao goodsDetailDao;
    @Autowired
    private BaseDao baseDao;

    /**
     * 单批次入库
     *
     * @param goodsDetail
     * @return
     * @throws ServiceException
     */
    public Result inStock(GoodsDetail goodsDetail) throws ServiceException {

        Result res = new Result();
        try {
            //是否存在该型号
            Goods goods = goodsDao.getByGoodsId(goodsDetail.getGoodsId());

            if (Empty.isEmpty(goods)) {
                res.setCode(Constant.RESULT_SUCCESS);
                res.setMsg("找不到该批次的型号,请先建立该型号资料！");
                return res;
            }
            //存在该型号则新入库该批次
            goodsDetailDao.addGoodsDetail(goodsDetail);

            res.setCode(Constant.RESULT_SUCCESS);
            res.setMsg("新增GoodsDetail成功");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return res;
    }

    public Result outStock(String id, int quantity) throws ServiceException {
        Result res = new Result();

        try {
            //检验是否存在该批次
            GoodsDetail detail = goodsDetailDao.getById(id);
            if (Empty.isEmpty(detail)) {
                res.setCode(Constant.RESULT_FAILURE);
                res.setMsg("该型号不存在该批次，无法出库该批次！");
                return res;
            }
            if (detail.getStock() < quantity) {
                res.setCode(Constant.RESULT_FAILURE);
                res.setMsg("该批次库存为" + detail.getStock() + ",无法出库" + quantity + "!");
                return res;
            }
            //减库存
            detail.setStock(detail.getStock() - quantity);
            goodsDetailDao.updateGoodsDetail(detail);
            res.setCode(Constant.RESULT_SUCCESS);
            res.setMsg("出库成功");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return res;
    }

    public Result upd(GoodsDetail detail) throws ServiceException {
        Result res = new Result();

        try {
            //校验是否存在该批次
            GoodsDetail oldDetail = goodsDetailDao.getById(detail.getId());
            if (Empty.isEmpty(oldDetail)) {
                res.setCode(Constant.RESULT_FAILURE);
                res.setMsg("不存在该批次，无法修改！");
                return res;
            }
            /*修改goodsId*/
            if (!Empty.isEmpty(detail.getGoodsId())) {
                oldDetail.setGoodsId(detail.getGoodsId());
            }

            /*修改packageType*/
            if (!Empty.isEmpty(detail.getBatch())) {
                oldDetail.setBatch(detail.getBatch());
            }

            /*修改purchasePrice*/
            if (detail.getPurchasePrice() >= 0.00f) {
                oldDetail.setPurchasePrice(detail.getPurchasePrice());
            }

            /*修改stock*/
            if (detail.getStock() > 0) {
                oldDetail.setStock(detail.getStock());
            }

            /*修改InStorageBatch*/
            if (!Empty.isEmpty(detail.getInStorageBatch())) {
                oldDetail.setInStorageBatch(detail.getInStorageBatch());
            }

            /*修改state*/
            if (!Empty.isEmpty(detail.getState())) {
                oldDetail.setState(detail.getState());
            }

            /*修改description*/
            if (!Empty.isEmpty(detail.getDescription())) {
                oldDetail.setDescription(detail.getDescription());
            }

            goodsDetailDao.updateGoodsDetail(oldDetail);
            //日志记录

            res.setCode(Constant.RESULT_SUCCESS);
            res.setMsg("修改成功！");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return res;
    }

    /**
     * 库存校正
     *
     * @param detail
     * @return
     * @throws ServiceException
     */
    public Result adjustStock(String id, int quantity) throws ServiceException {
        Result res = new Result();

        try {
            //检验是否存在该批次
            GoodsDetail detail = goodsDetailDao.getById(id);
            if (Empty.isEmpty(detail)) {
                res.setCode(Constant.RESULT_FAILURE);
                res.setMsg("该型号不存在该批次，校正库存");
                return res;
            }
            if (quantity < 0) {
                res.setCode(Constant.RESULT_FAILURE);
                res.setMsg("库存必须大于等于0!");
                return res;
            }
            //减库存
            detail.setStock(quantity);
            goodsDetailDao.updateGoodsDetail(detail);
            res.setCode(Constant.RESULT_SUCCESS);
            res.setMsg("出库校正成功");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return res;
    }

    /**
     * @param id
     * @return
     * @throws ServiceException
     */
    public Result del(String id) throws ServiceException {
        Result res = new Result();

        try {
            //检验是否存在该批次
            GoodsDetail detail = goodsDetailDao.getById(id);
            if (Empty.isEmpty(detail)) {
                res.setCode(Constant.RESULT_FAILURE);
                res.setMsg("该型号不存在该批次，无法删除！");
                return res;
            }
            goodsDetailDao.del(id);
            res.setCode(Constant.RESULT_SUCCESS);
            res.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return res;
    }
}
