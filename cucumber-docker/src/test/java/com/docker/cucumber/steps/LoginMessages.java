package com.docker.cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import pages.LoginPage;
import pages.SecurePage;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;


public class LoginMessages extends BaseCucumberTest implements En {

    private LoginPage loginPage;

    @Before
    public void before() throws MalformedURLException{
        setup();
        loginPage = new LoginPage(getDriver());
        loginPage.navigateTo();
    }

    @After
    public void after() {
        tearDown();
    }


    public LoginMessages() {

        When("^I login with a valid username and password$", () -> {
            loginPage.login("tomsmith", "SuperSecretPassword!");
            SecurePage securePage = new SecurePage(getDriver());
        });
        When("^I login with an invalid username$", () -> {
            loginPage.login("timsmith", "SuperSecretPassword!");
        });
        When("^I login with an invalid password$", () -> {
            loginPage.login("tomsmith", "wrong");
        });

        When("^I login with username \"([^\"]*)\" and password \"([^\"]*)\"$", (String username, String password) -> {
            loginPage.login(username, password);
        });

        Then("^I see the message \"([^\"]*)\"$", (String message) -> {
            assertEquals(message, loginPage.getLoginText().trim());
        });

    }
}
