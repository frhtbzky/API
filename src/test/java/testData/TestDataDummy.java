package testData;

import org.json.JSONObject;

public class TestDataDummy {

    public int basariliStatusCode = 200;
    public String contentType = "application/json";

    public JSONObject dataOlusturJSON(){

        JSONObject data = new JSONObject();

        data.put("id", 3);
        data.put("employee_name", "Ashton Cox");
        data.put("employee_salary", 86000);
        data.put("employee_age", 66);
        data.put("profile_image", "");

        return data;


    }


    public JSONObject expectedDataOlusturJSON(){


        JSONObject expData = new JSONObject();

        expData.put("status", "success");
        expData.put("data", dataOlusturJSON());
        expData.put("message", "Successfully! Record has been fetched.");

        return expData;

    }


}
