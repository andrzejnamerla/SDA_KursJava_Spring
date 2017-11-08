package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
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
        this.newsList.add(getExampleNews());
        this.newsList.add(getExampleNews());
        this.newsList.add(getExampleNews());
        this.newsList.add(getExampleNews());
        this.newsList.add(getExampleNews());

    }

    public List<News> getAllNews(){
        return newsList;
    }

    public News getNews(int id){
        return id >= newsList.size() ? null : newsList.get(id);
    }

    private News getExampleNews(){
        return new News(1,"Lorem",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aperiam aut blanditiis, consectetur debitis dolorum exercitationem fugit id molestiae odio odit quasi quo tempora temporibus velit! Amet quia reiciendis sapiente!",
                LocalDate.now(), usersService.getExampleUser());
    }

    public int addNews(News news) {
        news.setAuthor(usersService.getRandomUser());
        newsList.add(news);
        return newsList.size()-1;
    }
}
