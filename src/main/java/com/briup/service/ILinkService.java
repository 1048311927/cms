package com.briup.service;

import java.util.List;

import com.briup.bean.Link;
import com.briup.exception.CustomerException;


public interface ILinkService {
	public void saveOrUpdate(Link link) ;
	public List<Link> findAll();
	public Link findById(Integer id) throws CustomerException;
	public void deleteById(Integer id);
}
