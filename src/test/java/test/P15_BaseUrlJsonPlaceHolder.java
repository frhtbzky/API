package test;

import baseUrl.JsonPlaceHolderBaseURL;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;

public class P15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseURL {


@Test
public void get01(){


    // 1 - Url hazirla

    specJsonPlace.pathParam("pp1", "posts");

    // 2 - Expected Data hazirla


    // 3 - Response'i kaydet

    /*

    artik string olarak tanimlanmis bir url yok.
    artik bizim icin pre-condition var. her zaman spec() methodunu
    cagitacagim artik.

     */
    Response response = given().spec(specJsonPlace).when().get("/{pp1}");
    response.prettyPrint();


    // 4 - Asserion

    response
            .then()
                .assertThat()
                .statusCode(200)
                .body("title", hasSize(100));

    }


    @Test
    public void get02(){

    // 1 - Url hazirla

        specJsonPlace.pathParams("pp1", "posts", "pp2", 44);


    // 2 - Expected Data hazirla


    // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

    // 4 - Assertion

        response
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("title", equalTo("optio dolor molestias sit"));




    }

    @Test
    public void delete01(){

    // 1 - url hazirla

        specJsonPlace.pathParams("pp1", "posts", "pp2", 50);

    // 2 - Expected Data hazirla



    // 3 - Response'i kaydet

        Response response = given().spec(specJsonPlace).when().delete("/{pp1}/{pp2}");

        response.prettyPrint();


    // 4 - Assertion

        response
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("title", nullValue());

    }

}
