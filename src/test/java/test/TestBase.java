package test;

import aplication.AplicationManager;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static AplicationManager app = new AplicationManager();

    @BeforeClass
    public void setUp() {
        app.init();

    }

    public void tearDown() {


    }


}
