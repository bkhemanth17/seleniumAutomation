package dataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class manualDataWrite {
    //manual data writing operation
    /*first it will check the file is present in the location or not,
    if the file present it will insert the data
    if the data is also present it will update the data
     */
    //excel file -> workbook -> sheet -> row -> cells

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\myFile.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);

        //workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //sheet
        XSSFSheet sheet = workbook.createSheet("data");

        //sending data into rows and cols

        //row1 and data
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("java");
        row1.createCell(1).setCellValue(20);
        row1.createCell(2).setCellValue("automation");

        //row2 and data
        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("python");
        row2.createCell(1).setCellValue(3);
        row2.createCell(2).setCellValue("development");

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("javaScript");
        row3.createCell(1).setCellValue(15);
        row3.createCell(2).setCellValue("automation");

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
