package com.imooc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: yangheng
 * Date: 2018/1/19
 * Time: 23:27
 * To change this template use File | Settings | File Templates.
 * Description: 装载配置文件中girl 这个配置参数集
 **/
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String cupSize;
    private Integer age;
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {

        return content;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {

        return cupSize;
    }

    public Integer getAge() {
        return age;
    }
}
