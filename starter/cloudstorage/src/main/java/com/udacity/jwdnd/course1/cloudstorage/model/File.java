package com.udacity.jwdnd.course1.cloudstorage.model;

//CREATE TABLE IF NOT EXISTS FILES (
//        fileId INT PRIMARY KEY auto_increment,
//        filename VARCHAR,
//        contenttype VARCHAR,
//        filesize VARCHAR,
//        userid INT,
//        filedata BLOB,
//        foreign key (userid) references USERS(userid)
//        );
public class File {
    private Integer fileId;
    private String filename;
    private String contentype;
    private  String filesize;
    private Integer UserId;
    private byte[] filedata;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentype() {
        return contentype;
    }

    public void setContentype(String contentype) {
        this.contentype = contentype;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }
}
