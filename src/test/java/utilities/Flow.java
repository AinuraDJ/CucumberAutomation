package utilities;

import org.openqa.selenium.interactions.Actions;

public class Flow {

    // create a static method wait that accepts integer millisecond
    // the method simply uses Thread sleep with exception handled
    // Flow.wait(500);
    public static void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Interruption happened");
        }
    }

    public static void scrollDown(int i){
        Actions actions=new Actions(Driver.getDriver());
        actions.scrollByAmount(0,i).perform();

    }

    public static void scrollUp(int i){
        Actions actions=new Actions(Driver.getDriver());
        actions.scrollByAmount(0,-i).perform();

    }

}

