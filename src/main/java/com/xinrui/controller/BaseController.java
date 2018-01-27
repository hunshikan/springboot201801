package com.xinrui.controller;

import com.xinrui.component.AuthorMapping;
import com.xinrui.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected UserInfoService userInfoService;

    /**
     * 映射配置文件
     */
    @Autowired
    protected AuthorMapping am;
}
