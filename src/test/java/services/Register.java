package services;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

public class Register {

    Response response;
    Faker faker=new Faker();

    public String userName;
    public String userID;


        /*
{
  "userName": "dd",
  "password": "dsfsdfs2323j"
}
 */

    public void userRegister(){

        String password= ConfigurationReader.get("commonPassword");
        userName=faker.name().fullName();


        Map<String,Object>body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);

        response= RestAssured.given().contentType(ContentType.JSON)
                .body(body).log().all()
                .when()
                .post("/Account/v1/User").prettyPeek();

        userID=response.path("userID");
        System.out.println("userID = " + userID);

    }


    public void verifyRegisterStatusCode(){

        response.then().statusCode(201);
    }





}
