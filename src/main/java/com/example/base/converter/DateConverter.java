package com.example.base.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateConverter
 * @Author zhangjiwei
 * @Date 2019/6/25 11:55
 * @Description
 */
public class DateConverter implements Converter<String, Date> {

    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String TIME_STAMP_FORMAT = "^\\d+$";


    @Override
    public Date convert(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        value = value.trim();

        try {
            if (value.contains("-")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    formatter = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
                } else {
                    formatter = new SimpleDateFormat(YYYY_MM_DD);
                }
                return formatter.parse(value);
            } else if (value.matches(TIME_STAMP_FORMAT)) {
                Long lDate = new Long(value);
                return new Date(lDate);
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
}
