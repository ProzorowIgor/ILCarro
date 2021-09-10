import org.testng.Assert;
import org.testng.annotations.Test;
import test.TestBase;

public class RegistrationTest extends TestBase {

    @Test

    public void registrationSuccess(){
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistration("Igor","Prohorow","irga1231+2@mail.ru","Awww123~");
        Assert.assertTrue(app.getUserHelper().successfullRegistration());
        Assert.assertEquals(app.getUserHelper().actualRes(),"You are logged in success");

    }

    @Test

 public void negativeWrongRegistration(){
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistration("Igor","Prohorow","irga1231mail.ru","Awww123~");
        Assert.assertFalse(app.getUserHelper().successfullRegistration());


    }


}
