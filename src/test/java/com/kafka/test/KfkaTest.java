package com.kafka.test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.lihengyu.cms.dao.ArticleRes;
import com.lihengyu.cms.service.ChannelService;
import com.lihengyu.cms.util.ArticleWithBLOBs;
import com.lihengyu.cms.util.FileUtilIO;

import scala.util.matching.Regex.Match;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:producer.xml")
public class KfkaTest {
	
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	ChannelService service;
	
	@Autowired
	ArticleRes articleres;
	
	@Test
	public void testSend() throws Exception {
		File file=new File("E:/1708D2");
		File[] listFile=file.listFiles();
		for (File file2 : listFile) {
			String title = file2.getName().replace(".txt","");
			String context = FileUtilIO.readFile(file2,"utf8");
			ArticleWithBLOBs art=new ArticleWithBLOBs();
			art.setTitle(title);
			art.setContent(context);
			int min=1;
			int max=1000;
			int hits=min=(int) ((new Random().nextFloat()*(max-min)));
			art.setHits(hits);
			int round = (int) (Math.round(Math.random()*10)%2);
			art.setHot(round);
			int min1=1;
			int max1= service.getChannelCount();
			int charnnerId = (int) ((new Random().nextFloat()*(max1-min1)));
			art.setCategoryId(charnnerId);
			String jsonString = JSON.toJSONString(art);
			kafkaTemplate.send("1708D",jsonString);
			
		}	
	}
	
}
