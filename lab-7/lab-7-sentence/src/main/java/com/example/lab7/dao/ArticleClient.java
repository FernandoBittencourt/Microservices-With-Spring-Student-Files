package com.example.lab7.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lab7.domain.Word;

@FeignClient("ARTICLE")
public interface ArticleClient {

	@GetMapping("/")
	public Word getWord();

}
