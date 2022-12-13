package com.herokuapp.theinternet.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.theinternet.customlisteners.CustomListeners;
import com.herokuapp.theinternet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    //Declaring WebElement variables
    @CacheLookup
    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameField;
    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(css = "i[class='fa fa-2x fa-sign-in']")
    WebElement logInButton;
    @CacheLookup
    @FindBy(xpath = "//div[1]/div/div|/text()")
    WebElement errorMessage;

    //This method will send text to user field
    public void enterUserName(String userName) {
        Reporter.log("Enter user name " + userName + " to username field " + userNameField.toString());
        sendTextToElement(userNameField, userName);
        CustomListeners.test.log(Status.PASS, "Enter User Name \"" + userName + "\"");
    }

    //This method will send text to password field
    public void enterPassword(String password) {
        Reporter.log("Enter user " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password \"" + password + "\"");
    }

    //This method will click on log in button
    public void clickOnLogInButton() {
        Reporter.log("Click on Login Button " + logInButton.toString());
        clickOnElement(logInButton);
        CustomListeners.test.log(Status.PASS, "Click on login Button ");
    }

    //This method will get error message in case of using invalid credentials
    public String getErrorMessage() {
        Reporter.log("The error message is " + errorMessage.toString());
        CustomListeners.test.log(Status.PASS, "The error message is \"" + errorMessage.getText() + "\"");
        return getTextFromElement(errorMessage);

    }

}
