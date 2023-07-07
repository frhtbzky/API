package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P01_Get_ApiSorgulama {

/*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.

     */

    @Test
    public void get01(){


        // 1 - Url ve request body

        String url = "https://restful-booker.herokuapp.com/booking/10";



        // 2 - Expected Data


        // 3 - Response kaydet

        Response response = given().when().get(url);
        response.prettyPrint();


        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("content type : " + response.getContentType());
        System.out.println("status Line : " + response.getStatusLine());
        System.out.println("response suresi : " + response.getTime());
        System.out.println("server header degeri : " + response.getHeader("Server"));

    }

}
