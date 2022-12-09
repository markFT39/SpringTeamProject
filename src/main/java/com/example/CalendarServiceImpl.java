package com.example;

import com.example.dao.CalendarDAO;
import com.example.dao.UserDAO;
import com.example.vo.CalendarVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {
    @Autowired
    CalendarDAO CalendarDAO;

    @Override
    public int insertCalendar(CalendarVO vo) { return CalendarDAO.insertCalendar(vo); }

    @Override
    public int deleteCalendar(int seq) {
        return CalendarDAO.deleteCalendar(seq);
    }

    @Override
    public int updateCalendar(CalendarVO vo) {
        return CalendarDAO.updateCalendar(vo);
    }

    @Override
    public int likeCalendar(int seq) { return CalendarDAO.likeCalendar(seq);}

    @Override
    public int dislikeCalendar(int seq) { return CalendarDAO.dislikeCalendar(seq);}

    @Override
    public CalendarVO getCalendar(int seq) {
        return CalendarDAO.getCalendar(seq);
    }

    @Override
    public List<CalendarVO> getCalendarList() {
        return CalendarDAO.getCalendarList();
    }
}
