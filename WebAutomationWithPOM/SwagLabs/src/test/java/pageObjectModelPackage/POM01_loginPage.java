package pageObjectModelPackage;

import driverPackage.PageDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.CommonMethods;

import java.awt.print.PageFormat;

public class POM01_loginPage extends CommonMethods {
    public POM01_loginPage(){
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement userNameTextField;

    @FindBy(id = "password")
    public WebElement passwordTextField;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @Step("Perform login with user name and password")
    public void performLogin(String user, String pass){
        userNameTextField.clear();
        sendText(userNameTextField, user);
        passwordTextField.clear();
        sendText(passwordTextField, pass);
        loginButton.click();
    }
}
