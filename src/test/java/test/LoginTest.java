package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getUserHelper().isLogoutPresent()) {
            app.getUserHelper().logout();
        }
    }


    @Test
    public static void loginSuccess() {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getUserHelper().submitForm();
        //Assert.assertTrue(app.getUserHelper().isLogged());
    }

    @Test
    public void negativeLoginWrongPassword() {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa123456");
        app.getUserHelper().submitForm();
        Assert.assertFalse(app.getUserHelper().isLogged());

    }

    @AfterMethod

    public void postCondition() {
        if (app.getUserHelper().isOkButtonPresent()) {
            app.getUserHelper().clickOkButton();
        }

    }
}
