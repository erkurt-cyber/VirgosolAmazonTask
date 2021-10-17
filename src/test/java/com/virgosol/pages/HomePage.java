package com.virgosol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "sp-cc-accept")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//span[text()='Merhaba, Giriş yapın']")
    public WebElement signIn;

}
