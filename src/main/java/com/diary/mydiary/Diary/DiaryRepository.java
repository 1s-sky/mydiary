package com.diary.mydiary.Diary;

import com.diary.mydiary.model.Diary;
import com.diary.mydiary.model.AuthInfo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DiaryRepository {

    private final JdbcTemplate jdbcTemplate;
    public DiaryRepository(DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource);}

    //CREATE
    public void addDiary(Diary diary, HttpServletRequest request){
    	
    	HttpSession session = request.getSession(false);
    	AuthInfo currentUser = (AuthInfo) session.getAttribute("authinfo");
    	
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("diary").usingGeneratedKeyColumns("did");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("uid", currentUser.getId());
        parameters.put("title", diary.getTitle());
        parameters.put("text", diary.getText());
        parameters.put("xpos", 100);
        parameters.put("ypos", 100);
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        diary.setDid(key.intValue());
    }

    //READ
    public List<Diary> findAll(HttpServletRequest request){
    	HttpSession session = request.getSession(false);
    	AuthInfo currentUser = (AuthInfo) session.getAttribute("authinfo");
        
    	List<Diary> result = (List<Diary>) jdbcTemplate.query("Select * from diary where uid=?", diaryRowMapper(),currentUser.getId());
    	return result;
    }

    public Optional<Diary> findByDid(String did, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        AuthInfo currentUser = (AuthInfo) session.getAttribute("authinfo");

        List<Diary> result = (List<Diary>) jdbcTemplate.query("Select * from diary where uid=? and did=?", diaryRowMapper(),currentUser.getId(),did);
        return result.stream().findAny();
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
    public void deleteDiary(Map<String, Object> vo) {
        String sql = "DELETE FROM diary WHERE did=?";
        int did = Integer.parseInt(vo.get("did").toString());
        jdbcTemplate.update(sql,did);
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
