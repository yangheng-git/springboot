package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: yangheng
 * Date: 2018/1/19
 * Time: 22:03
 * To change this template use File | Settings | File Templates.
 * Description: hello spring boot
 **/
@RestController
public class HellController {

    /*@Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;*/

    @Autowired
    private GirlProperties girlProperties;


    public HellController() {
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return girlProperties.getContent();
    }
}
