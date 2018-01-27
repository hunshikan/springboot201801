package com.xinrui.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Spring Boot应用程序在启动后，会遍历CommandLineRunner接口的实例并运行它们的run方法。
 * 也可以利用@Order注解（或者实现Order接口）来规定所有CommandLineRunner实例的运行顺序。
 */
@Component
@Order(value=1)
public class CommandLineRunnerDemo implements CommandLineRunner {

    /**
     * spring.profiles.active=${env_info}  配置
     * 在启动指令后添加参数： java -jar project.jar env_info -env_info=dev
     * spring会自动匹配  application-dev.properties 文件。
     *
     * 也可以直接 java -jar project.jar env_info -spring.profiles.active=dev
     */
    @Value("${server.port}")  //根据不同环境读取不同配置
    private int port;

    @Autowired
    private Environment env;  //读取环境变量

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 项目启动时执行
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception {

        logger.info(">>>>>>>>>>>>>>> Spring boot demo 示例 <<<<<<<<<<<<<<<");
        logger.info(">>>>>>>>>>>>>>> 根据指定不同配置文件获取对应的端口号 ：" + port + " <<<<<<<<<<<<<<<");
        logger.info("Environment 读取配置信息中的sql" + env.getProperty("sql.select"));
    }
}
