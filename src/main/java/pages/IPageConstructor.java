package pages;

import constants.WaitDuration;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public interface IPageConstructor<PAGE extends BasePage> {

    default void initElements(AppiumFieldDecorator decorator) {
        PageFactory.initElements(decorator, this);
    }

    default void initElements(AppiumDriver driver, WaitDuration waitDuration) {
        this.initElements(new AppiumFieldDecorator(driver, waitDuration.getDuration()));
    }

    default void waitPage() {}

    AppiumDriver getAppiumDriver();
}
