package com.zsw.service.busi;

import com.zsw.base.ServiceException;
import com.zsw.baseTest.SpringCaseTest;
import com.zsw.busi.entity.GoodsDetail;
import com.zsw.busi.service.GoodsDetailService;
import com.zsw.sys.service.BaseService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/15 11:50
 */
public class GoodsDetailServiceTest extends SpringCaseTest {

    @Resource
    private GoodsDetailService goodsDetailService;

    @Resource
    private BaseService baseService;

    /**
     * 存在该型号
     */
    @Test
    public void add1(){
        GoodsDetail goodsDetail = null;//new GoodsDetail("b8d8a511ca8311e78cfd382c4a1d600b","MAX","DIP-8","0417+",500,71.00f,"201711161232","");
        goodsDetail.setId(baseService.uuid());
        goodsDetail.setCreator("bz");
        /*try {
           Map map= goodsDetailService.inStock(goodsDetail);
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 不存在该型号
     */
    //@Test
    public void add2(){
        GoodsDetail goodsDetail = null;//new GoodsDetail("91bac4f0c9b451e79665382c4a1d600b","DALLAS","DIP-28","0417+",6,40.00f,"201711121155","");
        goodsDetail.setId(baseService.uuid());
        goodsDetail.setCreator("bz");
       /* try {
            Map map= goodsDetailService.inStock(goodsDetail);
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 更新
     */
    //@Test
    public void upd(){
        GoodsDetail goodsDetail = null;//new GoodsDetail("91bac4f0c9b451e79665382c4a1d600b","DALLAS33","DIP-23338","043317+",634,40.00f,"201711121155","");
        goodsDetail.setId("ed382a98ca0e11e795ad382c4a1d600b");
        goodsDetail.setCreator("bz");
       /* try {
            Map map= goodsDetailService.upd(goodsDetail);
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 出庫
     */
    //@Test
    public void outStock(){

      /*  try {
            Map map= goodsDetailService.outStock("6a1c7498c9cb11e79665382c4a1d600b",2);
            System.out.println(map);
        } catch (ServiceException e) {
            e.printStackTrace();
        }*/
    }

}
