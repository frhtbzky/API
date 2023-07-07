package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class P07_Get_BodyTekrarlardanKurtulma {

 /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,

                status code’unun 200,
                ve content type’inin application/json; charset=utf-8,
                ve response body’sindeki

                    "firstname“in,"Susan",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 673,
                    ve "depositpaid“in,false,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */


    @Test
    public void get01(){

        // 1 - url ve request body

        String url = "https://restful-booker.herokuapp.com/booking/10";


        // 2 - Expected Data hazirla



        // 3 - Response'i kaydet

        Response response = given().when().get(url);
        response.prettyPrint();


        // 4 - Assertion

        response
                .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json; charset=utf-8")
                    .body("firstname", equalTo("Susan"),
                            "lastname", equalTo("Wilson"),
                            "totalprice", equalTo(219));


    }
}
