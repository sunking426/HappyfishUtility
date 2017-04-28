package cc.happyfish.utility.spring.hibernate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/1/22 <br>
 * 说明:Joda日期格式序列化器，给ObjectMapper使用
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private String datetimeFormatter;

    public LocalDateTimeSerializer(String datetimeFormatter) {
        this.datetimeFormatter = datetimeFormatter;
    }

    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString());
    }
}
