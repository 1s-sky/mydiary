package com.diary.mydiary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DiaryRestController {
    @Autowired
    private DiaryDbRepository repository;

    //위치가 바뀌면 바뀐 위치를 디비에 저장줌
    @PostMapping("/postData")
    public void PostData(@RequestParam Map<String, Object> vo) {
        repository.updatePosition(vo);
    }

}
