package activities;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {
	
	String BASE_URI="https://petstore.swagger.io/v2/pet";
	
  @Test (priority=1)
  public void addNewPet() {
	  String reqBody="""
	  		{
                 "id": 77232,
                 "name": "Riley",
                 "status": "alive"
            } 
	  		""";
	  
	  Response response= given().contentType(ContentType.JSON)
			  .body(reqBody).when().post(BASE_URI);
	  
	  String body=response.getBody().asPrettyString();
	  System.out.println(body);	 
	  
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
	  
//	  JsonPath jsonPath=response.jsonPath();
//	  String id=jsonPath.getString("id");
//	  String name=jsonPath.getString("name");
//	  String status=jsonPath.getString("status");
//	  
//	  assert id.equals("77232"): "ID doesn't match";
//	  assert name.equals("Riley"): "Name doesn't match";
//	  assert status.equals("alive"): "Status doesn't match";
  }
  
  @Test (priority=2)
  public void getNewPet() {
	  
	  int petId=77232;
	  
	  Response response=given().contentType(ContentType.JSON)
			  .when().pathParam("petId", petId).get(BASE_URI + "/{petId}");
	  
	  String body=response.getBody().asPrettyString();
	  System.out.println(body);	 
	  
	  response.then().body("id", equalTo(77232));
	  response.then().body("name", equalTo("Riley"));
	  response.then().body("status", equalTo("alive"));
	  
  }
  
  @Test (priority=3)
  public void deleteNewPet() {
	  
      int petId=77232;
	  
	  Response response=given().contentType(ContentType.JSON)
			  .when().pathParam("petId", petId).delete(BASE_URI + "/{petId}");
	  
	  
	  String body=response.getBody().asPrettyString();
	  System.out.println(body);	 
	  
	  response.then().body("code", equalTo(200));
	  response.then().body("message", equalTo("77232"));
	  
	  
  }
   
}
