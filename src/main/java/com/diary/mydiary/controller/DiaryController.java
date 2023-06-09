package com.diary.mydiary.controller;

import com.diary.mydiary.model.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DiaryController {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}
    //일기추가하는 페이지
    @GetMapping("/addDiary")
    public String addDiary(Diary diary){
        return "addDiary";
    }

    //추가된 일기 데이터 받아와서 디비에 저장
    @PostMapping("/addDiary")
    public String addDiary_post(Diary diary){
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("diary").usingGeneratedKeyColumns("did");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("uid", "aaa");
        parameters.put("title", diary.getTitle());
        parameters.put("text", diary.getText());
        parameters.put("xpos", 50);
        parameters.put("ypos", 50);
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        diary.setDid(key.intValue());
        return "redirect:loginHome";
    }

    //로그인하면 로그인 페이지로 연결
    @GetMapping("/loginHome")
    public String home(Diary diary, Model model){
        List<Diary> result = (List<Diary>) jdbcTemplate.query("Select * from diary where uid='aaa'", diaryRowMapper());
        model.addAttribute("diaryList", result);

        return "loginHome";
    }

    //위치가 바뀌면 바뀐 위치를 디비에 저장줌
    @PostMapping("/postData")
    public String PostData(@RequestParam Map<String, Object> vo){
        String sql="UPDATE diary SET xpos = ?, ypos = ? where did=?";
        String xpos = vo.get("xpos").toString();
        String ypos = vo.get("ypos").toString();
        int did = Integer.parseInt(vo.get("did").toString());
        int x = Integer.parseInt(xpos.split("p")[0]);
        int y = Integer.parseInt(ypos.split("p")[0]);
        jdbcTemplate.update(sql,x, y,did);
        return "postData";
    }

    private RowMapper<Diary> diaryRowMapper() {
        return (rs, rowNum) -> {
            Diary diary = new Diary();
            diary.setDid(rs.getInt("did"));
            diary.setTitle(rs.getString("title"));
            diary.setText(rs.getString("text"));
            diary.setXpos(rs.getInt("xpos"));
            diary.setYpos(rs.getInt("ypos"));
            return diary;
        };
    }
}
