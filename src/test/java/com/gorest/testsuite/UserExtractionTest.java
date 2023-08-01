package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        HashMap<String, Object> qParam = new HashMap<>();
        qParam.put("page", "1");
        qParam.put("per_page", "20");
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2/";
        response = given()
                .queryParams(qParam)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //Extract the All Ids
    @Test
    public void test001() {
        List<Integer>  id =  response.extract().path("id");
        System.out.println(" id :"+id);
    }
//2. Extract the all Names
@Test
public void test002() {
       List<String> name= response.extract().path("name");
    System.out.println("All Names :"+name);
}
//3. Extract the name of 5th object
@Test
public void test003() {
        response.extract().path("name[4]");
    }
//4. Extract the names of all object whose status = inactive
@Test
public void test004() {
       List<HashMap<String,?>> name = response.extract().path("status==inactive");
    System.out.println("Names :"+name);
}

//5. Extract the gender of all the object whose status = active
    @Test
public void test005() {
    List<HashMap<String, ?>> gender = response.extract().path("data.findAll{it.status==active}.gender");
    System.out.println("Names :" + gender);
}
//6. Print the names of the object whose gender = female
    @Test
        public void test006()
    {
        List<String> name = response.extract().path("data.findAll{it.gender==female}.name");
        System.out.println(" Name For all gender -Female :"+name);
    }
//7. Get all the emails of the object where status = inactive
@Test
public void test007() {
       List<String> email= response.extract().path("data.findAll{it.status=='inactive'}.email") ;
    System.out.println("All emails  whose status =inactive  :"+email);
}
//8. Get the ids of the object where gender = male

//9. Get all the status
//10. Get email of the object where name == Karthik Dubashi IV
//11. Get gender of id = 5471
    @Test
    public void test0011(){
     HashMap<String,?>  TypeOfGen= response.extract().path("id==57457");
     String  gender=(String)TypeOfGen.get("id");}
}























