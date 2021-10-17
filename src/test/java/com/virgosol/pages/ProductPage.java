package com.virgosol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(id = "productTitle")
    public WebElement productTitle;

    @FindBy(id = "add-to-wishlist-button-submit")
    public WebElement addToWishListButton;

}
