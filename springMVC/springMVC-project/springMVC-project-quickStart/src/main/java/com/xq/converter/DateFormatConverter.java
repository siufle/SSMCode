package com.xq.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义数据类型转换函数
 */
public class DateFormatConverter implements Converter<String, Date> {


    @Override
    public Date convert(String source) {
        try {
            if(StringUtils.isEmpty(source)){
                throw new NullPointerException("数据不能为空");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(source);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
