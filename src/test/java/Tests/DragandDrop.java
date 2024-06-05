package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop extends MainChromeDriver{

    @Test
    public void test1()
    {
        //Navigate to the jQueryUI droppable website
        chromeDriver.get("https://jqueryui.com/droppable/");

        // Switch to the frame
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//iframe[@class='demo-frame']")));

        //Find the source element with the text Drag me to my target
        WebElement source = chromeDriver.findElement(By.xpath("//div[@id='draggable']"));
        //// Find the target element with the text Drop here
        WebElement target = chromeDriver.findElement(By.xpath("//div[@id='droppable']"));

        //perform drag and drop operation
        Actions action = new Actions(chromeDriver);
        action.dragAndDrop(source, target).perform();

        //Verify that the drag and drop operation is successful by checking the color property of the target CSS
        String targetElementColor = target.getCssValue("background-color");
        System.out.println("Background color of target : " + targetElementColor);

        // Verify that the text of the target element has changed to Dropped
        String targetText = target.getText();
        if(targetText.equals("Dropped!")) {
            System.out.println("Drag and drop operation was successful.");
        }
        else {
            System.out.println("Drag and drop operation was failed.");

        }














    }
}
