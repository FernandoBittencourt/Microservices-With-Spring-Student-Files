package com.example.lab7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lab7.dao.AdjectiveClient;
import com.example.lab7.dao.ArticleClient;
import com.example.lab7.dao.NounClient;
import com.example.lab7.dao.SubjectClient;
import com.example.lab7.dao.VerbClient;
import com.example.lab7.domain.Word;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WordServiceImpl implements WordService{
	@Autowired 
	VerbClient verbClient;
	
	@Autowired 
	SubjectClient subjectClient;
	
	@Autowired 
	ArticleClient articleClient;
	
	@Autowired 
	AdjectiveClient adjectiveClient;
	
	@Autowired 
	NounClient nounClient;
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public Word getSubject() {
		return subjectClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackVerb")
	public Word getVerb() {
		return verbClient.getWord();
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackArticle")
	public Word getArticle() {
		return articleClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackAdjective")
	public Word getAdjective() {
		return nounClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod="getFallbackNoun")
	public Word getNoun() {
		return nounClient.getWord();
	}
	
	public Word getFallbackSubject() {
		return new Word("Someone");
	}
	
	public Word getFallbackVerb() {
		return new Word("do");
	}
	
	public Word getFallbackArticle() {
		return new Word("");
	}
	
	public Word getFallbackAdjective() {
		return new Word("");
	}
	
	public Word getFallbackNoun() {
		return new Word("something");
	}
}
