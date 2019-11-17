package com.sunil.fun.integration.steps;

import com.sunil.fun.FunApplication;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = FunApplication.class)
public class StepDefs {

  private final String baseUrl = "http://localhost:8080/";
  private final String path = "calculateCreditScore";

  private ResponseEntity<String> response;

  @When("^The calculateCreditAssessmentScore API is called with company type \"([^\"]*)\", (\\d+) employees and (\\d+) in business$")
  public void theCalculateCreditAssessmentScoreAPIIsCalledWithCompanyTypeEmployeesAndInBusiness(
      String companyType, int numberOfEmployees, int timeInBusiness) throws Throwable {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    UriComponents uriComponents = UriComponentsBuilder.newInstance().path(path)
        .queryParam("companyType", companyType).queryParam("numberOfEmployees", numberOfEmployees)
        .queryParam("timeInBusiness", timeInBusiness).build();

    response = restTemplate.getForEntity(baseUrl + uriComponents.toString(), String.class);
  }

  @Then("^The credit assessment score should match \"([^\"]*)\"$")
  public void theCreditAssessmentScoreShouldMatch(String expectedScore) throws Throwable {
    JSONObject json = new JSONObject(response.getBody());
    String score = json.getString("score");
    Assert.assertEquals("credit score did not match expected value",
        expectedScore, score);
  }


}
