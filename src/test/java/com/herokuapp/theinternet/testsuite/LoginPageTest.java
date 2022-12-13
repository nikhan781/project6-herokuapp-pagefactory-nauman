package com.herokuapp.theinternet.testsuite;

import com.herokuapp.theinternet.customlisteners.CustomListeners;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    //Declaring objects of 2 pages classes
    LoginPage loginPage;

    SecureAreaPage secureAreaPage;
    //This method will initialise the object
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        secureAreaPage = new SecureAreaPage();

    }

    //Test 1
    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Invoking method from Login Page class to enter username
        loginPage.enterUserName("tomsmith");
        //Invoking method from Login Page class to enter password
        loginPage.enterPassword("SuperSecretPassword!");
        //Invoking method from Login Page class to click on login button
        loginPage.clickOnLogInButton();
        //Invoking wait method from
        waitUntilVisibilityOfElementLocated(By.xpath("//h2[text() =' Secure Area']"), 20);
        //Invoking method from secure area Page class to verify text
        Assert.assertEquals(secureAreaPage.getTextUponSuccessfulLogIn(), "Secure Area", "Secure Area page is npt displayed");
    }

    //Test 2
    @Test(groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage() {
        //Invoking method from Login Page class to enter username
        loginPage.enterUserName("tomsmith1");
        //Invoking method from Login Page class to enter password
        loginPage.enterPassword("SuperSecretPassword!");
        //Invoking method from Login Page class to click on login button
        loginPage.clickOnLogInButton();
        //Invoking method from Login Page class to verify text
        Assert.assertTrue(loginPage.getErrorMessage().contains("Your username is invalid!"), "Your username is invalid!");
    }

    //Test 3
    @Test(groups = "regression")
    public void verifyThePasswordErrorMessage() {
        //Invoking method from Login Page class to enter username
        loginPage.enterUserName("tomsmith");
        //Invoking method from Login Page class to enter password
        loginPage.enterPassword("SuperSecretPassword");
        //Invoking method from Login Page class to click on login button
        loginPage.clickOnLogInButton();
        //Invoking method from Login Page class to verify text
        Assert.assertEquals(loginPage.getErrorMessage(), "Your password is invalid!\n" +
                "×", "Error Message not displayed");
    }


}
