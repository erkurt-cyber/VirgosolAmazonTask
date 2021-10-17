package com.virgosol.test;


import com.virgosol.pages.*;
import com.virgosol.utulities.BrowserUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Amazon_Task extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ProductListPage productListPage = new ProductListPage();
    ProductPage productPage = new ProductPage();
    AddToWishListPage addToWishListPage = new AddToWishListPage();
    WishListPage wishListPage = new WishListPage();
    LogoutPage logoutPage = new LogoutPage();

    String javaScript = "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
            "arguments[0].dispatchEvent(evObj);";

    @Test
    @Order(1)
    public void homePageTest() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.amazon.com.tr/"));
    }

    @Test
    @Order(2)
    public void loginTest() {
        homePage.acceptCookiesButton.click();
        homePage.signIn.click();
        loginPage.login();
        Assert.assertTrue(dashboardPage.checkHomePage());
    }

    @Test
    @Order(3)
    public void selectComputerTest() {
        String actualCategory = dashboardPage.selectComputer();
        Assert.assertEquals(actualCategory, "Bilgisayarlar");
    }

    @Test
    @Order(4)
    public void searchMSITest() {
        dashboardPage.searchBox.sendKeys("msi");
        dashboardPage.searchSubmitButton.click();

        BrowserUtils.waitFor(2);

        String actualSearch = productListPage.getSelectedProduct();
        Assert.assertEquals(actualSearch, "\"msi\"");
    }

    @Test
    @Order(5)
    public void secondPageTest() {
        productListPage.secondSearchPage.click();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("sr_pg_2"));
    }

    @Test
    @Order(6)
    public void secondProductTest() {
        BrowserUtils.waitFor(2);
        String expectedResult = productListPage.secondProductTitle.getText();
        System.out.println("expectedResult = " + expectedResult);
        productListPage.secondProduct.click();

        BrowserUtils.waitFor(2);
        String actualResult = productPage.productTitle.getText();

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    @Order(7)
    public void wishListTest() {
        BrowserUtils.waitFor(2);
        productPage.addToWishListButton.click();
        String expectedResult = productPage.productTitle.getText();
        String actualResult = addToWishListPage.addedProductName.getText();
        Assert.assertEquals(actualResult, expectedResult);
        addToWishListPage.closeButton.click();

        BrowserUtils.waitFor(2);
        //actions.moveToElement(dashboardPage.myAccountDropdown);

        ((JavascriptExecutor) driver).executeScript(javaScript, dashboardPage.myAccountDropdown);

        dashboardPage.wishListLink.click();

        String expectedWishListName = dashboardPage.wishListLink.getText();
        System.out.println("expectedWishListName = " + expectedWishListName);

        BrowserUtils.waitFor(2);
        String actualWishListName = wishListPage.listName.getText();

        System.out.println("actualWishListName = " + actualWishListName);

        Assert.assertEquals(actualWishListName,expectedWishListName);

        wishListPage.removeButton.click();
        Assert.assertTrue(wishListPage.deletedMessage.isDisplayed());

    }

    @Test
    @Order(8)
    public void logoutTest() {

        ((JavascriptExecutor) driver).executeScript(javaScript, dashboardPage.myAccountDropdown);
        dashboardPage.logoutButton.click();
        String expectedMessage = "Giriş yap";
        String actualMessage = logoutPage.logoutMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}