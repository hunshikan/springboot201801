package com.xinrui.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * spring boot（版本1.5.1.RELEASE）中
 * @ConfigurationProperties注解已将location属性移除
 *
 * 可以修饰方法
 */
@Component
@ConfigurationProperties(prefix = "author")
@PropertySource(value = "classpath:/author.properties",encoding = "UTF-8")
public class AuthorMapping {

    private String name;
    private String sex;
    private String date;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "AuthorMapping{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", date='" + date + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
