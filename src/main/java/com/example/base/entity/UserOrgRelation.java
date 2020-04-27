package com.example.base.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户与组织机构关系表
 *
 * @author zhangjiwei-ds
 */
@Setter
@Getter
@ToString
@Table(name = "user_org_relation")
public class UserOrgRelation {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 机构id
     */
    @Column(name = "org_id")
    private String orgId;

}