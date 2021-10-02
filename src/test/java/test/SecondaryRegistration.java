package test;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.TestBase;

public class SecondaryRegistration extends TestBase {

    @BeforeMethod

    public void preConditions() {

        if (app.getUserHelper().isLogoutPresent()) {
            app.getUserHelper().logout();
        }
    }

    @Test
    public void registrationTest(){

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm("Lis","Slow","slow"+i+"@gmail.com","Ss12345$");
        app.getUserHelper().checkPolicy();
       // app.getUserHelper().submitForm();

    }

    @Test
    public void registrationTest2(){

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm("Lis","Slow","slow"+i+"@gmail.com","Ss12"+i+"$");
        app.getUserHelper().checkPolicy();
        //app.getUserHelper().submitForm();

    }

    @Test
    public void registrationTestModel(){

        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User()
                .withName("Lis")
                .withLastName("Snow")
                .withEmail("snow"+i+"@gmail.com")
                .withPassword("Ss12345$");
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().checkPolicy();
        // app.getUserHelper().submitForm();

    }

    /*@Test
    public void registrationTestNegative(){

    }*/

    @AfterMethod
    public void finishedRegistration() {

        if (app.getUserHelper().buttonOKpressent()) {
            app.getUserHelper().clickOkAfterRegistration();
        }

    }


}
