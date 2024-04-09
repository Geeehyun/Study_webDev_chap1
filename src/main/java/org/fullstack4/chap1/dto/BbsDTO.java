package org.fullstack4.chap1.dto;

import java.time.LocalDate;

public class BbsDTO {
    private int idx;
    private String user_id;
    private String title;
    private String content;
    private String display_date;
    private LocalDate reg_date;
    private LocalDate modify_date;
    private int readCnt;
    public int getIdx() {
        return idx;
    }
    public void setIdx(int idx) {
        this.idx = idx;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDisplay_date() {
        return display_date;
    }
    public void setDisplay_date(String display_date) {
        this.display_date = display_date;
    }
    public LocalDate getReg_date() {
        return reg_date;
    }
    public void setReg_date(LocalDate reg_date) {
        this.reg_date = reg_date;
    }
    public LocalDate getModify_date() {
        return modify_date;
    }
    public void setModify_date(LocalDate modify_date) {
        this.modify_date = modify_date;
    }
    public int getReadCnt() {
        return readCnt;
    }
    public void setReadCnt(int readCnt) {
        this.readCnt = readCnt;
    }
    @Override
    public String toString() {
        return "BbsDTO{" +
                "idx=" + idx +
                ", user_id='" + user_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", display_date='" + display_date + '\'' +
                ", reg_date=" + reg_date +
                ", modify_date=" + modify_date +
                ", readCnt=" + readCnt +
                '}';
    }
}
