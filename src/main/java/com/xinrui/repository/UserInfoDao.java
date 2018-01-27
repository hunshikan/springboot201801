package com.xinrui.repository;

import com.xinrui.data.dto.UserInfo;

import java.util.List;

public interface UserInfoDao {

    /**
     * 通过用户编号获取用户信息
     * @param userId
     * @return
     */
    UserInfo getUserInfoByUserId(String userId);

    List<UserInfo> getUserInfoByUserName(String userName);

    List<UserInfo> getUserInfoByCreateDate(String createDate);
}
