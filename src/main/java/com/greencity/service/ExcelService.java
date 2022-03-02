package com.greencity.service;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/8/25/025 13:05
 */
public interface ExcelService {

    /**
     * 导入
     *
     * @return
     */
    Boolean importExcel(byte[] content);
}
