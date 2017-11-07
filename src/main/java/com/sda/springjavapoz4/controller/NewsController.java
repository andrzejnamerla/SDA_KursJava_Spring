package com.sda.springjavapoz4.controller;


import com.sda.springjavapoz4.model.News;
import com.sda.springjavapoz4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/allNews")
    public ModelAndView getAllNews(){
        ModelAndView modelAndView = new ModelAndView("allNews");
        List<News> allNews = newsService.getAllNews();
        modelAndView.addObject("news", allNews);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getNews(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("news");
        News news = newsService.getNews(id);
        modelAndView.addObject("news", news);
        return modelAndView;
    }


}
