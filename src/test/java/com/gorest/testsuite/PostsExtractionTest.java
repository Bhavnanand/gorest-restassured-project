package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        HashMap<String, Object> qParam = new HashMap<>();
        qParam.put("page","1");
        qParam.put("per_page","20");
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2/";
        response = given()
                .queryParams(qParam)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Extract the title
    @Test
    public void test001(){

    }
    //2. Extract the total number of record
    @Test
    public void test002(){
int records =response.extract().path("size");
        System.out.println("Total no of Records :"+records);
    }
    //3. Extract the body of 15th record
       @Test
    public void test003(){
        response.extract().path("[14]");
           System.out.println();
       }
    //4. Extract the user_id of all the records
    @Test
    public void test004(){
        List<Double> User_id =response.extract().path("user_id");
        System.out.println("User id of all the records :"+User_id);
    }
    //5. Extract the title of all the records
    @Test
    public void test005(){
        HashMap<String ,?>  title=response.extract().path("[*].title");
        System.out.println("Title :"+title);
    }
    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void test006(){
        List<String> Title =    response.extract().path("data.findAll{it.user_id=='5456'}.title");
        System.out.println("title of all records whose user_id = 5456  :"+Title);
    }
    //7. Extract the body of all records whose id = 2671
    @Test
    public void test007(){
     List<String>body=    response.extract().path("data.findAll{it.id=='2671'}.body");
        System.out.println(" body of all records whose id = 2671 :"+body);
    }
}
