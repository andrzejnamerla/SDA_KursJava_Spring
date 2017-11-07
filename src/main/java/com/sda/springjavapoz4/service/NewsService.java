package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsService {

    private List<News> newsList;

    @Autowired
    private UsersService usersService;


    public NewsService(){
        this.newsList = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        //this.newsList.add();
    }

    public List<News> getAllNews(){
        return newsList;
    }

    public News getNews(int id){
        return id >= newsList.size() ? null : newsList.get(id);
    }

}
