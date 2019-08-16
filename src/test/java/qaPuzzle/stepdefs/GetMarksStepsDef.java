package qaPuzzle.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import qaPuzzle.BaseConfig;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class GetMarksStepsDef {

    private StepData stepData;

    public GetMarksStepsDef(StepData stepData) {
        this.stepData = stepData;
    }

    @Given("I open the page")
    public void iOpenThePage() {
        stepData.request = given()
                .baseUri(BaseConfig.baseUrl.concat("/car-types"))
                .contentType(ContentType.JSON)
                .queryParam("wa_key", BaseConfig.waKey);
    }

    @When("I see car marks loaded")
    public void iSeeCarMarksLoaded() {
        stepData.response = stepData.request.when().get(BaseConfig.carTypesEndpointPath);
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int arg0) {
        stepData.response.then().statusCode(arg0);
    }

    @And("response is not empty")
    public void responseIsNotEmpty() {
        stepData.response.then().rootPath(BaseConfig.jsonRootPath).body("isEmpty()", is(false));
    }
}
