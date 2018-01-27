package com.xinrui.service.impl;

import com.xinrui.data.dto.UserInfo;
import com.xinrui.data.model.UserInfoDTO;
import com.xinrui.service.BaseService;
import com.xinrui.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
}
