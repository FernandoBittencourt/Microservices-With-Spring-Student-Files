package com.example.lab6.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.lab6.domain.Word;

@FeignClient("ADJECTIVE")
public interface AdjectiveClient {

	@GetMapping("/")
	public Word getWord();

}
