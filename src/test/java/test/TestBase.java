package test;

import aplication.AplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static AplicationManager app = new AplicationManager();

    @BeforeSuite
    public void setUp() {
        app.init();

    }

   /* @AfterSuite
    public void tearDown() {
        app.stop();

    }*/


}
