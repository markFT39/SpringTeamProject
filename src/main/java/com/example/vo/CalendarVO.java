package com.example.vo;

import java.sql.Timestamp;
import java.util.Date;

public class CalendarVO {
    private int seq;
    private String schedule_name;
    private String writer;
    private String content;
    private String start_date;
    private String end_date;
    private int user_like;
    private int user_dislike;
    private int voting_status;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getSchedule_name() {
        return schedule_name;
    }

    public void setSchedule_name(String schedule_name) {
        this.schedule_name = schedule_name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getUser_like() {
        return user_like;
    }

    public void setUser_like(int user_like) {
        this.user_like = user_like;
    }

    public int getUser_dislike() {
        return user_dislike;
    }

    public void setUser_dislike(int user_dislike) {
        this.user_dislike = user_dislike;
    }

    public int getVoting_status() {
        return voting_status;
    }

    public void setVoting_status(int voting_status) {
        this.voting_status = voting_status;
    }
}
