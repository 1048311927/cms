package com.briup.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.Link;
import com.briup.exception.CustomerException;
import com.briup.service.ILinkService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(description = "链接管理")
@RestController
@RequestMapping("/link")
public class LinkController {
	@Autowired
	private ILinkService linkService;
	@ApiOperation("保存或更新链接,如果id为空则为保存,否则为更新")
	@PutMapping("saveOrUpdate")
	public Message<String> saveOrUpdate(Link link){
		try {
			System.out.println(link);
			linkService.saveOrUpdate(link);
		} catch (Exception e) {
			return MessageUtil.error(500, "参数为空");
		}
		
		return MessageUtil.success("保存成功");
		} 
	@GetMapping("/findAll")
	@ApiOperation("查询所有链接信息")
	public Message<List<Link>> findAll(){
		List<Link> linklist = linkService.findAll();
		return MessageUtil.success(linklist);
		
	}
	@GetMapping("/findById")
	@ApiOperation("根据id查询链接信息")
	@ApiImplicitParam(name ="id",value = "链接id",paramType = "query",required = true)
	public Message<Link> findById(Integer id){
		try {
			Link link = linkService.findById(id);
			return MessageUtil.success(link);
			
		} catch (Exception e) {
			
			return MessageUtil.error(500, "id不存在");
		}
		
		
		
	}
	@DeleteMapping("/deleteById")
	@ApiOperation("根据id删除链接")
	@ApiImplicitParam(name = "id",value = "链接id",paramType = "query",required = true)
	public Message<String> deleteById(Integer id){
		try {
			linkService.deleteById(id);
			return MessageUtil.success("删除成功");
		} catch (Exception e) {
			return MessageUtil.error(500, "id不存在");
			
		}
		
	}
}
