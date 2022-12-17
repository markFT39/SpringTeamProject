package com.example.dao;

import com.example.vo.CalendarVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalendarDAO {
    @Autowired
    SqlSession sqlSession;

    public int insertCalendar(CalendarVO vo) {
        int result = sqlSession.insert("Calendar.insertCalendar", vo);
        return result;
    }

    public int deleteCalendar(int seq) {
        int result = sqlSession.delete("Calendar.deleteCalendar", seq);
        return result;
    }

    public int updateCalendar(CalendarVO vo) {
        int result = sqlSession.update("Calendar.updateCalendar", vo);
        return result;
    }

    public int likeCalendar(int seq) {
        int result = sqlSession.update("Calendar.likeCalendar", seq);
        return result;
    }

    public int dislikeCalendar(int seq) {
        int result = sqlSession.update("Calendar.dislikeCalendar", seq);
        return result;
    }

    public CalendarVO getCalendar(int seq) {
        CalendarVO one = sqlSession.selectOne("Calendar.getCalendar", seq);
        return one;
    }

    public List<CalendarVO> getCalendarList() {
        List<CalendarVO> list = sqlSession.selectList("Calendar.getCalendarList");
        return list;
    }

//    public static String getPhotoFilename(int seq) {
//        String filename = null;
//        try {
//            CalendarVO one = sqlSession.selectOne("Calendar.getCalendar", seq);
//            filename = one.getPhoto();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
//        return filename;
//    }
}


/*
@Repository
public class CalendarDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insertCalendar(CalendarVO vo) {
        String sql = "insert into Calendar (schedule_name, writer, content, start_date, end_date, voting_status) values ("
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
                //+ "user_like = '" + vo.getUser_like() + "',"
                //+ "user_dislike = '" + vo.getUser_dislike() + "',"
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
            vo.setStart_date(rs.getString("start_date"));
            vo.setEnd_date(rs.getString("end_date"));
            vo.setUser_like(rs.getInt("user_like"));
            vo.setUser_dislike(rs.getInt("user_dislike"));
            vo.setVoting_status(rs.getInt("voting_status"));
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
 */
