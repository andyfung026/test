package com.greencity.controller;

import com.greencity.service.ExcelService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/8/25/025 13:02
 */
@RestController
@Slf4j
@RequestMapping("/excel/import")
public class ExcelImport {
    @Autowired
    public ExcelService excelService;

    @PostMapping("/import/reportForm")
    public Boolean importS3Result(@RequestParam("file") MultipartFile file) {
        try {
            byte[] content = file.getBytes();
            return excelService.importExcel(content);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
