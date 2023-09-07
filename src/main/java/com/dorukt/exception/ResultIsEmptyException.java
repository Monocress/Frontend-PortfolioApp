package com.dorukt.exception;

import lombok.Getter;

@Getter
public class ResultIsEmptyException extends RuntimeException {

    private final EerrorType type;

    public ResultIsEmptyException(EerrorType type) {
        super(type.getMesaj());
        this.type = type;
    }

    public ResultIsEmptyException(EerrorType type, String mesaj) {
        super(mesaj);
        this.type = type;
    }
}
