package com.zsw.sys.service;

import com.zsw.baseTest.SpringCaseTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * base
 *
 * @author baizhou
 * @create 2017-11-21 9:35
 */
public class BaseServiceTest extends SpringCaseTest {

    @Resource
    private BaseService baseService;

    @Test
    public void getUUID(){
        List<String> list=new ArrayList<String>();
        for(int i=0;i<898;i++){
            String uuid=baseService.uuid();
            list.add(uuid);
        }

        for (String s:list){
            System.out.println(s);
        }
    }
}
