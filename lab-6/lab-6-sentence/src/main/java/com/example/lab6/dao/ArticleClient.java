package com.example.lab6.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lab6.domain.Word;

@FeignClient("ARTICLE")
public interface ArticleClient {

	@GetMapping("/")
	public Word getWord();

}
