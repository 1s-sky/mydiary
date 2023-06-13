package com.diary.mydiary.Diary;

import com.diary.mydiary.Diary.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DiaryRestController {
    @Autowired
    private DiaryRepository repository;

    //위치가 바뀌면 바뀐 위치를 디비에 저장줌
    @PostMapping("/posData")
    public void PostData(@RequestParam Map<String, Object> vo) {
        repository.updatePosition(vo);
    }

    @PostMapping("/deleteDiary")
    public void DeleteDiary(@RequestParam Map<String, Object> vo) {
        repository.deleteDiary(vo);
    }

}
