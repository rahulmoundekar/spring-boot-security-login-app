package com.boot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.app.domain.Article;
import com.boot.app.repo.IUserInfoDAO;
@Service
public class UserInfoService implements IUserInfoService {
	@Autowired
	private IUserInfoDAO userInfoDAO;
	@Override
	public List<Article> getAllUserArticles(){
		return userInfoDAO.getAllUserArticles();
	}
}
