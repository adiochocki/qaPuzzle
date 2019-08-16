package qaPuzzle.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import qaPuzzle.BaseConfig;

import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class GetMainTypesStepsDef {

    private StepData stepData;

    public GetMainTypesStepsDef(StepData stepData) {
        this.stepData = stepData;
    }

    @And("select language {string}")
    public void selectLanguage(String arg0) {
        stepData.request.queryParam("locale", arg0);
    }

    @When("I choose {int} as a car mark")
    public void iChooseAsACarMark(int arg0) {
        stepData.request.queryParam("manufacturer", arg0);
        stepData.response = stepData.request.when().get(BaseConfig.mainTypesEndpointPath);
    }

    @Then("response includes the following")
    public void response_includes_the_following(Map<String, String> responseFields) {
        stepData.json = stepData.response.then();
        responseFields.forEach((k, v) -> stepData.json.rootPath(BaseConfig.jsonRootPath).body(k, equalTo(v)));
    }
}
