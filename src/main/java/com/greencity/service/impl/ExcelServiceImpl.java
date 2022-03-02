package com.greencity.service.impl;


import com.greencity.service.ExcelService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/8/25/025 13:05
 */
@Service
public class ExcelServiceImpl implements ExcelService {


    @Override
    public Boolean importExcel(byte[] content) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
        XSSFWorkbook xssfWorkbook = null;
        try {
            xssfWorkbook = XSSFWorkbookFactory.createWorkbook(inputStream);
            XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
            int rowIndex = 0;
            for (Row row : sheet) {
                Sheet sheet1 = row.getSheet();
                int rowNum = row.getRowNum();
                if (row.getRowNum() == 1) {
                    for (int i = 0; i < row.getLastCellNum(); i++) {
                        Cell cell = row.getCell(i);
                        Row row1 = cell.getRow();

                    }

                }
            }
        }catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
