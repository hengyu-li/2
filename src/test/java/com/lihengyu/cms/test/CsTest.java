package com.lihengyu.cms.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lihengyu.cms.domain.Cs;
import com.lihengyu.cms.service.CsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class CsTest {
	@Autowired
	CsService service;
	
	@Test()
	public void select() {//查询
		List<Cs> cs=new ArrayList<Cs>();
		service.select(null, 0, null);
	}
	
	@Test
	public void add() {
		Cs c=new Cs();
		c.setTitle("21345");
		c.setUrl("http//12489");
		c.setUid(181);
		c.setCreated("2020-02-18");
		service.add(c);
	}
	
	@Test
	public void del() {
		service.del(2);
	}
}
