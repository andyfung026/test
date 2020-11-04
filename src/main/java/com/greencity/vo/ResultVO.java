package com.greencity.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    //错误码
    private Integer Code;

    //提示信息
    private String message;

    //返回内容
    private T Data;

}
