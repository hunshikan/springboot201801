package com.xinrui.data.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "用户信息")
public class UserInfoDTO implements Serializable{

    @ApiModelProperty(value = "用户编号", position = 0)
    private String userId;

    @ApiModelProperty(value = "用户名", position = 1)
    private String userName;

    @ApiModelProperty(value = "登录密码, MD5 加密", position = 2)
    private String password;

    @ApiModelProperty(value = "状态： 0 有效； 1 无效", position = 3)
    private int status;

    @ApiModelProperty(value = "创建时间：格式（yyyy-MM-dd）", position = 4)
    private String createDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
