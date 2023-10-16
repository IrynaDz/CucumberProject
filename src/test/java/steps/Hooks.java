package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;

public class Hooks {
    @Before
    public void beforeScenario(){
        System.out.println("my before method");
        System.out.println("Hello");
    }
    @After
    public void afterScenario(){
        Driver.closeDriver();
        System.out.println("closed window");
        System.out.println("Bye-bye");
    }
}
