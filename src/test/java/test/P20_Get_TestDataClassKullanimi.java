package test;

import baseUrl.DummyBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class P20_Get_TestDataClassKullanimi extends DummyBaseURL {

    @Test

    public void get01(){

        // 1 - Url ve request body hazirla

        specDummy.pathParams("pp1", "api", "pp2", "v1", "pp3", "employee", "pp4", 3);


        // 2 - Expected Data hazirla


        TestDataDummy testDataDummy = new TestDataDummy();

        JSONObject expData = testDataDummy.expectedDataOlusturJSON();


        // 3 - Response'i kaydet

        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

        response.prettyPrint();


        // 4 - Assertion

        JsonPath respJP = response.jsonPath();

        assertEquals(testDataDummy.basariliStatusCode, response.getStatusCode());
        assertEquals(testDataDummy.contentType, response.contentType());



        assertEquals(expData.getJSONObject("data").get("id"), respJP.get("data.id"));
        assertEquals(expData.getJSONObject("data").get("employee_name"), respJP.get("data.employee_name"));
        assertEquals(expData.getJSONObject("data").get("employee_salary"), respJP.get("data.employee_salary"));
        assertEquals(expData.getJSONObject("data").get("employee_age"), respJP.get("data.employee_age"));
        assertEquals(expData.getJSONObject("data").get("profile_image"), respJP.get("data.profile_image"));


        assertEquals(expData.get("status"), respJP.get("status"));
        assertEquals(expData.get("message"), respJP.get("message"));



    }

}
