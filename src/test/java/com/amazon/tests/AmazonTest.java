package com.amazon.tests;

import com.amazon.pages.BasePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourListPage;
import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonTest extends TestBase{
/**
 *  Amazon E2E Task
 * go to amazon web page =>  https://www.amazon.com/
 * if there are cookies accept cookies
 * log in with your own valid credential
 * Verify that login is successful
 * Create a new list from "Account and Lists"
 * Select any category from the section tab next to the search box
 * Verify that category is selected
 * Write any product to search box and click
 * Verify that the result contains product items
 */
LoginPage loginPage;
YourListPage yourListPage;

    @Test
    public void t_e2e_Login_CreateList_CategorySearch() {
        loginPage=new LoginPage();
        yourListPage =new YourListPage();
        extentLogger = report.createTest("Amazon e2e test");

        extentLogger.info("go to "+ConfigurationReader.get("url")+" web page");
        loginPage.navigateToPage();

        extentLogger.info("log in with your own valid credential");
        loginPage.login();

        extentLogger.info("Verify that login is succesful");
        loginPage.verifyLogin();

        extentLogger.info("Create a new list from Account and Lists");
        yourListPage.createNewList("alışveriş");

        extentLogger.info("Select any category from the section tab next to the search box");
        loginPage.selectCategory("Ev");

        extentLogger.info("Verify that category is selected");
        Assert.assertTrue(loginPage.VerifyCategoryIsSelect());

        extentLogger.info(" Write any product to search box and click");
        loginPage.searchSomething("Selenium");

        extentLogger.info("Verify that the result contains product items");
        loginPage.VerifyResults( loginPage.searchSomething("Selenium"),"Selenium");



    }
}
