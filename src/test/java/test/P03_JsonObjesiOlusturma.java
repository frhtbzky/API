package test;

import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.junit.Test;

public class P03_JsonObjesiOlusturma {

 /*
     Asagidaki JSON Objesini olusturup konsolda yazdirin.
     
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }

     */


    @Test
    public void jsonObje01() {


        JSONObject ilkJsonObje = new JSONObject();


        ilkJsonObje.put("title", "Ahmet");
        ilkJsonObje.put("body", "Merhaba");
        ilkJsonObje.put("userId", 1);

        System.out.println("ilkJsonObje : " + ilkJsonObje);


    }


    @Test
    public void jsonObje02() {

        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                                },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */


        JSONObject bookingdates = new JSONObject();


        bookingdates.put("checkin","2018-01-01");
        bookingdates.put("checkout","2019-01-01");



        JSONObject outerjson = new JSONObject();

        outerjson.put("firstname","Jim");
        outerjson.put("additionalneeds","Breakfast");
        outerjson.put("totalprice",111);
        outerjson.put("depositpaid",true);
        outerjson.put("lastname","Brown");
        outerjson.put("bookingdates",bookingdates);


        System.out.println("bookingJsonObjesi :  " + outerjson);




    }

    /*
                {
                 "firstname":"Ferhat",
                 "additionalneeds":"Jakuzi",
                 "bookingdates":{
                         "checkin":"2023-06-20",
                         "checkout":"2023-06-26"
                                },
                  "totalprice":250,
                  "depositpaid":true,
                  "lastname":"Bozkaya"
                  }
         */

    @Test
    public void newJson01(){



        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin","2023-06-20");
        bookingdates.put("checkout","2023-06-26");

        System.out.println("bookingdates : " + bookingdates);





        JSONObject disYapi = new JSONObject();

        disYapi.put("firstname","Ferhat");
        disYapi.put("additionalneeds","Jakuzi");
        disYapi.put("totalprice",250);
        disYapi.put("depositpaid",true);
        disYapi.put("lastname","Bozkaya");
        disYapi.put("bookingdates", bookingdates);


        System.out.println("disYapi : " + disYapi);

    }

}
