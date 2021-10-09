package test;

import org.testng.annotations.Test;

public class FindYourCarTest extends TestBase{


    @Test

    public void positiveFoundCar(){

        app.getSearchHelper().findCarByLocationAndDate("New York","12 OCT 2021","15 OCT 2021");

    }
}
