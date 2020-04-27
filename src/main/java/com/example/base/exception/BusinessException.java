package com.example.base.exception;

/**
 * 业务类异常，初始化时使用returnCode 作为message内容传入，
 * 具体的message异常参数放在auguments中传入
 *
 * @Author zhangjiwei
 * @Date 2019/5/10 17:41
 * @Description
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1184944069954989435L;

    /**
     * exception对应的错误码
     */
    private String code;


    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
