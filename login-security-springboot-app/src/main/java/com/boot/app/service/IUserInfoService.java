package com.boot.app.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.boot.app.domain.Article;

public interface IUserInfoService {
	 @Secured ({"ROLE_ADMIN"})
     List<Article> getAllUserArticles();
}
