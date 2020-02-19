package com.kafka.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lihengyu.cms.dao.ArticleRes;
import com.lihengyu.cms.dao.MsgListence;
import com.lihengyu.cms.service.ArticleService;

import scala.runtime.MegaMethodCache;

public class KafkaJieShou {
	
	@Autowired
	MsgListence msglistence;
	
	@Autowired
	public ArticleRes res;
	
	@Autowired
	ArticleService service;
	
	public static void main(String[] args) {
		
		new ClassPathXmlApplicationContext("classpath:consumer.xml");
		
	}

}
