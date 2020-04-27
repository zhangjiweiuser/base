package com.example.base.handler;

import com.example.base.constant.ReturnCode;
import com.example.base.exception.BusinessException;
import com.example.base.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 异常处理器
 *
 * @Author ChenZun
 * @Date 2019/5/10 17:42
 * @Description
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);

    /**
     * 空指针异常处理 空指针异常
     *
     * @param nullPointerException 空指针异常
     * @return 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseVO dealNullPointerException(NullPointerException nullPointerException) {
        logger.error("空指针", nullPointerException);
        return ResponseVO.error("空指针异常");
    }

    /**
     * 参数绑定异常处理
     *
     * @param bindException 参数绑定异常
     * @return 参数绑定异常
     */
    @ExceptionHandler(BindException.class)
    public ResponseVO dealBindExceptionException(BindException bindException) {
        logger.error("参数绑定异常", bindException);
        List<FieldError> fieldErrors = bindException.getFieldErrors();
        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            System.out.println(fieldError.toString());
            String name = fieldError.getField();
            builder.append("[");
            builder.append(name);
            builder.append("]");
            String message = fieldError.getDefaultMessage();
            builder.append(message);
            break;
        }
        return ResponseVO.error(ReturnCode.INVALID_PARAMETER, builder.toString());
    }

    /**
     * 参数绑定异常处理
     *
     * @param exception 参数绑定异常
     * @return 参数绑定异常
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseVO dealBindExceptionException(MissingServletRequestParameterException exception) {
        logger.error("参数绑定异常", exception);
        return ResponseVO.error(ReturnCode.INVALID_PARAMETER, "参数" + exception.getParameterName() + "非法");
    }
    /**
     * 参数绑定异常处理
     *
     * @param exception 参数绑定异常
     * @return 参数绑定异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseVO dealConstraintViolationException(ConstraintViolationException exception) {
        logger.error("参数绑定异常", exception);
        Set<ConstraintViolation<?>> constraintViolationExceptions = exception.getConstraintViolations();

        Iterator<ConstraintViolation<?>> iterator = constraintViolationExceptions.iterator();
        ConstraintViolation<?> constraintViolation = iterator.next();

        return ResponseVO.error(ReturnCode.INVALID_PARAMETER, constraintViolation.getMessage());
    }

    /**
     * 参数绑定异常处理
     *
     * @param exception 参数绑定异常
     * @return 参数绑定异常
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseVO dealMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        logger.error("参数绑定异常", exception);

        return ResponseVO.error(ReturnCode.INVALID_PARAMETER, "参数" + exception.getName() + "非法");
    }

    /**
     * 附件为空异常处理
     *
     * @param exception 参数绑定异常，附件为空
     * @return 参数绑定异常
     */
    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseVO dealMissingServletRequestPartException(MissingServletRequestPartException exception) {
        logger.error("附件为空", exception);
        return ResponseVO.error(ReturnCode.INVALID_PARAMETER, "导入没有选择有效的文件！");
    }

    /**
     * 数据获取异常处理
     *
     * @param exception 数据获取异常
     * @return 数据获取异常
     */
    @ExceptionHandler(DataAccessException.class)
    public ResponseVO dealDataAccessException(DataAccessException exception) {
        logger.error("数据获取异常", exception);
        return ResponseVO.error(ReturnCode.DATA_ACCESS_ERROR, "数据获取异常");
    }

    /**
     * 业务异常处理
     *
     * @param exception 业务异常
     * @return 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseVO dealBusinessException(BusinessException exception) {
        logger.error("业务异常", exception);
        return ResponseVO.error(exception.getCode(), exception.getMessage());
    }

    /**
     * 通用异常处理
     *
     * @param exception 通用异常
     * @return 服务异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseVO dealNullPointerException(Exception exception) {
        logger.error("服务异常", exception);
        return ResponseVO.error(ReturnCode.UNKNOWN_ERROR, "服务异常");
    }
}
