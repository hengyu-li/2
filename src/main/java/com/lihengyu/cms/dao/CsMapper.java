package com.lihengyu.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lihengyu.cms.domain.Cs;

public interface CsMapper {
	
	List<Cs> select(Cs cs);//查询
	
	int add(@Param("cs")Cs cs);//添加
	
	int del(@Param("id")int id);//删除

}
