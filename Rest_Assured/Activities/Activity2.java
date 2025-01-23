package activities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2 {
	
	String BASE_URI="https://petstore.swagger.io/v2/user";
	
  @Test(priority=1)
  public void addNewUserFromFile() {
	  
	  File file=new File("src/test/resources/input.json");
	  
	  Response response=given().contentType(ContentType.JSON)
			  .body(file).when().post(BASE_URI);
	  
	  String body=response.getBody().asPrettyString();
	  System.out.println(body);
	  
  }
  
  @Test(priority=2)
  public void getNewUser() {
	  File output=new File("src/test/resources/resJSONfile.json");
	  String userName="AryaM";
	  
	  Response response=given().contentType(ContentType.JSON)
			 .when().pathParam("userName", userName).get(BASE_URI + "/{userName}");
	  
	  String body=response.getBody().asPrettyString();
	  System.out.println(body);
	  
	  try {
		  output.createNewFile();
		  FileWriter writer=new FileWriter(output.getPath());
		  writer.write(body);
		  writer.close();
	  }catch(IOException excp) {
		  excp.printStackTrace();
	  }
	  
	  response.then().body("id", equalTo(12205));
	  response.then().body("username", equalTo("AryaM"));
	  response.then().body("firstName", equalTo("Arya"));
	  response.then().body("lastName", equalTo("M"));
	  response.then().body("email", equalTo("aryam@mail.com"));
	  response.then().body("password", equalTo("password123"));
	  response.then().body("phone", equalTo("9812768450"));
	  
  }
  
  @Test(priority=3)
  public void deleteNewUser() {
	  
      String userName="AryaM";
	  
	  Response response=given().contentType(ContentType.JSON)
			 .when().pathParam("userName", userName).delete(BASE_URI + "/{userName}");
	  
	  String body=response.getBody().asPrettyString();
	  System.out.println(body);
	  
	  response.then().body("code", equalTo(200));
	  response.then().body("message", equalTo("AryaM"));
	  
  }
  
	  
}
