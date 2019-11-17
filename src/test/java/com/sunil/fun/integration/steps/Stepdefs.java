package com.sunil.fun.integration.steps;

import cucumber.api.java8.En;

public class Stepdefs implements En {

  public Stepdefs() {
    Then("^the client receives status code of (\\d+)$", (Integer code) -> {

    });

    When("^the client calls /version$", () -> {
    });

    And("^the client receives server version (.+)$", (Integer version) -> {

    });
  }
}
