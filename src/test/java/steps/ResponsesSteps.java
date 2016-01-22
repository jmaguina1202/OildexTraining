package steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import utils.CommonUtils;

public class ResponsesSteps {

    private ResourcesSteps projectSteps;

    public ResponsesSteps(ResourcesSteps projectSteps) {
        this.projectSteps = projectSteps;
    }

    @Then("^The response should contain the data with the string value \"(.*?)\" and \"(.*?)\"$")
    public void theResponseShouldContainSentDataWithStringValue(String tag, String tagValue) {
        Assert.assertTrue(projectSteps.getJsonResponse().contains("\"" + tag + "\":" + "\"" + tagValue + "\""));
    }

    @Then("^The response should contain \"(.*?)\" and \"(.*?)\"$")
    public void theResponseShouldContainSentData(String tag, String tagValue) {
        if (tagValue.contains(".")) {
            Assert.assertTrue(projectSteps.getJsonResponse().contains("\"" + tag + "\":" + CommonUtils.getId(tagValue)));
        } else {
            Assert.assertTrue(projectSteps.getJsonResponse().contains("\"" + tag + "\":" + tagValue));
        }
    }

    @Then("^Response is not empty")
    public void responseIsNotEmpty() {
        Assert.assertFalse(projectSteps.getJsonResponse().isEmpty());
    }
}
