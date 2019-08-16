package qaPuzzle.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import qaPuzzle.BaseConfig;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class GetBuiltDatesDef {

    private StepData stepData;

    public GetBuiltDatesDef(StepData stepData) {
        this.stepData = stepData;
    }

    @And("I have selected {string} as a car mark")
    public void iHaveSelectedAsACarMark(String arg0) {
        stepData.request.queryParam("manufacturer", arg0);
    }

    @And("I have selected {string} as a car type")
    public void iHaveSelectedAsACarType(String arg0) {
        stepData.request.queryParam("main-type", arg0);
    }

    @When("I want to select car build dates")
    public void iWantToSelectCarBuildDates() {
        stepData.response = stepData.request.when().get(BaseConfig.builtDatesEndpointPath);
    }

    @And("response includes the following {string}")
    public void responseIncludesTheFollowing(String arg0) {
        List<String> dates = Arrays.asList(arg0.split(","));
        stepData.json = stepData.response.then();
        dates.forEach((date -> stepData.json.rootPath(BaseConfig.jsonRootPath).body(date, equalTo(date))));
    }
}
