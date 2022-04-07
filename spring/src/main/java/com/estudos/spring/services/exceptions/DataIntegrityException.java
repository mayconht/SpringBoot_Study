package com.estudos.spring.services.exceptions;

public class DataIntegrityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DataIntegrityException(final String msg) {
        super(msg);

    }

    public DataIntegrityException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}
