package aplication;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperCar extends HelperBase {

    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void initAddingnewCar() {

        click(By.xpath("//a[@href='/let-car-work']"));
    }


    public void fillCarForm(Car car) {

        typeLocation(car.getAdress());
        type(By.id("make"),car.getMake());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        type(By.id("engine"), car.getEngine());

        selectFuel(By.id("fuel"),car.getFuel());
        select(By.id("gear"),car.getGear());
        select(By.id("wheelsDrive"),car.getwD());

        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getClasS());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistanceIncluded());
        type(By.cssSelector(".feature-input"),car.getTypeFeature());
        type(By.id("about"), car.getAbout());

    }

    private void select(By locator, String option) {
        new Select(wd.findElement(locator)).selectByValue(option);

    }

    private void selectFuel(By locator, String option) {
       /* Select select = new Select(wd.findElement(locator));

        if (option.equals("Petrol")) {
            //new Select(wd.findElement(locator)).selectByIndex(1);
            select.selectByValue("Petrol");
        }else if (option.equals("Disel")) {
            select.selectByValue("Disel");
        }*/

        new Select(wd.findElement(locator)).selectByVisibleText(option);//That's the right way

    }


    private void typeLocation(String address) {
        type(By.id("pickUpPlace"), address);
        pause(500);
        click(By.cssSelector("div.pac-item"));
        pause(500);

    }



    public void attachPhoto() {

        wd.findElement(By.id("photos")).sendKeys("F:\\Qa29 Projects\\ILCarro\\Subaru.jpg");
        pause(5000);

    }
    public void clickButtonSubmit(){
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.xpath("//button[text()='Submit']"))));
        click(By.xpath("//button[text()='Submit']"));
    }

}
