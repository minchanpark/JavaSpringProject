package com.example.bean;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardVO> {

    public BoardVO mapRow(ResultSet rs, int RowNum) throws SQLException{
        BoardVO vo = new BoardVO();
        vo.setSeq(rs.getInt("seq"));
        vo.setTitle(rs.getString("title"));
        vo.setContent(rs.getString("content"));
        vo.setWriter(rs.getString("writer"));
        vo.setCategory(rs.getString("category"));
        vo.setStar(rs.getString("star"));
        vo.setNum(rs.getString("num"));
        vo.setRegdate(rs.getDate("regdate"));
        return vo;
    }
}
