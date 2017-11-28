package com.example;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 5.	定义一个TaijCongfiguration,利用FooProperties的所有属性(包括集合等)
 * @author gj
 *
 */
@Data
@Component
public class FooProperties {
		private String username;
		private String password;
		private List list;
}
