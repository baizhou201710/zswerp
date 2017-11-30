package com.zsw.busi.service.impl;

import com.zsw.base.Constant;
import com.zsw.base.DaoException;
import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.busi.dao.GoodsDao;
import com.zsw.busi.dao.GoodsDetailDao;
import com.zsw.busi.entity.Goods;
import com.zsw.busi.entity.GoodsDetail;
import com.zsw.busi.service.GoodsService;
import com.zsw.util.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:48
 */
@Service
@Transactional
@SuppressWarnings("unchecked")
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsDetailDao goodsDetailDao;

    public Result addGoods(Goods newGoods) throws ServiceException {

        Result res= new Result();

        try {
            //检查是否已存在该型号
            Goods goods = goodsDao.getByGoodsNo(newGoods.getGoodsNo());

            //不存在该型号则进行下一步
            if (Empty.isEmpty(goods)) {

                //新增型号
                goodsDao.addGoods(newGoods);


                /*如果存在明细则新增明细*/
                if (!Empty.isEmpty(newGoods.getGoodsDetails())) {
                    for (GoodsDetail detail : newGoods.getGoodsDetails()) {
                        goodsDetailDao.addGoodsDetail(detail);
                    }
                }
            } else {
                res.setCode(Constant.RESULT_FAILURE);
                res.setCode("已存在该型号，请走修改！");
                return res;
            }

            //日志记录

            res.setCode(Constant.RESULT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return res;
    }

    public Result updGoods(Goods goods) throws ServiceException {
        Result res= new Result();
        try {
            //根据该型号Id校验是否存在
            Goods oldGoods = goodsDao.getByGoodsId(goods.getId());

            //不存在则返回
            if (Empty.isEmpty(oldGoods)) {
                res.setCode( Constant.RESULT_FAILURE);
                res.setMsg("不存在该型号！");
                return res;
            }
            goodsDao.updGoods(goods);

            //记录日志
            res.setCode(Constant.RESULT_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return res;
    }

    public Result del(String goodsId) throws ServiceException {
        Result res= new Result();
        try {
            //是否存在该型号
            Goods oldGoods = goodsDao.getByGoodsId(goodsId);

            //不存在该型号则返回
            if (Empty.isEmpty(oldGoods)) {
                res.setCode(Constant.RESULT_FAILURE);
                res.setMsg("不存在该型号！");
                return res;
            }

            //将该型号变为删除状态
            oldGoods.setState(Constant.STATE_DELELED);
            goodsDao.updGoods(oldGoods);

            //查询是否有详细信息
            List<GoodsDetail> details = goodsDetailDao.getDetailsByGoodsId(goodsId);
            //有则将关联的批次状态置为删除
            if (!Empty.isEmpty(details)) {
                for (GoodsDetail detail : details) {
                    detail.setState(Constant.STATE_DELELED);
                    goodsDetailDao.updateGoodsDetail(detail);
                }
            }

            //日志

            res.setCode(Constant.RESULT_SUCCESS);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return res;
    }

    public int countStockByGoodsId(String goodsId) throws ServiceException {

        int stock = 0;

        try {
            stock = goodsDao.countStockByGoodsId(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return stock;
    }

    public List<Goods> queryByGoodsNo(String goodsNo) throws ServiceException {
        List<Goods> goodsList;
        try {
            goodsList = goodsDao.queryByGoodsNo(goodsNo);
            if (!Empty.isEmpty(goodsList)){

                for (Goods goods:goodsList){
                    //查询库存量
                    goods.setTolStock(goodsDao.countStockByGoodsId(goods.getId()));
                    //查询该型号有效且库存大于0的批次
                    List<GoodsDetail> list = new ArrayList<GoodsDetail>();
                    list = goodsDetailDao.getDetailsByGoodsId(goods.getId());
                    if (!Empty.isEmpty(list))
                        goods.setGoodsDetails(list);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }

        return goodsList;
    }

    /**
     * 多条件查询
     *
     * @param map
     * @return
     * @throws ServiceException
     */
    public List<Goods> queryByCondition(Map map) throws ServiceException {
        List<Goods> goodsList;
        try {
            goodsList=  goodsDao.queryByCondition(map);
            if (!Empty.isEmpty(goodsList)){

                for (Goods goods:goodsList){
                    //查询库存量
                    goods.setTolStock(goodsDao.countStockByGoodsId(goods.getId()));
                    //查询该型号有效且库存大于0的批次
                    List<GoodsDetail> list = new ArrayList<GoodsDetail>();
                    list = goodsDetailDao.getDetailsByGoodsId(goods.getId());
                    if (!Empty.isEmpty(list)){
                        goods.setGoodsDetails(list);
                    }

                }
            }
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }

        return goodsList;
    }

    /**
     * count多条件查询记录
     *
     * @param map
     * @return
     * @throws ServiceException
     */
    public int countByCondition(Map map) throws ServiceException {
        int count=0;
        try {
            count = goodsDao.countByCondition(map);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return count;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */

    public Goods getById(String id) throws ServiceException{
        try {
            return goodsDao.getByGoodsId(id);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }

    /**
     * 根据goodsNo查询
     *
     * @param goodsNo
     * @return
     */
    public Goods getByGoodsNo(String goodsNo) throws ServiceException{
        try {
            return goodsDao.getByGoodsNo(goodsNo);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }


}
