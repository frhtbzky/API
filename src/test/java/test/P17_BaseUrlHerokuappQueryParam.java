package test;

import baseUrl.HeroKuappBaseURL;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P17_BaseUrlHerokuappQueryParam extends HeroKuappBaseURL {


    @Test
    public void get01(){

        // 1 - url hazirla

        specHerokuApp.pathParam("pp1", "booking");

        // 2 - Expected Data hazirla


        // 3 - Response'i kaydet

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();


        // 4 - Assertion

        response
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("bookingid", Matchers.hasItem(1006));

    }


    @Test
    public void get02(){

        // 1 - url hazirla

        specHerokuApp.pathParam("pp1", "booking").queryParam("firstname", "Eric");

        // 3 - Response'i kaydet

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();

        // 4 Assertion

        response
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("bookingid", Matchers.hasSize(3));


    }


    @Test
    public void get03(){

        // 1 - Url hazirla

        specHerokuApp.pathParam("pp1", "booking")
                        .queryParams("firstname", "Jim", "lastname", "Jackson");


        // 3 - Response'i kaydet

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");
        response.prettyPrint();

        // Assertion

       response
               .then()
                    .assertThat()
                    .statusCode(200)
                    .body("bookingid", Matchers.hasSize(2));



    }


}
