package aplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));

    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);

    }

    public void submitForm() {

        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isLogged() {
        String text = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        click(By.xpath("//button[text()='Ok']"));
        return text.equals("Logged in success");
    }

    public void logout() {

        click(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isLogoutPresent() {

        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    //*******************************************************************//
    public void openRegistrationForm() {

        click(By.xpath("//*[@href='/registration?url=%2Fsearch']"));
    }

    public void fillRegistration(String name, String surname, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), surname);
        type(By.id("email"), email);
        type(By.id("password"), password);
        click(By.xpath("//label[@for='terms-of-use']"));
        //click(By.xpath("//input[@class='ng-dirty ng-touched ng-valid']"));
        //click(By.id("terms-of-use"));
        click(By.xpath("//button[@type='submit']"));

    }

    public boolean successfullRegistration() {

        boolean res = wd.findElements(By.xpath("//h2[@class='message']")).size() > 0;
        return res;
    }

    public String actualRes() {

        //List<WebElement> obj = wd.findElements(By.xpath("//h2[@class='message']"));
        List<WebElement> obj = wd.findElements(By.xpath("//h2[text()='You are logged in success']"));
        String str = obj.get(0).getText();
        return str;
    }

    public boolean buttonOKpressent() {

        return isElementPresent(By.xpath("//button[text()='Ok']"));
    }

    public void clickOkAfterRegistration() {
        click(By.xpath("//button[text()='Ok']"));
    }
}
