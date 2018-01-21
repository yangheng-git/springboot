package com.imooc.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: yangheng
 * Date: 2018/1/20
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 * 描述: AOP切面。
 * aop的理解：我们传统的编程方式是垂直化的编程，即A–>B–>C–>D这么下去，一个逻辑完毕之后执行另外一段逻辑。但是AOP提供了另外一种思路，
 * 它的作用是在业务逻辑不知情（即业务逻辑不需要做任何的改动）的情况下对业务代码的功能进行增强，这种编程思想的使用场景有很多，
 * 例如事务提交、方法执行之前的权限检测、日志打印、方法调用事件等等（http://www.importnew.com/26951.html）
 * 通知类型有前置通知、后置最终通知、后置返回通知、后置异常通知、环绕通知，在切面类中添加通知
 *
 **/
@Aspect
@Component
public class HttpAspect {
    /*定义日志类sfl4j: spring自带日志类*/
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /*定义一个切入点*/
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")
    public void log() {
    }

    /*在方法执行前*/
    @Before("log()")
    public void doBuffer(JoinPoint joinPoint){
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url--      {}",request.getRequestURL());
        //请求方法method
        logger.info("method--   {}",request.getMethod());
        //ip地址
        logger.info("ip--       {}",request.getRemoteAddr());
        //类方法
        logger.info("class_methodd--{}",joinPoint.getSignature().getDeclaringTypeName()+"."
                +joinPoint.getSignature().getName());
        //参数
        logger.info("args--     {}",joinPoint.getArgs());

    }
    /*方法执行后*/
    @After("log()")
    public void doAfter(){
        logger.info("方法执行完了");

    }
    /*方法执行后返回结果后*/
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("方法执行完了,正在返回参数");
  //      logger.info("response={}",object.toString());
    }
}
