package com.xinrui.service.impl;

import com.alibaba.fastjson.JSON;
import com.xinrui.data.dto.UserInfo;
import com.xinrui.data.dto.UserMybatis;
import com.xinrui.data.model.UserInfoDTO;
import com.xinrui.data.model.UserMybatisDTO;
import com.xinrui.service.BaseService;
import com.xinrui.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoServiceImpl extends BaseService implements UserInfoService {

    @Override
    public UserInfoDTO getUserInfoByUserId(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        UserInfo userInfo = userInfoDao.getUserInfoByUserId(userId);

        if (userInfo != null){
            UserInfoDTO userInfoDto = new UserInfoDTO();
            userInfoDto.setUserId(userInfo.getUserId());
            userInfoDto.setUserName(userInfo.getUserName());
            userInfoDto.setStatus(userInfo.getStatus());
            userInfoDto.setPassword(userInfo.getPassword());
            userInfoDto.setCreateDate(userInfo.getCreateDate());
            return userInfoDto;
        }
        return null;
    }


    /**
     * 通过mybatis 查询数据库的user信息
     * @return
     */
    @Override
    public List<UserMybatisDTO> getUser(){

        List<UserMybatis> user = userMapping.getUser();
        if (CollectionUtils.isEmpty(user)){
            new ArrayList<>();
        }

        String str = JSON.toJSONString(user);
        List<UserMybatisDTO> result = (List<UserMybatisDTO>) JSON.parse(str);

        return result;

    }
}
