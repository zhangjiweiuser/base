package com.example.base.constant;

/**
 * @Author zhangjiwei
 * @Date 2019/5/10 16:43
 * @Description
 */
public class ReturnCode {

    /**
     *
     */
    public final static String SUCCESS = "0000";

    /**
     * 9999:失败
     */
    public static final String ERROR = "9999";
    /**
     * 9001:系统繁忙
     */
    public static final String CONNECTION_ERROR = "9001";
    /**
     * 9002:未知错误
     */
    public static final String UNKNOWN_ERROR = "9002";
    /**
     * 9003:数据库异常
     */
    public static final String DATA_ACCESS_ERROR = "9003";
    /**
     * 9003:数据插入异常
     */
    public static final String DATA_INSERT_ERROR = "9004";

    /**
     * 1000:非法参数
     */
    public static final String INVALID_PARAMETER = "1000";


    /*************************** bussiness return code *****************************/

    /**
     * 不存在
     */
    public final static String POST_IS_NOT_EXIT = "2001";

    /**
     * 不能删除非本人创建的...
     */
    public final static String CAN_NOT_DELETE_OTHER_USERS_POST = "2002";


    //文件为空
    public final static String FILE_IS_EMPTY = "3001";

    //导入失败,无进行中的审议阶段，且有已完成的，不允许导入！请开启后再试！
    public final static String NO_PROGRESS_HAVE_FINISHED = "3002";

    //导入功能属于线下公司总部，预算主体只能为线下公司
    public final static String NOT_OFFLINE_COMPANY = "3003";

    //文件类型错误
    public final static String FILE_TYPE_ERROR = "3004";

    //导入失败,无进行中的审议阶段，不允许导入！请开启后再试！
    public final static String NO_PROGRESS_STAGE = "3005";

    //未找到对应的预算主体信息
    public final static String BUDGET_SUBJECT_NOT_FOUND = "4001";

    //预算期间未开启
    public final static String BUDGET_PERIOD_NOT_OPEN = "4002";

    //未找到对应的预算类型信息
    public final static String BUDGET_TYPE_NOT_FOUND = "4003";

    //失败,该模型数据已初始化！
    public final static String BUDGET_MODEL_DATA_INITED = "4004";

    public final static String NO_FINISH_STAUS = "5001";
    /**
     * 未登录，统一code码
     */
    public final static String NOT_LOGIN = "7001";

    /**
     * 没有权限
     */
    public final static String NOT_PERMISSION = "8001";
}
