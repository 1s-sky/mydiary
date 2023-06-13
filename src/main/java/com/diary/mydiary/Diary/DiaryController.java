package com.diary.mydiary.Diary;

import com.diary.mydiary.Diary.DiaryRepository;
import com.diary.mydiary.model.Diary;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class DiaryController {
    @Autowired
    DiaryRepository repository;

    //일기추가하는 페이지
    @GetMapping("/addDiary")
    public String addDiary(Diary diary){
        return "addDiary";
    }
    //수정페이지로 이동
    @GetMapping("/updateMode")
    public String updateModeDiary(Model model, HttpServletRequest request){
        List<Diary> result = repository.findAll(request);
        model.addAttribute("diaryList", result);
        return "updateModeDiary";
    }

    @GetMapping("/updateDiary")
    public String updateDiary(Model model, HttpServletRequest request){
        String did = request.getParameter("did");
        Diary result = repository.findByDid(did,request).get();
        model.addAttribute("diary", result);
        return "updateDiary";
    }

    //추가된 일기 데이터 받아와서 디비에 저장
    //커맨드 객체 사용
    @PostMapping("/addDiary")
    public String addDiary_post(@Validated Diary diary, Errors errors, HttpServletRequest request){
        if(errors.hasErrors()){
            return "addDiary";
        }
        repository.addDiary(diary, request);
        return "redirect:loginHome";
    }

    @PostMapping("/updateDiary")
    public String updateDiary_post(@Validated Diary diary, Errors errors, HttpServletRequest request){
        if(errors.hasErrors()){
            return "updateDiary";
        }
        repository.updateText(diary);
        return "redirect:updateMode";
    }

    //로그인하면 로그인 페이지로 연결
    @GetMapping("/loginHome")
    public String home(Diary diary, Model model, HttpServletRequest request){
        List<Diary> result = repository.findAll(request);
        model.addAttribute("diaryList", result);

        return "loginHome";
    }
}
