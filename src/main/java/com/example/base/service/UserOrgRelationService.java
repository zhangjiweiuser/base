package com.example.base.service;

import com.example.base.entity.UserOrgRelation;

import java.util.List;

public interface UserOrgRelationService {
    List<UserOrgRelation> getUserOrgRelation(String userId);
}
