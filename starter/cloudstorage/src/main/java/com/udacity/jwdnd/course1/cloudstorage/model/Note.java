package com.udacity.jwdnd.course1.cloudstorage.model;

//CREATE TABLE IF NOT EXISTS NOTES (
//        noteid INT PRIMARY KEY auto_increment,
//        notetitle VARCHAR(20),
//        notedescription VARCHAR (1000),
//        userid INT,
//        foreign key (userid) references USERS(userid)
//        );
public class Note {
    private Integer noteId;
    private String notetitle;
    private String notedescription;
    private Integer userId;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }

    public String getNotedescription() {
        return notedescription;
    }

    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
