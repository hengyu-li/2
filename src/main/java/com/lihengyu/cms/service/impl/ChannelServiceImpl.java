package com.lihengyu.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lihengyu.cms.dao.CategoryMapper;
import com.lihengyu.cms.dao.ChannelMapper;
import com.lihengyu.cms.domain.Category;
import com.lihengyu.cms.domain.Channel;
import com.lihengyu.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelMapper channerMapper;
	
	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Channel> selects() {
		return channerMapper.selects();
	}

	@Override
	public List<Category> selectsByChannelId(Integer channelId) {
		// TODO Auto-generated method stub
		return categoryMapper.selectsByChannelId(channelId);
	}

	@Override
	public int getChannelCount() {
		// TODO Auto-generated method stub
		return channerMapper.getChannelCount();
	}

}
