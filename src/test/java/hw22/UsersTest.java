package hw22;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UsersTest {

    @Test
    public void getUsers() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        JsonPath jsonPath = given().
                when().get("/users").
                then().statusCode(200).extract().body().jsonPath();

        System.out.println("Printing all emails: " + jsonPath.getList("email"));

        System.out.println("Printing all zipcodes: " + jsonPath.getList("address.zipcode"));

        System.out.println("Printing zipcodes with no dash: " + jsonPath.get("findAll{ it.address.zipcode =~ /^[^-]+$/ }.address.zipcode"));

        List<String> names = jsonPath.getList("name");
        List<String> lats = jsonPath.get("address.geo.lat");
        List<String> lngs = jsonPath.get("address.geo.lng");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " is situated at: lat = " + lats.get(i) + " and lng = " + lngs.get(i));
        }


        System.out.println("Printing usernames with negative lat and lng: " + jsonPath.getString("findAll{ it.address.geo.lat.contains('-') && it.address.geo.lng.contains('-')}.username"));


        List<Map<String, Object>> websitesInfo = jsonPath.getList("findAll { it.website.endsWith('info') }");

        for (Map<String, Object> websiteInfo : websitesInfo) {
            String username = (String) websiteInfo.get("username");
            String website = (String) websiteInfo.get("website");
            System.out.println(username + " - " + website);
        }


        System.out.println("Printing name with the largest lng: " + jsonPath.getString("max{ it.address.geo.toInteger}.name"));

        System.out.println("Printing name with the longest catchPhrase: " + jsonPath.getString("max{ it.company.catchPhrase.size()}.name"));

    }
}
