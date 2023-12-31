package com.example.dao;

import com.example.bean.BoardRowMapper;
import com.example.bean.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int insertBoard(BoardVO vo){
		String sql = "insert into BOARD(title, writer, content, category,star,num) values("
				+"'"+vo.getTitle()+"',"
				+"'"+vo.getWriter()+"',"
				+"'"+vo.getContent()+"',"
				+"'"+vo.getCategory()+"',"
				+"'"+vo.getStar()+"',"
				+"'"+vo.getNum()+"')";
		return jdbcTemplate.update(sql);
	}

	public int deleteBoard(int seq){
		String sql = "delete from BOARD where seq = "+seq;
		return jdbcTemplate.update(sql);
	}

	public int updateBoard(BoardVO vo) {
		String sql = "update BOARD set "
				+ "title='" + vo.getTitle() + "',"
				+ "writer='" + vo.getWriter() + "',"
				+ "content='" + vo.getContent() + "',"
				+ "category='" + vo.getCategory() + "',"
				+ "star='" + vo.getStar() + "',"
				+ "num='" + vo.getNum() + "'"
				+ "where seq = " + vo.getSeq();
		return jdbcTemplate.update(sql);
	}

	public BoardVO getBoard(int seq){
		String sql = "select * from BOARD where seq="+seq;
		return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
	}

	public List<BoardVO> getBoardList(){
		String sql = "select * from BOARD order by regdate desc";
		return jdbcTemplate.query(sql, new BoardRowMapper());
	}
}
