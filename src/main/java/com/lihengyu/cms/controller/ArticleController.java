package com.lihengyu.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.lihengyu.cms.dao.ArticleRes;
import com.lihengyu.cms.domain.Article;
import com.lihengyu.cms.util.HLUtils;

@RequestMapping("article")
@Controller
public class ArticleController {
	
	@Autowired
	ArticleRes articleRes;
	
	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	
	@GetMapping("selects")
	public String selects() {
		return "admin/article/articles";
	}
	
	@RequestMapping("search")
	public String search(String key,Model model,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "2") Integer pageSize) {
//		List<Article> list = articleR/////////////////////////////////////es.findByTitle(key);
//		PageInfo<Article> info=new PageInfo<Article>(list);
//		model.addAttribute("info",info);
		
		//高亮
		PageInfo<Article> info = (PageInfo<Article>) HLUtils.findByHighLight(elasticsearchTemplate, Article.class, page, pageSize, new String[] {"title"}, "id", key);
		model.addAttribute("key",key);
		model.addAttribute("info",info);
		return "index/index";
	}
	
	
}
