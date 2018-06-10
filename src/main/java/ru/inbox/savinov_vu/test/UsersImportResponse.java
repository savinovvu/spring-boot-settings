package ru.inbox.savinov_vu.test;

public class UsersImportResponse {
    private int retryCount;
    private String status;


    public UsersImportResponse() {
    }


    public UsersImportResponse(int retryCount, String status) {
        this.retryCount = retryCount;
        this.status = status;
    }


    public int getRetryCount() {
        return retryCount;
    }


    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
