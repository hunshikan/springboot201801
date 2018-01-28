package com.xinrui.data.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserMybatisDTO implements Serializable {

   // @JsonProperty(value = "pid")
    @ApiModelProperty(value = "编号", position = 1)
    private String hahaha;

  //  @JsonProperty(value = "pname")
    @ApiModelProperty(value = "名字", position = 2)
    private String name;

   // @JsonProperty(value = "age")
    @ApiModelProperty(value = "年龄", position = 3)
    private String age;

   // @JsonProperty(value = "sex")
    @ApiModelProperty(value = "性别", position = 4)
    private String sex;

   // @JsonProperty(value = "aid")
    @ApiModelProperty(value = "编号", notes = "老师编号", position = 5)
    private String aid;

    public String getHahaha() {
        return hahaha;
    }

    public void setHahaha(String hahaha) {
        this.hahaha = hahaha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
