package co.wedevx.digitalbank.automation.ui.steps.data_transformers;

import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
    @After
    public void afterEachScenario(Scenario scenario){
        Driver.takeScreenshot(scenario);
        Driver.closeDriver();
    }
}
