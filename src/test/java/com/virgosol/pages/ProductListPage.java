package com.virgosol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListPage extends BasePage{

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    public WebElement searchedProductResult;

    @FindBy(xpath = "//a[text()='2']")
    public WebElement secondSearchPage;

    @FindBy(xpath = "//div[@data-cel-widget='search_result_2']")
    public WebElement secondProduct;

    @FindBy(xpath = "//div[@data-cel-widget='search_result_2']/div/span/div/div/div/div/h2/a/span")
    public WebElement secondProductTitle;

    public String getSelectedProduct(){
        return searchedProductResult.getText();
    }

}
