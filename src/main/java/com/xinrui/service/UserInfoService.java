package com.xinrui.service;

import com.xinrui.data.model.UserInfoDTO;
import com.xinrui.data.model.UserMybatisDTO;

import java.util.List;

public interface UserInfoService {

    UserInfoDTO getUserInfoByUserId(String userId);

    List<UserMybatisDTO> getUser();

}
