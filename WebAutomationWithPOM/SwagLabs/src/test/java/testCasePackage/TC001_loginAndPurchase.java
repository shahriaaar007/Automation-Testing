package testCasePackage;

import dataSetPackage.DataSet;
import driverPackage.BaseDriver;
import org.testng.annotations.Test;
import pageObjectModelPackage.POM01_loginPage;
import pageObjectModelPackage.POM02_homePage;
import pageObjectModelPackage.POM03_cartPage;

public class TC001_loginAndPurchase extends BaseDriver {

    @Test(description = "Login with User and password", dataProvider = "loginAndInfoDataset", dataProviderClass = DataSet.class)
    public void loginAndPurchase(String userName, String password, String fName, String lName, String zipCode) throws InterruptedException {
        POM01_loginPage login = new POM01_loginPage();
        POM02_homePage homepage = new POM02_homePage();
        POM03_cartPage cartProduct = new POM03_cartPage();

        login.performLogin(userName, password);
        homepage.waitForPageLoad();

        homepage.purchaseProductAtoZ();
        homepage.waitForPageLoad();

        homepage.purchaseProductZtoA();
        homepage.waitForPageLoad();

        homepage.purchaseProductLowtoHigh();
        homepage.waitForPageLoad();

        homepage.purchaseProductHightoLow();
        homepage.waitForPageLoad();

        cartProduct.clickCart();
        cartProduct.waitForPageLoad();

        cartProduct.clickCheckout();
        cartProduct.waitForPageLoad();

        cartProduct.clickCheckoutInfoForm(fName, lName, zipCode);
        cartProduct.waitForPageLoad();

        cartProduct.clickFinishButton();
        cartProduct.waitForPageLoad();

        cartProduct.clickBackHome();
        cartProduct.waitForPageLoad();
        homepage.waitForPageLoad();

        homepage.logout();

    }
}
