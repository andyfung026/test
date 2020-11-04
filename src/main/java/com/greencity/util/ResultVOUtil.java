package com.greencity.util;

import com.greencity.vo.ProductVO;
import com.greencity.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object o) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(o);
        return resultVO;
    }


    public static ResultVO success() {
        return success(null);
    }


    public static ResultVO error(Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(message);
        return resultVO;
    }
}
