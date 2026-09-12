package dataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class dynamicDataWriting {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Application.xlsx";
        FileOutputStream outputStream= new FileOutputStream(filePath);

        //workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //sheet
        XSSFSheet sheet = workbook.createSheet("info");

        //input
        Scanner sc = new Scanner(System.in);

        //row
        System.out.print("rows: ");
        int row = sc.nextInt();

        //cols
        System.out.print("cols: ");
        int cols = sc.nextInt();

        //loop
        for(int r=0; r<=row; r++){
            XSSFRow rows = sheet.createRow(r);
            for (int c=0; c<cols; c++){
                XSSFCell cell = rows.createCell(c);
                System.out.print("enter value: ");
                cell.setCellValue(sc.next());
            }
        }
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
