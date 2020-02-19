package com.lihengyu.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.lihengyu.cms.dao.ArticleRes;
import com.lihengyu.cms.domain.Article;
import com.lihengyu.cms.domain.ArticleWithBLOBs;
import com.lihengyu.cms.service.ArticleService;


public class MsgListence implements MessageListener<String,String> {
	
	@Autowired
	ArticleService service;
	
	@Autowired
	ArticleRes articleres;
	@Override
	public void onMessage(ConsumerRecord<String,String> data) {
		// TODO Auto-generated method stub
		String value = data.value();
		//System.err.println("接收到了！！");
		ArticleWithBLOBs parseObject = JSON.parseObject(value,ArticleWithBLOBs.class);
		//int ser = service.insertSelective(parseObject);
		PageInfo<Article> selects = service.selects(parseObject,1,10000);
		articleres.saveAll(selects.getList());
	}
}
