package com.lihengyu.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lihengyu.cms.domain.Cs;

public interface CsService {
	
	PageInfo select(Cs cs,Integer page,Integer pageSize);//查询
	
	int add(Cs cs);//添加
	
	int del(int id);//删除

}
