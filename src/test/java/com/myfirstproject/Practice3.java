package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Practice3 extends TestBase {
    @Test
    public void wikipediaTable(){

        extentTest.pass("1- Get the countr names and GDP, insert into map");
        driver.get("https://en.wikipedia.org/wiki/List_of_countries_by_GDP_(nominal)");

        List<WebElement> countries= driver.findElements(By.xpath("(//tbody)[3]//tr//td[1]"));
        List<WebElement> gdp= driver.findElements(By.xpath("(//tbody)[3]//tr//td[4]"));
        Map<String,String> countryGDP= new LinkedHashMap<>();

        for(int i= 0; i<countries.size(); i++){

            String countryName= countries.get(i).getText();
            String gdpOfCountry= gdp.get(i).getText();

            countryGDP.put(countryName, gdpOfCountry);
            writeToExcel(countryName,gdpOfCountry,i);
        }
        System.out.println(countryGDP);
    }

    public void writeToExcel(String a, String b, int c){

        try{
            String path= "C:\\Users\\Casper\\IdeaProjects\\MySeleniumProject\\src\\test\\java\\resorces\\Practice.xlsx";
            FileInputStream inputStream= new FileInputStream(path);
            Workbook workbook= WorkbookFactory.create(inputStream);
            Sheet sheet= workbook.getSheetAt(0);
            sheet.createRow(0).createCell(0).setCellValue("COUNTRY");
            sheet.getRow(0).createCell(1).setCellValue("GDP");
            sheet.createRow(c+1).createCell(0).setCellValue(a);
            sheet.getRow(c+1).createCell(1).setCellValue(b);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            workbook.write(fileOutputStream);

        }catch (IOException e){
            e.printStackTrace();

        }}}