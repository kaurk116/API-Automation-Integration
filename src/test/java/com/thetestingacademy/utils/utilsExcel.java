package com.thetestingacademy.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//open that FileInputStream
//Understand the workbook
//sheet
//Row
//Column
//Cell
//Close the Stream
@Test
public class utilsExcel {

    //It will be used by --DataProvide by TestNG
    public static String FILE_NAME="src/test/Resources/TD.xlsx";
    static Workbook book;
    static Sheet sheet;


    public  static  Object[][] getTestData(String sheetName){

        FileInputStream File =null;
        try{
            File =new FileInputStream(FILE_NAME);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            book=WorkbookFactory.create(File);

        }catch (IOException e){
            throw new RuntimeException(e);
        }
        //In java column ia call as cell
        sheet = book.getSheet(sheetName);
        Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
        for (int i = 0; i <sheet.getLastRowNum() ; i++) {
            for (int j = 0; j <sheet.getRow(1).getFirstCellNum() ; j++) {
                data[i][j] =sheet.getRow(i+1).getCell(j).toString();
                System.out.println("data "  +data);
            }

        }

        return data;
    }
    @DataProvider
    public Object[][] getData(){
        //In futule I can write logic tom select which sheet i want
        //Ask user which sheet 1 or sheet 2
        //Data .property -> sheet 1 or sheet 2
        //Shett 2 user for Staging server
        //Sheer 2 use for production
        return getTestData("sheet1");




    }

}
