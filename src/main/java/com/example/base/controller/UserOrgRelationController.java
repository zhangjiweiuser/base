package com.example.base.controller;

import com.example.base.service.UserOrgRelationService;
import com.example.base.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserOrgRelationController {
    @Autowired
    private UserOrgRelationService userOrgRelationService;

    @GetMapping("getById")
    public ResponseVO getUserOrgRelation(String userId) {
        return ResponseVO.success(userOrgRelationService.getUserOrgRelation(userId));
    }
}
