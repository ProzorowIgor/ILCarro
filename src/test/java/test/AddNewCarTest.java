package test;

import models.Car;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        LoginTest.loginSuccess();

    }

    @Test

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

    /*@AfterMethod

    public void isOk(){


    }*/

}
