import org.testng.Assert;
import org.testng.annotations.Test;
import test.TestBase;

public class RegistrationTest extends TestBase {

    @Test

    public void registrationSuccess(){
        openRegistrationForm();
        fillRegistration("Igor","Prohorow","irga1231+2@mail.ru","Awww123~");
        Assert.assertTrue(successfullRegistration());
        Assert.assertEquals(actualRes(),"You are logged in success");

    }

    @Test

 public void negativeWrongRegistration(){
        openRegistrationForm();
        fillRegistration("Igor","Prohorow","irga1231mail.ru","Awww123~");
        Assert.assertFalse(successfullRegistration());


    }


}
