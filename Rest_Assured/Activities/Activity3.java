package activities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Activity3 {
	
	RequestSpecification requestSpec=new RequestSpecBuilder()
			.setContentType(ContentType.JSON)
			.setBaseUri("https://petstore.swagger.io/v2/pet")
			.build();
	
	ResponseSpecification responseSpec=new ResponseSpecBuilder()
			.expectStatusCode(200)
			.expectContentType(ContentType.JSON)
			.expectBody("status", equalTo("alive"))
			.build();
	
	@DataProvider (name="petInfo")
	public Object[][] petInfoProvider(){
		Object[][] testData=new Object[][] {
			{77232, "Riley", "alive"},
			{77233, "Hansel", "alive"}
		};
		return testData;
	}
	
  @Test (priority=1, dataProvider="petInfo")
  public void addPets(int petId, String petName, String petStatus) {
	  
	  Map<String, Object> reqBody=new HashMap<>();
	  reqBody.put("id", petId);
	  reqBody.put("name", petName);
	  reqBody.put("status", petStatus);
	  
	  Response response=given().log().all().spec(requestSpec).body(reqBody).when().post();
	  
	  response.then().spec(responseSpec).body("name", equalTo(petName));
	    
  }
  
  @Test (priority=2, dataProvider="petInfo")
  public void getPets(int petId, String petName, String petStatus) {
	  
	  Response response=given().log().all()
			  .spec(requestSpec).pathParam("petId", petId)
			  .when().get("/{petId}");
	  
	  response.then().spec(responseSpec)
	  .body("id", equalTo(petId))
	  .body("name", equalTo(petName))
	  .body("status", equalTo(petStatus))
	  .log().all();
  }
  
  @Test (priority=3, dataProvider="petInfo")
  public void deletePets(int petId, String petName, String petStatus) {
	  
	  Response response=given().log().all()
			  .spec(requestSpec).pathParam("petId", petId)
			  .when().delete("/{petId}");
	  
	  String body=response.getBody().asPrettyString();
	  System.out.println(body);
	  
	  response.then()
	 .body("code", equalTo(200))
	 .body("message", equalTo("" +petId));
  }
  
  
}
