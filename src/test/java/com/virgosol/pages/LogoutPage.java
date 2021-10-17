package com.virgosol.pages;

import com.virgosol.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Giriş yap')]")
    public WebElement logoutMessage;


}
