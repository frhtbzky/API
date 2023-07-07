package test;

import baseUrl.HeroKuappBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P16_BaseUrlHerokuAppIndividual extends HeroKuappBaseURL {


    @Test
    public void get01(){

        // 1 - Url hazirla

        specHerokuApp.pathParam("pp1", "booking");

        // Response'i kaydet

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();


        // 4 - Assertion

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(12));



    }



    @Test
    public void post01(){

        // 1 - Url ve request body hazirla

        specHerokuApp.pathParam("pp1", "booking");


        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");


        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingdates);
        reqBody.put("additionalneeds", "wi-fi");


        System.out.println("reqBody = " + reqBody);


        // 2 - Expecte Data hazirla


        // 3 - Response'i kaydet

        Response response = given().spec(specHerokuApp).contentType(ContentType.JSON).when().post("/{pp1}");
        response.prettyPrint();


        // 4 - Assertion

        response
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("firstname", Matchers.equalTo("Ahmet"));

    }
}
