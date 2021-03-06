package com.example.lab7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {
	@Autowired
	WordService wordService;

	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence = String.format("%s %s %s %s %s.", wordService.getSubject().getString(),
				wordService.getVerb().getString(), wordService.getArticle().getString(),
				wordService.getAdjective().getString(), wordService.getNoun().getString());		
		return sentence;
	}
	
}
