package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class PostsAssertionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        HashMap<String, Object> qParam = new HashMap<>();
        qParam.put("page","1");
        qParam.put("per_page","25");
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2/";
        response = given()
                .queryParams(qParam)
                .when()
                .get("/users")
                .then().statusCode(200);
    }
    //1. Verify the if the total record is 25
    @Test
    public void test001(){
        response.body("id.size", equalTo(25));
}
    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto
//centum.”
    @Test
    public void test002(){
response.body("find{it.id= 57457}.title",equalTo("Conturbo terminatio patria tantum tardus sit."));

    }
    //3. Check the single user_id in the Array list (5522)
    @Test
    public void test003(){
        response.body("find{it.id=57455}.user_id",equalTo("57455"));

    }
    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test004(){
        response.body("data.id",hasItems("57437",
                "57436",
                "57435"));
    }
    //5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
//spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
//Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
//Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
//antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
//cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
//adflicto. Assentator umquam pel."”
    @Test
    public void test005(){
response.body("findall{it.userid=4123671}.body",equalTo("Aperte universe amaritudo. Ambitus defendo civis. Teres confugo defessus. Sit exercitationem arguo. Alienus vinco asperiores. Conduco confugo credo. Commemoro culpa accedo. Audentia voluptatibus venia. Cotidie tolero vulgaris. Tersus quia trans. Validus vulgaris depromo. Virtus animadverto vitium. Curvus suggero suffragium. Toties qui sub. Umbra repudiandae vulariter. Textus claustrum tam. Teres carbo alius."));

    }
}








