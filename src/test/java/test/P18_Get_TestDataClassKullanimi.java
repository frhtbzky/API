package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseURL {

    @Test
    public void get01(){

        // 1 - Url ve request body hazirla

        specJsonPlace.pathParams("pp1", "posts", "pp2", 22);

        // 2 - Expected Data hazirla

        /*
        class'i JsonPlaceHolderBaseURL'e extends ettik. testData class'inda olusturdugumuz
        objeye nasil ulasacagiz? O class uzerinden bir obje olusturmak cozum bu noktada.
         */

        TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace();

        JSONObject expData = testDataJsonPlace.expectedBodyOlusturJSON();
        // bu class icinde method ile call ettigim JSONObje'yi kullanabilmek istiyorsam
        // atama gerceklestirmemiz gerekir. datatype JSONObject olmak zorunda.


        // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");

        response.prettyPrint();



        // 4 - Assertion

        /*
        benim donen response body'imi JUnit'in Assertleri ile Assert edebilmem icin
        once JsonPath'e donusturmem gerekiyor.
         */

        JsonPath respJP = response.jsonPath();

        assertEquals(testDataJsonPlace.basariliStatusCode, response.getStatusCode());
        assertEquals(expData.get("userId"), respJP.get("userId"));
        assertEquals(expData.get("id"), respJP.get("id"));
        assertEquals(expData.get("title"), respJP.get("title"));
        assertEquals(expData.get("body"), respJP.get("body"));


    }
}
