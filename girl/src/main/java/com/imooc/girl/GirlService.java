package com.imooc.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: yangheng
 * Date: 2018/1/20
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 * 描述: Girlf服务层。 用来测试事务
 **/

@Service
@Transactional
public class GirlService {
    @Autowired
    private GirlRepostory girlRepostory;


    public void insterTow(){
        Girl girl = new Girl();
        girl.setCupSize("fsa");
        girl.setAge(2/0);
        girlRepostory.save(girl);

        Girl girl1 = new Girl();
        girl1.setCupSize("fsa");
        girl1.setAge(0/2);

        girlRepostory.save(girl1);
    }

}
