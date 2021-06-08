import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
public class AddSubcategory {
    public static void main(String[] args) throws IOException, InterruptedException {

        String name=null;
        String category= null;
        String images=null;

        //C:\\Users\\mvsrk\\Productiondata\\Categories\\CategoriesList.xlsx

        FileInputStream fis = new FileInputStream(new File("C:\\Users\\mvsrk\\Productiondata\\Categories\\CategoriesList.xlsx"));


        // FileInputStream fis = new FileInputStream(new File("C:\\Users\\mvsrk\\OneDrive\\Desktop\\student.xlsx"));
//creating workbook instance that refers to .xls file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
//creating a Sheet object to retrieve the object
        XSSFSheet sheet = wb.getSheetAt(2);
//evaluating cell type
        int lastrownumber = sheet.getLastRowNum();
        for(int i=1; i<=lastrownumber;i++){
            Row row =sheet.getRow(i);
            category=row.getCell(0).getStringCellValue();

            name=row.getCell(1).getStringCellValue();

            images=row.getCell(2).getStringCellValue();





            // Start Api Code
            RestAssured.useRelaxedHTTPSValidation();

            //baseURI = "https://staging.lagroce.com";
            baseURI = "https://production.lagroce.com";
            String endpoint = "/admin/add-sub-category";
            Map header = new HashMap();
            header.put("Content-Type", "multipart/form-data");
            header.put("Accept-Encoding", "gzip, deflate, br");
            header.put("Accept", "*/*");



            Response response = given().headers(header)

                    .param("name", name)
                    .param("category", category)
                    .multiPart("image", new File(images))

                    .when().post(endpoint);

            Thread.sleep(3000);

            System.out.println(response.asString());
            System.out.println(response.statusCode());

            // end api code
        }


    }
}
