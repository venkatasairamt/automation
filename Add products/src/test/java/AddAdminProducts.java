import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AddAdminProducts {

    @BeforeTest
    public void beforeTest() {

        RestAssured.useRelaxedHTTPSValidation();

        baseURI = "https://staging-api.lagroce.com";
    }



    @Test
    public void admin_add_product(String slug, String name, String description, String category, String sub_category, String price, String discount_amount, String final_price, String images, String units) {
        String endpoint = "/admin/add-product";
        Map header = new HashMap();
        header.put("Content-Type", "multipart/form-data");
        header.put("Accept-Encoding", "gzip, deflate, br");
        header.put("Accept", "*/*");


        Response response = given().headers(header)
                .param("slug", "1")
                .param("name", "Tamamto")
                .param("description", "Tamamto fresh")
                .param("category", "605d7a08fb11c6140799b482")
                .param("sub_category", "605d7dd5fb11c6140799b483")
                .param("price", "20")
                .param("discount_amount", "10")
                .param("final_price", "10")
                .multiPart("images", new File("C:\\Users\\USER\\Desktop\\Images\\bringal.jpg"))
                .param("units", "100")

                .when().post(endpoint);

        System.out.println(response.asString());
        System.out.println(response.statusCode());


    }
//End /admin/add-product

}
