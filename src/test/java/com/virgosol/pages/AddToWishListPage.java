package com.virgosol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToWishListPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Görüntüle: Liste')]")
    public WebElement showListButton;

    @FindBy(xpath = "(//li[@class='w-asin'])[2]/table/tbody/tr/td/a")
    public WebElement addedProductName;

    @FindBy(xpath = "//header/button[1]")
    public WebElement closeButton;

}

