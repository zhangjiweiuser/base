package com.example.base.handler;

import org.apache.ibatis.type.LocalDateTimeTypeHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 自定义日期时间解析类
 *
 * @ClassName MyLocalDateTypeHandler
 * @Author zhangjiwei
 * @Date 2019/7/9 15:42
 * @Description
 */
public class MyLocalDateTimeTypeHandler extends LocalDateTimeTypeHandler {
    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnName);
        if (sqlTimestamp != null) {
            return Instant.ofEpochMilli(sqlTimestamp.getTime()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp sqlTimestamp = rs.getTimestamp(columnIndex);
        if (sqlTimestamp != null) {
            return Instant.ofEpochMilli(sqlTimestamp.getTime()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        }
        return null;
    }
}
