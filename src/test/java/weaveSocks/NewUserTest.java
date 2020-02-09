package weaveSocks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import weaveSocks.model.User;

import static org.assertj.core.api.Assertions.assertThat;

public class NewUserTest extends TestBase{

    private User user;

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://167.172.110.35";
        RestAssured.port = 80;
//        RestAssured.basePath = "";
    }

    @BeforeMethod
    public void createUser(){
        user = new User();
        user.setUsername("Frodo97");
        user.setPassword("123456");
        user.setEmail("go79@gmail.com");


        user = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/register")
                .then()
                .statusCode(200)
                .extract().body()
                .as(User.class);

        User actualUser = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(user.getId())
                .then()
                .statusCode(200)
                .extract().body()
                .as(User.class);

        assertThat(actualUser).isEqualTo(user);
    }

    @Test
    public void loginUser(){
        
    }
}
