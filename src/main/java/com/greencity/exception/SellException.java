package com.greencity.exception;

import com.greencity.enums.ResultEnum;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/8/008 11:56
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
