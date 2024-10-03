package com.luv2code.demo.rest;

public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStamps;

    public StudentErrorResponse(){

    }
    public StudentErrorResponse(int status, String message, long timeStamps) {
        this.status = status;
        this.message = message;
        this.timeStamps = timeStamps;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamps() {
        return timeStamps;
    }

    public void setTimeStamps(long timeStamps) {
        this.timeStamps = timeStamps;
    }
}
