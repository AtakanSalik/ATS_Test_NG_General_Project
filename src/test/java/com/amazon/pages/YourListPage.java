package com.amazon.pages;

import com.amazon.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourListPage extends BasePage{
@FindBy(id="list-name")
public WebElement l_listname;
@FindBy(id="wl-redesigned-create-list")
public WebElement l_createListOnPopUp;

public void createNewList(String listname){
        BrowserUtils.hover(l_helloUser);
        l_creat_A_list.click();
        BrowserUtils.waitFor(1 );
        l_listname.clear();
        l_listname.sendKeys(listname);
        l_createListOnPopUp.click();

    }
}
