package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "foo")
public class TaijCongfiguration {
	private String name;
	private int age;
	private FooProperties properties;
	@Override
	public String toString() {
		return "MyConfiguration [name=" + name + ", age=" + age + ", properties=" + properties + "]";
	}

}
