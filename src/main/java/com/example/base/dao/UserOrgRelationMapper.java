package com.example.base.dao;

import com.example.base.entity.UserOrgRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author zhangjiwei-ds
 * 用户机构权限Dao
 */
@Repository
public interface UserOrgRelationMapper extends Mapper<UserOrgRelation>, MySqlMapper<UserOrgRelation> {
    /**
     * 根据用户id查询其机构权限
     *
     * @param userId 用户id
     * @return 用户拥有的机构信息
     */
    List<UserOrgRelation> getUserOrgRelation(@Param("userId") String userId);
}