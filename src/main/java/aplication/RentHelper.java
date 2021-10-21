package aplication;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RentHelper extends HelperBase {

    public RentHelper(WebDriver wd) {
        super(wd);
    }


    public void choseAcar() {
        click(By.xpath("//div[@class='search-results-card']//a[1]"));
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Rent now!! ']")));
        click(By.xpath("//button[text()='Rent now!! ']"));
    }


    public void fillOrderForm(User user) {
        type(By.id("firstName"), user.getName());
        type(By.id("secondName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("phone"), user.getPhone());

    }

    public void clickOnReserve() {

        click(By.xpath("//button[text()='Reserve']"));
    }

    public void closeButtonClick() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Close']")));
        click(By.xpath("//button[normalize-space()='Close']"));
    }

    public String messageAfterOrder() {

        String message = wd.findElement(By.xpath("//h1[text()='Order success']")).getText();

        return message;
    }

    public void logInBeforeRent(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        click(By.cssSelector("button[type='submit']"));

    }

    public void clickOnRentNow() {
        click(By.xpath("//button[text()='Rent now!! ']"));
    }
}
