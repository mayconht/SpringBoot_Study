package com.estudos.spring.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer status;
    private String msg;
    private Long timeStamp;


    public StandardError(final Integer status, final String msg, final Long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(final Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
