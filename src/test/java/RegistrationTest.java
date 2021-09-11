import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.TestBase;

public class RegistrationTest extends TestBase {

    @BeforeMethod

    public void preConditions() {

        if (app.getUserHelper().isLogoutPresent()) {
            app.getUserHelper().logout();
        }
    }

    @Test

    public void registrationSuccess() {
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistration("Igor", "Prohorow", "irga123+12@mail.ru", "Awww123~");
        Assert.assertTrue(app.getUserHelper().successfullRegistration());
        Assert.assertEquals(app.getUserHelper().actualRes(), "You are logged in success");

    }

    @Test

    public void negativeWrongRegistration() {
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistration("Igor", "Prohorow", "irga1231+2mail.ru", "Awww123");
        Assert.assertFalse(app.getUserHelper().successfullRegistration());


    }

    @AfterMethod

    public void finishedRegistration() {

        if (app.getUserHelper().buttonOKpressent()) {
            app.getUserHelper().clickOkAfterRegistration();
        }

    }


}
