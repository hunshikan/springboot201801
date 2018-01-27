package com.xinrui.config.cache;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableCaching  //缓存注解
@Import(value = {RedisCacheConfig.class})  //导入配置类
public class CacheConfigBase {


}
