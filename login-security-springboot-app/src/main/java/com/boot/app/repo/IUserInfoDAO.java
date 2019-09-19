package com.boot.app.repo;
import java.util.List;

import com.boot.app.domain.Article;
import com.boot.app.domain.UserInfo;
public interface IUserInfoDAO {
	UserInfo getActiveUser(String userName);
	List<Article> getAllUserArticles();
}