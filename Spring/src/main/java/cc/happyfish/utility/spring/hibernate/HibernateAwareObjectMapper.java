package cc.happyfish.utility.spring.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

/**
 * 作者:汪阳
 * 部门:计算机应用开发室
 * 联系:0553-8399022
 * 时间:2016-07-21
 * 说明:用于配置Jackson对的配置信息(特别是对Hibernate的Entity无限循环递归异常的处理)
 */
public class HibernateAwareObjectMapper extends ObjectMapper {
    public HibernateAwareObjectMapper() {
        SimpleModule module = new SimpleModule();
        //module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(ControllerExtension.DATETIME_PATTERN));
        registerModule(new Hibernate5Module());
        registerModule(module);
    }
}
