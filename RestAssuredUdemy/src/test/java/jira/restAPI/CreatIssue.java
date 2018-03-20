package jira.restAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class CreatIssue {

  private static Logger log = Logger.getLogger(CreatIssue.class.getName());
    @Test
    public void verifyResponse() throws IOException {
        log.debug("First Test Case");
        String requestBody = generateString("JiraLogIn.json");
        //Login JIRA
        RestAssured.baseURI = "http://localhost:8080";
        Response response = given().
                contentType(ContentType.JSON).
                body(requestBody).
                when().
                post("/rest/auth/1/session").
                then().assertThat().statusCode(200).log().all().
                extract().response();
        // convert responsebody to String
        String responseBody = response.asString();
        JsonPath jsonResponse = new JsonPath(responseBody);
        String sessionID = jsonResponse.getString("session.value");
        System.out.println(responseBody);

        //Create Issue In Jira
        String createBugBody = generateString("CreateIssue.json");
        Response responseCreateIssue = given().
                contentType(ContentType.JSON).
                header("cookie", "JSESSIONID=" + sessionID + "").
                body(createBugBody).
                when().
                post("/rest/api/2/issue").
                then().
                assertThat().statusCode(201).log().all().
                extract().response();
        String issueRsponseBody = responseCreateIssue.asString();
        JsonPath jsonPath = new JsonPath(issueRsponseBody);
        String issueID = jsonPath.get("id");
        String issueKey = jsonPath.get("key");

        //Write Comment on Issue
        String commentBody = generateString("Comment.json");
        Response commentResponse = given().
                contentType(ContentType.JSON).
                header("cookie", "JSESSIONID=" + sessionID + "").
                body(commentBody).
                when().
                post("rest/api/2/issue/" +issueID+"/comment").
                then().
                assertThat().statusCode(201).log().all().
                extract().response();
        String commentResponeseBody = commentResponse.asString();
        JsonPath commentResponseJson = new JsonPath(commentResponeseBody);
        String commentID = commentResponseJson.get("id");

        //Update Comment
        String UpdateCmntBody = generateString("UpdateComment.json");
        Response  updateCmntResponse = given().
                contentType(ContentType.JSON).
                header("cookie", "JSESSIONID=" + sessionID+"").
                body(UpdateCmntBody).
                when().
                put("/rest/api/2/issue/"+ issueID+"/comment/" +commentID+"").
                then().assertThat().statusCode(200).log().all().

                extract().response();

		/*JsonPath addCmntResJson = new JsonPath(addCmntResponse.asString());
		String cmntID = jsonRes.getString("id");*/
     // delete comment
        given().
                contentType(ContentType.JSON).
                header("cookie", "JSESSIONID=" + sessionID+"").
                when().
                delete("/rest/api/2/issue/"+ issueID+"/comment/" +commentID+"").
                then().assertThat().statusCode(204).log().all();

    }
    @Test
    public void loggerTest(){
        log.info("Logger Test2");
    }
    @Test
    public void thridTest(){
        log.error("Hi error message");
        log.fatal("fatal error");
        /*int i = 1;
        try{
            int j =i/0;
        } catch (Exception e){
            log.error(e);
        }*/
    }




    public static String generateString(String filename) throws IOException, IOException {
        String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\payloads\\"+filename;
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
