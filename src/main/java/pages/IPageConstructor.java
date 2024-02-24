package pages;

import constants.WaitDuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public interface IPageConstructor<PAGE extends BasePage> {

    default void initElements(AppiumFieldDecorator decorator) {
        PageFactory.initElements(decorator, this);
    }

    default void initElements(AppiumDriver driver, WaitDuration waitDuration) {
        this.initElements(new AppiumFieldDecorator(driver, waitDuration.getDuration()));
    }

    default void waitPage() {
        System.out.println("method waitPage() is not being overridden");
    }

    default PAGE waitLoaded() {
        try {
            waitPage();
        } catch(Exception e) {
            Assert.fail(String.format("timed out to wait until current active screen to be %s\noriginal error: %s", this.getClass().getSimpleName(), e.getMessage()));
        }
        return (PAGE) this;
    }
}
