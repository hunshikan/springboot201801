package com.xinrui.repository.daoImpl;

import com.xinrui.data.dto.UserInfo;
import com.xinrui.repository.BaseDao;
import com.xinrui.repository.UserInfoDao;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {


    private List<UserInfo> getUserData(){
        List<UserInfo> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId("NO.0" + i);
            userInfo.setUserName(i/2 == 0? "A" + i + "A": "B" + i + "B");
            userInfo.setPassword(UUID.randomUUID().toString().toUpperCase());
            userInfo.setStatus(i == 7? 0 : 1);
            userInfo.setCreateDate(LocalDate.now().toString());
            list.add(userInfo);
        }
        return list;
    }

    /**
     * 通过用户编号获取用户信息
     * @param userId
     * @return
     */
    @Override
    public UserInfo getUserInfoByUserId(String userId) {
        logger.info("Get user info by user id");
        if (StringUtils.isEmpty(userId)){
            return null;
        }
        Optional<UserInfo> first = getUserData().stream().filter(x -> userId.equals(x.getUserId())).findFirst();
        return first.isPresent()? first.get():null;
    }

    @Override
    public List<UserInfo> getUserInfoByUserName(String userName) {
        return null;
    }

    @Override
    public List<UserInfo> getUserInfoByCreateDate(String createDate) {
        return null;
    }
}
