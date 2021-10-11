package aplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchHelper extends HelperBase{


    public SearchHelper(WebDriver wd) {
        super(wd);
    }


    public void findCarByLocationAndDate(String city,String beginDate, String overDate) {
        String [] arrBegin = beginDate.split(" ");
        String [] arrOver = overDate.split(" ");
        int dayTake = Integer.parseInt(arrBegin[0]);
        int dayReturn = Integer.parseInt(arrOver[0]);

        type(By.id("city"),city);
        click(By.xpath("//div[@class='pac-container pac-logo']//div[1]"));

        click(By.id("dates"));
        click(By.cssSelector("button[aria-label='Choose month and year']"));
        click(By.xpath("//div[text()=' "+arrBegin[2]+" ']"));
        click(By.xpath("//div[text()=' "+arrBegin[1]+" ']"));
        click(By.xpath(String.format("//div[text()=' %s ']",dayTake)));
        click(By.xpath(String.format("//div[text()=' %s ']",dayReturn)));
        click(By.cssSelector("button[type='submit']"));


    }
}
