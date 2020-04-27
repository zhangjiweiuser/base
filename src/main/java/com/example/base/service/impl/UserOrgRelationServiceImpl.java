package com.example.base.service.impl;

import com.example.base.dao.UserOrgRelationMapper;
import com.example.base.entity.UserOrgRelation;
import com.example.base.service.UserOrgRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrgRelationServiceImpl implements UserOrgRelationService {
    @Autowired
    private UserOrgRelationMapper userOrgRelationMapper;

    @Override
    public List<UserOrgRelation> getUserOrgRelation(String userId) {
        return userOrgRelationMapper.getUserOrgRelation(userId);
    }
}
