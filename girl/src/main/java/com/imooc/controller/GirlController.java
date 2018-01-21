package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.Repostory.GirlRepostory;
import com.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yangheng
 * Date: 2018/1/20
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 * 描述: 对girl进行restful格式的crud
 * <p>
 * 请求格式     请求路径        功能
 * GRT          /girls          获取女生列表
 * POST         /girls          创建一个女生
 * GET          /girls/id       通过id查询一个女生
 * PUT          /girls/id       通过id更新一个女生
 * DELETE       /gitls/id       通过id删除一个女生
 *
 * 总结：一般put用来设计修改接口，post作为新增接口，get作为查询接口。

 **/

@RestController
public class GirlController {
    //简单功能，放弃service层。
    @Autowired
    private GirlRepostory girlRepostory;

    @Autowired
    private GirlService girlService;


    /**
     * @return List
     * 获取所有girl
     */
    @GetMapping(value = "/girls")
    public List<Girl> findll() {
        return girlRepostory.findAll();
    }

    /**
     * 创建一个女孩
     */
    @PostMapping(value = "/girls")
    public Girl GirlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            /*打印在pojo中设置的提示信息*/
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;

        }
        girl = girlRepostory.save(girl);
        return girl;
    }

    /**
     * 查询一个女孩 findOne
     */
    @GetMapping(value = "/girls/{id}")
    public Girl findOne(@PathVariable(name = "id") Integer id){
        return girlRepostory.findOne(id);
    }

    /**
     * @param id
     * @param cupSize
     * @param age
     * @return
     * 更新一条数据。
     */
    @PutMapping(value="/girls/{id}")
    public Girl GilrUpdate(@PathVariable(name = "id")Integer id ,
                           @RequestParam(value = "cupSize") String cupSize,
                           @RequestParam(value = "age") Integer age){

        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl = girlRepostory.save(girl);
        return girl;
    }

    /*删除一个女孩*/
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable(name="id")Integer id){
        girlRepostory.delete(id);
    }

    /*根据年龄查询*/
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> GrilListByAge(@PathVariable("age") Integer age ){
        List<Girl> girls = girlRepostory.findByAge(age);
        return girls;
    }

    @PutMapping(value="/girls/add")
    public void GirlAddTow(){
        girlService.insterTow();
    }
}
