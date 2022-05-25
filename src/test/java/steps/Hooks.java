package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    @Before
    public void setUp() {
        //here we can add anything what is needed to be setup before the test
        //example database connection
        System.out.println("The scenario is running");
    }

    @After
    public void tearDown(Scenario scenario) {
        //
        if(scenario.isFailed() && Driver.getReference() != null) {
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screenshot");
        }

        Driver.closeDriver();

    }



}
