package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseURL {

    /*
    Oncelikle class level da instance bir variable olusturuyoruz.
    fakat bunun data type'i RequestSpecification olacak.

    child class'lardan specJsonPlace'e ulasabilmek icin protected yapiyorum.


    class levelda variable olusturup, before methodumun icinde de atama gerceklestiriyorum.

    RequestSpecification bir interface'dir.

     */

    protected RequestSpecification specJsonPlace;


    @Before
    public void setUp(){

        specJsonPlace = new RequestSpecBuilder()
                                .setBaseUri("https://jsonplaceholder.typicode.com")
                                .build();

    }

}
