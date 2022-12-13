package com.herokuapp.theinternet.pages;

import com.aventstack.extentreports.Status;
import com.herokuapp.theinternet.customlisteners.CustomListeners;
import com.herokuapp.theinternet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SecureAreaPage extends Utility {

    //Declaring WebElement variable
    @CacheLookup
    @FindBy(xpath = "//h2[text() =' Secure Area']")
    WebElement loginVerificationText;

    //This method will get text after successful login
    public String getTextUponSuccessfulLogIn() {
        Reporter.log("Verification Text is " + loginVerificationText.toString());
        CustomListeners.test.log(Status.PASS, "The login verification Message is \"" + loginVerificationText.getText() + "\"");
        return getTextFromElement(loginVerificationText);

    }
}
