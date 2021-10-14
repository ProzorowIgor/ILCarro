package test;

import org.testng.annotations.Test;

public class FindYourCarTest extends TestBase{


    @Test

    public void positiveFoundCar(){

        app.getSearchHelper().findCarByLocationAndDate("New York","12 OCT 2021","15 OCT 2021");

    }

    @Test

    public void positiveSearchInFuture(){
        app.getSearchHelper().selectDataInFuture("Las Vegas","2 11 2021","3 12 2021");

    }

    @Test
    public void searchTestByTypeNegative(){

        app.getSearchHelper().typingNegativeDates("Moscow","9/2/2021 - 10/3/2021");

    }


}
