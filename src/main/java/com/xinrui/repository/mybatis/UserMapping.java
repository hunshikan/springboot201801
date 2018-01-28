package com.xinrui.repository.mybatis;

import com.xinrui.data.dto.UserMybatis;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapping {

    List<UserMybatis> getUser();
}
