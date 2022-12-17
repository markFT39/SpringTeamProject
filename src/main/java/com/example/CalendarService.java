package com.example;

import com.example.vo.CalendarVO;

import java.util.List;

public interface CalendarService {
    public int insertCalendar(CalendarVO vo);
    public int deleteCalendar(int seq);
    public int updateCalendar(CalendarVO vo);
    public int likeCalendar(int seq);
    public int dislikeCalendar(int seq);
    public CalendarVO getCalendar(int seq);
    public List<CalendarVO> getCalendarList();
    public List<CalendarVO> getUserList(String writer);
}
