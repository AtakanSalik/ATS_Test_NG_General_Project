package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "sp-cc-accept")
    public WebElement l_cookies;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement l_helloUser;
    @FindBy(xpath = "(//span[@class=\"nav-action-inner\"])[1]")
    public WebElement l_signİn;
    @FindBy(xpath = "//span[text()='Liste Oluşturun']")
    public WebElement l_creat_A_list;
    @FindBy(id = "searchDropdownBox")
    public WebElement l_categoryList;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement l_searchBox;
    @FindBy(id = "nav-search-submit-button")
    public WebElement l_submitButton;

    public void getSignInPopUp() {
        BrowserUtils.hover(l_helloUser);
        l_signİn.click();
    }

    @FindBy(css = "[class='a-row a-text-center'] img")
    public List<WebElement> l_captchaImg;

    public void navigateToPage() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(1);
        if (!l_captchaImg.isEmpty()) {
            Driver.get().navigate().back();
            BrowserUtils.waitFor(3);
            Driver.get().get(ConfigurationReader.get("url"));
        }
        l_cookies.click();
    }

    public void verifyLogin() {
        Assert.assertTrue(l_helloUser.getText().contains(ConfigurationReader.get("username")));
    }

    public void selectCategory(String Category) {
        Select select = new Select(l_categoryList);
        select.selectByVisibleText(Category);

    }

    public boolean VerifyCategoryIsSelect() {
        Select select = new Select(l_categoryList);
        return select.getFirstSelectedOption().isSelected();

    }

    public List<WebElement> searchSomething(String s) {
        BrowserUtils.waitFor(3);
        l_searchBox.sendKeys(s);
        l_submitButton.click();
        List<WebElement> elements = Driver.get().findElements(By.xpath("//span[text()='" + s + "']"));
        return elements;
    }

    public boolean VerifyResults(List<WebElement> a, String search) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getText().contains(search)) {
                return true;
            }

        }
        return false;
    }
}




