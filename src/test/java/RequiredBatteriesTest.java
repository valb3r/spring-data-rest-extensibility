
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.spring_data_rest.extensio.SpringDataRestExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static io.restassured.RestAssured.given;

@Transactional(propagation = Propagation.NOT_SUPPORTED) // Force real transactions
@SpringBootTest(classes = SpringDataRestExtension.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequiredBatteriesTest {

    @LocalServerPort
    private int port;

    @Test
    @Disabled // Should pass with battery
    void testUserCreateWithEmbeddedAttribute() {
        given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                          "login": "dummy",
                          "attributes": [
                            {"name": "attribute_dummy_1"}
                          ]
                        }
                        """)
        .when().post(usersUri())
        .then()
                .log().ifValidationFails(LogDetail.ALL)
                .statusCode(HttpStatus.SC_OK);
    }

    private String usersUri() {
        return String.format("http://localhost:%d/v1/resources/users", port);
    }
}
