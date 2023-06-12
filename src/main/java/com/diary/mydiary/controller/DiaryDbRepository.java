package com.diary.mydiary.controller;

import com.diary.mydiary.model.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class DiaryDbRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}


    //CREATE
    public void addDiary(Diary diary){
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
    }

    //READ
    public List<Diary> findAll(){
        List<Diary> result = (List<Diary>) jdbcTemplate.query("Select * from diary where uid='aaa'", diaryRowMapper());
        return result;
    }

    //UPDATE
    //x,y값 업데이트
    public void updatePosition(Map<String, Object> vo){
        String sql="UPDATE diary SET xpos = ?, ypos = ? where did=?";
        String xpos = vo.get("xpos").toString();
        String ypos = vo.get("ypos").toString();
        int did = Integer.parseInt(vo.get("did").toString());
        int x = Integer.parseInt(xpos.split("p")[0]);
        int y = Integer.parseInt(ypos.split("p")[0]);
        jdbcTemplate.update(sql,x, y,did);
    }

    //diary 내용수정
    public void updateText(Diary diary){
        String sql="UPDATE diary SET title = ?, text = ? where did=?";
        int did = diary.getDid();
        String title = diary.getTitle();
        String text = diary.getText();
        jdbcTemplate.update(sql, title, text,did);
    }


    //DELETE
    public void deleteDiary(Diary diary) {
        String sql = "";
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
