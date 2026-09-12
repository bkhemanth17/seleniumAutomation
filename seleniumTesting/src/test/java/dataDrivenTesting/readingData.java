package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingData {
    //reading data from excel

    //Excel file -> workbook -> sheets -> rows -> cells
    public static void main(String[] args) throws FileNotFoundException, IOException {

        //Excel file location(path)
        String fileLocation = System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\data.xlsx";
        FileInputStream file = new FileInputStream(fileLocation);

        //locating excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //locating sheet after finding excel workbook
        //XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //getting rows and columns
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int i =0; i<=rows; i++){
            XSSFRow currentRow = sheet.getRow(i);
            for(int j=0; j<cols; j++){
                XSSFCell cellData = currentRow.getCell(j);
                String data = cellData.toString();
                System.out.print(data+" \t");
                //System.out.println(data);
            }
            System.out.println(" ");
        }

        //close
        workbook.close();
        file.close();
    }
}
