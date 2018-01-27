package com.xinrui.redis;

import com.xinrui.repository.UserInfoDao;
import com.xinrui.utils.RedisTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheTests {
    @Autowired
    private RedisTools redisTools;
    @Autowired
    private UserInfoDao userInfoDao;

    //  “：” 存入redis的数据可以分组管理
    private static final String PREFIX = "spring:";
    private static final String CONTENT = "redis:";
    private static final String KEY1 = "S_1000";

    @Test
    public void setKey(){

        //简单存入
        redisTools.set(PREFIX + CONTENT + KEY1, "demo");

        //5秒过期
        redisTools.set(PREFIX + CONTENT + "time", "demo",5);

        boolean exists = redisTools.exists(PREFIX + CONTENT + "time");  //测试 key 是否存在
        System.out.println(exists);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        exists = redisTools.exists(PREFIX + CONTENT + "time"); //等待6秒是否过期
        System.out.println(exists);
    }

    @Test
    public void deleteKey(){
        redisTools.delete(PREFIX + CONTENT + KEY1);
    }

    @Test
    public void deleteKeyPattern() {
        redisTools.deleteLikePattern("S");  //模糊匹配删除
    }


}
