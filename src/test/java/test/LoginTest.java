package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod//(alwaysRun = true)
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

    @Test(groups = {"web"})
    public void negativeLoginWrongPassword() {
        {
            app.getUserHelper().openLoginForm();
            app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa123456");
            app.getUserHelper().submitForm();
            Assert.assertFalse(app.getUserHelper().isLogged());

        }
    }
    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        if (app.getUserHelper().isOkButtonPresent()) {
            app.getUserHelper().clickOkButton();
        }
        if (app.getUserHelper().isLogoutPresent()) {
            app.getUserHelper().logout();
        }

    }
}
