package Utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelDataProvider {
    XSSFWorkbook wb;

    public ExcelDataProvider(){
        File src = new File("./TestData/loginuserdata.xlsx");

        try{
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);

        } catch (Exception e) {
            System.out.println("unable to read excel file"+ e.getMessage());
        }
    }

    //create read data methods
    public String getStringData(int sheetIndex, int row, int coloum){
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(coloum).getStringCellValue();
    }

}
