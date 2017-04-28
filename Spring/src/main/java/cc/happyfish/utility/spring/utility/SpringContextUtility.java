package cc.happyfish.utility.spring.utility;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-08-04
 * 说明:无
 */
@Component
@Scope("singleton")
public class SpringContextUtility implements ApplicationContextAware {

    private static ApplicationContext applicationContext; // Spring应用上下文环境

    public static synchronized ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /*
    * 实现了ApplicationContextAware 接口，必须实现该方法；
    *通过传递applicationContext参数初始化成员变量applicationContext
    */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtility.applicationContext = applicationContext;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> tClass) throws BeansException {
        return applicationContext.getBean(tClass);
    }
}
