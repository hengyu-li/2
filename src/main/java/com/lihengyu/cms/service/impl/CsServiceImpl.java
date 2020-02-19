package com.lihengyu.cms.service.impl;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lihengyu.cms.dao.CsMapper;
import com.lihengyu.cms.domain.Cs;
import com.lihengyu.cms.service.CsService;

@Service
public class CsServiceImpl implements CsService {
	
	@Autowired
	CsMapper mapper;

	

	@Override
	public int add(Cs cs) {
		// TODO Auto-generated method stub
		return mapper.add(cs);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return mapper.del(id);
	}

	@Override
	public PageInfo select(Cs cs,Integer page,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,pageSize);
		List<Cs> list=mapper.select(cs);
		PageInfo<Cs> info=new PageInfo<Cs>(list);
		return info;
	}

}
