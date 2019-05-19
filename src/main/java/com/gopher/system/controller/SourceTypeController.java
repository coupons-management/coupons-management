package com.gopher.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopher.system.controller.model.Result;
import com.gopher.system.model.entity.CpType;
import com.gopher.system.service.TypeService;

@RestController
@RequestMapping("/sourceType")
public class SourceTypeController {
	@Autowired
	private TypeService typerService;
	
	@RequestMapping(path="/getList")
	public Result getList() {
		Result result = new Result();
		result.setData(typerService.getList());
		return result;
	}
	
	@RequestMapping(path="/create")
	public Result create(@RequestBody CpType cpType) {
		Result result = new Result();
		typerService.create(cpType);
		return result;
	}
	
	@RequestMapping(path="/edit")
	public Result edit(@RequestBody CpType cpType) {
		Result result = new Result();
		typerService.edit(cpType);
		return result;
	}
	
	@RequestMapping(path="/delete")
	public Result delete(int id) {
		Result result = new Result();
		typerService.delete(id);
		return result;
	}

}
