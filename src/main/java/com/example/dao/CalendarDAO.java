package com.example.dao;

import com.example.vo.CalendarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CalendarDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertCalendar(CalendarVO vo) {
        String sql = "insert into Calendar (title, writer, content, category) values ("
                + "'" + vo.getSchedule_name() + "',"
                + "'" + vo.getWriter() + "',"
                + "'" + vo.getContent() + "',"
                + "'" + vo.getStart_date() + "',"
                + "'" + vo.getEnd_date() + "',"
                + "'" + vo.getVoting_status() + "')";
        return jdbcTemplate.update(sql);
    }

    public int deleteCalendar(int seq) {
        String sql = "delete from Calendar where seq = " + seq;
        return jdbcTemplate.update(sql);
    }

    public int updateCalendar(CalendarVO vo) {
        String sql = "update Calendar set schedule_name = '" + vo.getSchedule_name() + "',"
                + "writer = '" + vo.getWriter() + "',"
                + "content = '" + vo.getContent() + "',"
                + "start_date = '" + vo.getStart_date() + "',"
                + "end_date = '" + vo.getEnd_date() + "',"
                + "user_like = '" + vo.getUser_like() + "',"
                + "user_dislike = '" + vo.getUser_dislike() + "',"
                + "voting_status = '" + vo.getVoting_status() + "' where seq =" + vo.getSeq();
        return jdbcTemplate.update(sql);
    }

    class CalendarRowMapper implements RowMapper<CalendarVO> {
        @Override
        public CalendarVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            CalendarVO vo = new CalendarVO();
            vo.setSeq(rs.getInt("seq"));
            vo.setSchedule_name(rs.getString("schedule_name"));
            vo.setWriter(rs.getString("writer"));
            vo.setContent(rs.getString("content"));
            vo.setStart_date(rs.getDate("start_date"));
            vo.setEnd_date(rs.getDate("end_date"));
            vo.setUser_like(rs.getInt("user_like"));
            vo.setUser_dislike(rs.getInt("user_dislike"));
            vo.setVoting_status(rs.getBoolean("voting_status"));
            return vo;
        }
    }

    public CalendarVO getCalendar(int seq) {
        String sql = "select * from Calendar where seq = " + seq;
        return jdbcTemplate.queryForObject(sql, new CalendarRowMapper());
    }

    public List<CalendarVO> getCalendarList() {
        String sql = "select * from Calendar order by start_date desc";
        return jdbcTemplate.query(sql, new CalendarRowMapper());
    }
}