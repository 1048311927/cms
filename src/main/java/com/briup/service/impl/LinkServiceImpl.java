package com.briup.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Link;
import com.briup.dao.LinkDao;
import com.briup.exception.CustomerException;
import com.briup.service.ILinkService;

@Service
public class LinkServiceImpl implements ILinkService{
	@Autowired
	private LinkDao linkDao;
	@Override
	public void saveOrUpdate(Link link)  {
		if(link != null ) {
			Integer id = link.getId();
			if(id == null) {
				linkDao.save(link);
			}else{
				//根据id查询link
				Link link_db = linkDao.findById(id).get();
				if(link.getName() != null ) {
					link_db.setName(link.getName());
				}
				if(link.getUrl() != null) {
					link_db.setUrl(link.getUrl());
				}
				linkDao.save(link_db);
			}
		}else {
			throw new CustomerException(500, "参数为空");
		} 
		
	}
	@Override
	public List<Link> findAll() {
		List<Link> linklist = linkDao.findAll();
		return linklist;
	}
	@Override
	public Link findById(Integer id) throws CustomerException {
		 Link link = linkDao.findById(id).get();
		return link;
	}
	@Override
	public void deleteById(Integer id) {

		linkDao.deleteById(id);
	}

}
