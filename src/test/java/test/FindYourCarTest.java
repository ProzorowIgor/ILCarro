package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FindYourCarTest extends TestBase{


    @Test(groups = {"web"})

    public void positiveFoundCar(){

        app.getSearchHelper().findCarByLocationAndDate("New York","12 DEC 2021","15 DEC 2021");

    }

    @Test

    public void positiveSearchInFuture(){
        app.getSearchHelper().selectDataInFuture("Las Vegas","2 11 2021","3 12 2021");

    }

    @Test
    public void searchTestByTypeNegative(){

        app.getSearchHelper().typingNegativeDates("Moscow","9/2/2021 - 10/3/2021");

    }

    @AfterMethod(alwaysRun = true)
    public void postCondition(){
        app.getSearchHelper().returnOnIlCarroMainPage();
    }


}
