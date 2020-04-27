package com.example.base.configuration;

import com.example.base.converter.DateConverter;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 时间格式预处理
 *
 * @ClassName ControllerHandler
 * @Author zhangjiwei
 * @Date 2019/6/25 11:59
 * @Description
 */
@ControllerAdvice
public class ControllerHandler {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        GenericConversionService genericConversionService = (GenericConversionService) binder.getConversionService();
        if (genericConversionService != null) {
            genericConversionService.addConverter(new DateConverter());
        }
    }
}
