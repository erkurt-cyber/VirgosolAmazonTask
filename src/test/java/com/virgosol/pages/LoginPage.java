package com.virgosol.pages;

import com.virgosol.utulities.BrowserUtils;
import com.virgosol.utulities.ConfigurationReader;
import com.virgosol.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "ap_email")
    public WebElement email;

    @FindBy(id = "ap_password")
    public WebElement password;

    @FindBy(id = "continue")
    public WebElement submitEmail;

    @FindBy(id = "signInSubmit")
    public WebElement submitPassword;

    public void login(){

        BrowserUtils.waitFor(1);

        email.sendKeys(ConfigurationReader.get("email"));
        submitEmail.click();

        BrowserUtils.waitFor(1);
        password.sendKeys(ConfigurationReader.get("password"));
        submitPassword.click();
    }

}
