package com.amazon.pages;

import com.amazon.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "ap_email")
    public WebElement l_emailInput;
    @FindBy(id = "continue")
    public WebElement l_continueBtn;
    @FindBy(id = "ap_password")
    public WebElement l_passwordInput;
    @FindBy(id = "signInSubmit")
    public WebElement l_signInSubmitBtn;

    public void login(){
       getSignInPopUp();
        String email = ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");
        l_emailInput.sendKeys(email);
        l_continueBtn.click();
        l_passwordInput.sendKeys(password);
        l_signInSubmitBtn.click();
    }
    public void login(String email,String password){
       getSignInPopUp();

        l_emailInput.sendKeys(email);
        l_continueBtn.click();
        l_passwordInput.sendKeys(password);
        l_signInSubmitBtn.click();
    }


}
