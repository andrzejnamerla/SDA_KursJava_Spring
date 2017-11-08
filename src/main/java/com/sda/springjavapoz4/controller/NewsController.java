package com.sda.springjavapoz4.controller;


import com.sda.springjavapoz4.model.News;
import com.sda.springjavapoz4.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping
    public String saveNews(@ModelAttribute News news) {
        int indexNews = newsService.saveNews(news);
        return "redirect:/news/" + indexNews;
    }

    @GetMapping
    public ModelAndView getAllNews() {
        ModelAndView modelAndView = new ModelAndView("allNews");
        List<News> allNews = newsService.getAllNews();
        modelAndView.addObject("allNews", allNews);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getNews(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("news");
        News news = newsService.getNews(id);
        modelAndView.addObject("news", news);
        return modelAndView;
    }


}
