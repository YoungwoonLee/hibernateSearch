package com.chandler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chandler.domain.Contents;
import com.chandler.service.ContentsService;

@RestController
public class ContentsController {

	@Autowired
    private ContentsService contentsService;
	
	@GetMapping(value = "/api/contents")
	public List<Contents> getContentsList( @RequestParam(required = false) String keyword ) {
		List<Contents> contentsList = contentsService.searchContents(keyword);
		
		return contentsList;
	}
}
