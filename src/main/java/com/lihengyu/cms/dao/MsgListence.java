package com.lihengyu.cms.dao;

import java.sql.Date;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public class MsgListence implements MessageListener<String,String> {

	@Override
	public void onMessage(ConsumerRecord<String,String> data) {
		// TODO Auto-generated method stub
		String msg=data.value();
		System.err.println(msg);
	}

}
