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
public class AddProduct {
    public static void main(String[] args) throws IOException, InterruptedException {

        String slug=null;
        String name=null;
        String description=null;
        String category=null;
        String sub_category=null;
        double actual_price=0.0;
        double discount_amount=0.0;
        double final_price=0.0;
        String images=null;
        double units=0.0;

        //C:\\Users\\mvsrk\\Productiondata\\Categories\\CategoriesList.xlsx

        FileInputStream fis = new FileInputStream(new File("C:\\Users\\mvsrk\\Productiondata\\products\\productsdetails prod.xlsx"));


        // FileInputStream fis = new FileInputStream(new File("C:\\Users\\mvsrk\\OneDrive\\Desktop\\student.xlsx"));
//creating workbook instance that refers to .xls file
        XSSFWorkbook wb = new XSSFWorkbook(fis);
//creating a Sheet object to retrieve the object
        XSSFSheet sheet = wb.getSheet("saiteja");
               // .getSheetAt(3);
//evaluating cell type
        int lastrownumber = sheet.getLastRowNum();
        for(int i=1; i<=lastrownumber;i++){
            Row row =sheet.getRow(i);

            slug=row.getCell(0).getStringCellValue();
            name =row.getCell(1).getStringCellValue();
            description=row.getCell(2).getStringCellValue();
            category=row.getCell(3).getStringCellValue();
            sub_category =row.getCell(4).getStringCellValue();
            actual_price=row.getCell(5).getNumericCellValue();
            discount_amount=row.getCell(6).getNumericCellValue();
            final_price =row.getCell(7).getNumericCellValue();
            images=row.getCell(8).getStringCellValue();
                    units=row.getCell(9).getNumericCellValue();









            // Start Api Code
            RestAssured.useRelaxedHTTPSValidation();

            //baseURI = "https://staging.lagroce.com";
            baseURI = "https://production.lagroce.com";
            String endpoint = "/admin/add-product";
            Map header = new HashMap();
            header.put("Content-Type", "multipart/form-data");
            header.put("Accept-Encoding", "gzip, deflate, br");
            header.put("Accept", "*/*");


            Response response = given().headers(header)
                    .param("slug", slug)
                    .param("name", name)
                    .param("description", description)
                    .param("category", category)
                    .param("sub_category", sub_category)
                    .param("actual_price", actual_price)
                    .param("discount_amount", discount_amount)
                    .param("final_price", final_price)
                    .multiPart("images", new File(images))
                    .param("units", units)

                    .when().post(endpoint);

            System.out.println(response.asString());
            System.out.println(response.statusCode());

            Thread.sleep(3000);
            System.out.println("product number"+i);
            System.out.println(response.asString());
            System.out.println(response.statusCode());

            // end api code
        }


    }
}
