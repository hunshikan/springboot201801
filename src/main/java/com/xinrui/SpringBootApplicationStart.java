package com.xinrui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
@MapperScan(basePackages = {"com.xinrui.repository.mybatis"})
public class SpringBootApplicationStart {

	public static void main(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));  //设置时区
		Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
		SpringApplication.run(SpringBootApplicationStart.class, args);
	}
}
