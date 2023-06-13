package com.diary.mydiary.controller;

import com.diary.mydiary.model.Diary;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class DiaryController {
    @Autowired
    DiaryDbRepository repository;
    //일기추가하는 페이지
    @GetMapping("/addDiary")
    public String addDiary(Diary diary){
        return "addDiary";
    }

    @GetMapping("/updatediary")
    public String updateDiary(Model model, HttpServletRequest request){
        List<Diary> result = repository.findAll(request);
        model.addAttribute("diaryList", result);
        return "updateDiary";
    }

    //추가된 일기 데이터 받아와서 디비에 저장
    @PostMapping("/addDiary")
    public String addDiary_post(Diary diary, HttpServletRequest request){
        repository.addDiary(diary, request);
        return "redirect:loginHome";
    }

    //로그인하면 로그인 페이지로 연결
    @GetMapping("/loginHome")
    public String home(Diary diary, Model model, HttpServletRequest request){
        List<Diary> result = repository.findAll(request);
        model.addAttribute("diaryList", result);

        return "loginHome";
    }
}
