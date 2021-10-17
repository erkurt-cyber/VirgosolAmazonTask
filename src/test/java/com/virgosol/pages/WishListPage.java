package com.virgosol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{

    @FindBy(id = "profile-list-name")
    public WebElement listName;

    @FindBy(xpath = "(//input[@name='submit.deleteItem'])[1]")
    public WebElement removeButton;

    @FindBy(xpath = "//div[text()='Silindi']")
    public WebElement deletedMessage;
}
