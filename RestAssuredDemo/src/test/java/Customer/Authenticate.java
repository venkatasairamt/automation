package Customer;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.ws.Response;
import java.util.HashMap;
import java.util.Map;

public class Authenticate {

    @BeforeClass
    public  void config(){
       baseURI="https://staging.lagroce.com";

        RestAssured.useRelaxedHTTPSValidation();
    }


    @Test
    public void authenticate(){

        String endpoint ="/user/authenticate";

        Map<String,String> headers = new HashMap<String,String>();

        headers.put("Content-Type","application/json");

        Map<String,String> requestBody = new HashMap<String,String>();

        requestBody.put("email","venkatasai@lagroce.com");
        requestBody.put("password","lagroce@");




      ResponseBody response=  RestAssured.given().headers(headers).body(requestBody).when().post(endpoint).getBody();

        System.out.println(response.asString());

    }
}
