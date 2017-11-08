package com.sda.springjavapoz4.service;

import com.sda.springjavapoz4.model.News;
import com.sda.springjavapoz4.repository.NewsRepository;
import com.sda.springjavapoz4.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class NewsService {

//    private List<News> newsList;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    public NewsService() {
//        this.newsList = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        newsRepository.save(getExampleNews());
        newsRepository.save(getExampleNews());

    }

    public List<News> getAllNews() {
        return StreamSupport.stream(newsRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public News getNews(int id) {
        return newsRepository.findOne((long) id);
    }

    private News getExampleNews() {
        return new News("Lorem",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab aperiam aut blanditiis, consectetur debitis dolorum exercitationem fugit id molestiae odio odit quasi quo tempora temporibus velit! Amet quia reiciendis sapiente!",
                LocalDate.now(), usersRepository.findOne((long)1));
    }

    public int saveNews(News news){
        return (int) newsRepository.save(news).getId();
    }

    public int addNewsWithUser(News news) {
        /*news.setAuthor(usersService.getRandomUser());
        newsRepository.save(news);
        return (int) newsRepository.count();*/
        return 1;
    }
}
