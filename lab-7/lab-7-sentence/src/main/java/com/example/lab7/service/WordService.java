package com.example.lab7.service;

import com.example.lab7.domain.Word;

public interface WordService {
	Word getSubject();
	Word getVerb();
	Word getArticle();
	Word getAdjective();
	Word getNoun();
}
