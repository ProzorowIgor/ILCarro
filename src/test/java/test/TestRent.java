package test;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRent extends TestBase {

    @Test
    public void rentWithLogin() {
        if (app.getUserHelper().isLogInPreset()) {
            app.getUserHelper().openLoginForm();
            app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
            app.getUserHelper().submitForm();
        }
        app.getSearchHelper().findCarByLocationAndDate("New York", "25 DEC 2021", "28 DEC 2021");
        app.getRentHelper().choseAcar();
        User user = new User()
                .withEmail("noa@gmail.com")
                .withName("George")
                .withLastName("Bush")
                .withPhone("+972543221190");
        app.getRentHelper().fillOrderForm(user);
        app.getRentHelper().clickOnReserve();
        Assert.assertEquals(app.getRentHelper().messageAfterOrder(), "Order success");
        app.getRentHelper().closeButtonClick();


    }


    @Test
    public void rentWithoutLogin() {

        app.getSearchHelper().findCarByLocationAndDate("New York", "27 NOV 2021", "30 NOV 2021");
        app.getRentHelper().choseAcar();
        app.getRentHelper().logInBeforeRent("noa@gmail.com", "Nnoa12345$");
        app.getRentHelper().clickOnRentNow();
        User user = new User()
                .withEmail("noa@gmail.com")
                .withName("George")
                .withLastName("Bush")
                .withPhone("+972543221190");
        app.getRentHelper().fillOrderForm(user);
        app.getRentHelper().clickOnReserve();
        Assert.assertEquals(app.getRentHelper().messageAfterOrder(), "Order success");
        app.getRentHelper().closeButtonClick();

    }

}
