package com.virgosol.pages;

import com.virgosol.utulities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DashboardPage extends BasePage{


    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement name;

    @FindBy(id = "searchDropdownBox")
    public WebElement categoryDropdown;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchSubmitButton;

    @FindBy(xpath = "(//span[@class='nav-icon nav-arrow'])[1]")
    public WebElement myAccountDropdown;

    @FindBy(xpath = "//span[text()='Alışveriş Listesi']")
    public WebElement wishListLink;

    @FindBy(xpath = " //span[text()='Çıkış Yap']")
    public WebElement logoutButton;



    public boolean checkHomePage() {
        BrowserUtils.waitFor(2);
        return name.getText().contains("Faruk");
    }

    public String selectComputer(){
        Select categories = new Select(categoryDropdown);
        BrowserUtils.waitFor(2);
        categories.selectByVisibleText("Bilgisayarlar");
        return categories.getFirstSelectedOption().getText();
    }

}
