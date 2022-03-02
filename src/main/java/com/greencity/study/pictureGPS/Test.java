package com.greencity.study.pictureGPS;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/9/10/010 17:32
 */
public class Test {
    public static void main(String[] args)throws Exception {
        //创建Excel，读取文件内容
        File file=new File("H:\\Haier\\iHaier文件\\test3.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(FileUtils.openInputStream(file));
        //两种方式读取工作表
        // Sheet sheet=workbook.getSheet("Sheet0");
        Sheet sheet=workbook.getSheetAt(0);
        //获取sheet中最后一行行号
        int lastRowNum=sheet.getLastRowNum();
        String value = "";
        for (int i=1;i<=lastRowNum;i++){
            Row row=sheet.getRow(i);
            //获取当前行最后单元格列号
            int lastCellNum=row.getLastCellNum();
            for (int j=0;j<lastCellNum;j++){
                Cell cell=row.getCell(j);
                if (cell != null && j==0) {
                    cell.setCellType(CellType.STRING);
                    value=cell.getStringCellValue();
                    System.out.print(value+") ");
                }
                if (cell != null && j==1) {
                    cell.setCellType(CellType.STRING);
                    value=cell.getStringCellValue();
                    System.out.print(value+": ");
                }
                if (cell != null&& j==2) {
                    cell.setCellType(CellType.STRING);
                    value=cell.getStringCellValue();
                    System.out.print(value+"吨， ");
                }
                if (cell != null&& j==3) {
                    cell.setCellType(CellType.STRING);
                    value=cell.getStringCellValue();
                    System.out.print("利润："+value+"万元  ");
                }

            }
           // System.out.println("-");
        }
    }
}
