package com.bishe.appletshopserver.model.response;

/**
 * @Author
 * @Description
 * @Date 2019/5/10
 * @Modify
 */
public class CommonResponse<T>{
    private int total;
    private T content;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "total=" + total +
                ", content=" + content +
                '}';
    }
}