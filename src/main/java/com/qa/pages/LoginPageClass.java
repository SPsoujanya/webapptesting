package com.qa.pages;

import com.qa.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageClass extends BasePage {

    //Page Factory = OR of Loginpage

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath=".//*[@id='loginForm']/div/div/input")
    WebElement loginBtn;

    @FindBy(xpath="//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement imgLogo;

// now create method to initialize the elements ..or constructor
// Initializing the page objects
    public LoginPageClass(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public  String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateimgLogo() {
        return imgLogo.isDisplayed();
    }
    //homepage is the landing page. it should return home page class object
    public  HomePageClass login(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePageClass();
    }


}
