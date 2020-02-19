package com.bawei.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.lihengyu.cms.dao.ArticleRes;
import com.lihengyu.cms.domain.Article;
import com.lihengyu.cms.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class TestImportIDB2Es {//测试导入MySQL数据

	
	@Autowired
	ArticleService service;
	
	@Autowired
	ArticleRes articleres;
	@Test
	public void testImportMysQl() {
		//1.从MySQL中查询所有文章信息(已经审核通过的)
		Article article = new Article();
		article.setStatus(1);
		PageInfo<Article> selects = service.selects(article, 1, 10000);
		articleres.saveAll(selects.getList());
	}
	
}
