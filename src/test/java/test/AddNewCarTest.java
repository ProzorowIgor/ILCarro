package test;

import models.Car;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        app.getUserHelper().openLoginForm();
       // app.getUserHelper().fillLoginForm("noa@gmail.com", "Nnoa12345$");
        app.getUserHelper().fillLoginForm(new User().withEmail(app.setEmail()).withPassword(app.setPassword()));
        app.getUserHelper().submitForm();
        //LoginTest.loginSuccess();

    }

    @Test(groups = {"web"})

    public void addNewCarSuccess(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);

        Car car = new Car()
                .withAdress("Tel Aviv, Israel")
                .withMake("BMW")
                .withModel("M5")
                .withYear("2020")
                .withEngine("2.3")
                .withFuel("Petrol")
                .withGear("MT")
                .withwD("AWD")
                .withDoors("5")
                .withSeats("4")
                .withClasS("C")
                .withFuelConsumption("6.5")
                .withCarRegNumber("100-66-"+i)
                .withPrice("65")
                .withDistanceIncluded("500")
                .withTypeFeature("type of")
                .withAbout(" Very good car");

        app.car().initAddingnewCar();
        app.car().fillCarForm(car);
        app.car().attachPhoto();
        app.car().clickButtonSubmit();



    }

    @AfterMethod(alwaysRun = true)

    public void postCondition() {
        app.getUserHelper().clickOnSearchCar();
        if (app.getUserHelper().isLogoutPresent()) {
            app.getUserHelper().logout();
        }
    }

}
