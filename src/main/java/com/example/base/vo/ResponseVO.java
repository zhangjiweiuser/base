package com.example.base.vo;

import com.alibaba.fastjson.JSONObject;
import com.example.base.constant.ReturnCode;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 响应dto
 *
 * @Author zhangjiwei
 * @Date 2019/5/10 16:54
 * @Description
 */
@Data
@Slf4j
public class ResponseVO {

    /**
     * 状态码
     */
    private String returnCode;

    /**
     * 提示信息
     */
    private String returnMsg;

    /**
     * 各个接口返回的数据
     */
    private Object body;

    /**
     * @param body 返回信息
     * @return 返回成功
     */
    public static ResponseVO success(Object body) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setReturnCode(ReturnCode.SUCCESS);
        responseVO.setReturnMsg("success");
        responseVO.setBody(body);
        return responseVO;
    }

    public static ResponseVO successPrintLog(Object body) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setReturnCode(ReturnCode.SUCCESS);
        responseVO.setReturnMsg("success");
        responseVO.setBody(body);
        log.info(JSONObject.toJSONString(responseVO));
        return responseVO;
    }

    /**
     * 默认返回未知异常
     *
     * @param msg 错误信息
     * @return 返回未知异常
     */
    public static ResponseVO error(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setReturnCode(ReturnCode.UNKNOWN_ERROR);
        responseVO.setReturnMsg(msg);
        return responseVO;
    }

    public static ResponseVO errorPrintLog(String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setReturnCode(ReturnCode.UNKNOWN_ERROR);
        responseVO.setReturnMsg(msg);
        log.error(JSONObject.toJSONString(responseVO));
        return responseVO;
    }

    /**
     * 根据code返回特定异常
     *
     * @param code code码
     * @param msg  错误信息
     * @return 返回特定异常
     */
    public static ResponseVO error(String code, String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setReturnCode(code);
        responseVO.setReturnMsg(msg);
        return responseVO;
    }

    public static ResponseVO errorPrintLog(String code, String msg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setReturnCode(code);
        responseVO.setReturnMsg(msg);
        log.error(JSONObject.toJSONString(responseVO));
        return responseVO;
    }
}
