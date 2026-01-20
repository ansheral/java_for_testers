package manager;

import org.openqa.selenium.By;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void click(By locator) {
        ApplicationManager.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        ApplicationManager.driver.findElement(locator).sendKeys(text);
    }
}
