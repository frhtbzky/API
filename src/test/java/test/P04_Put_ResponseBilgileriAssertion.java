package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P04_Put_ResponseBilgileriAssertion {


 /*
        https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde

                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
                }

        donen Response’un,

            status code’unun 200,
            ve content type’inin application/json; charset=utf-8,
            ve Server isimli Header’in degerinin cloudflare,
            ve status Line’in HTTP/1.1 200 OK
      */



    @Test
    public void put01(){



        // 1 - url ve request body


        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject jsonBody = new JSONObject();


        jsonBody.put("title","Ahmet");
        jsonBody.put("body","Merhaba");
        jsonBody.put("userId",10);
        jsonBody.put("id",70);


        // 2 - Expected Data hazirla


        // 3 - Response'i kaydet

        /*
        eger bir request body gondereceksek contenttype'i
        belirtmek zorundayiz. pre condition dedigimiz on kosullari
        hemen given()'dan sonra yapiyoruz.


        API'de calistiracagimiz kodlar given() ile basliyor.
         */

        Response response = given()
                                .contentType(ContentType.JSON)
                            .when()
                                .body(jsonBody.toString())
                                .put(url);

        response.prettyPrint();



        // 4 - Assertion


        response
                .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json; charset=utf-8")
                    .header("Server", "cloudflare")
                    .statusLine("HTTP/1.1 200 OK");


    }

}
