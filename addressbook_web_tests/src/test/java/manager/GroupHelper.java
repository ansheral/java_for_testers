package manager;

import model.GroupData1;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupHelper {
        private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager){
        this.manager = manager;
    }

    public void OpenGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            ApplicationManager.driver.findElement(By.linkText("groups")).click();
        }
    }

    public boolean isGroupPresent(ApplicationManager manager) {
        OpenGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void CreateGroup(GroupData1 group) {
        OpenGroupsPage();
        ApplicationManager.driver.findElement(By.name("new")).click();
        ApplicationManager.driver.findElement(By.id("content")).click();
        ApplicationManager.driver.findElement(By.name("group_name")).click();
        ApplicationManager.driver.findElement(By.name("group_name")).sendKeys(group.name());
        ApplicationManager.driver.findElement(By.name("group_header")).click();
        ApplicationManager.driver.findElement(By.name("group_header")).sendKeys(group.header());
        ApplicationManager.driver.findElement(By.name("group_footer")).click();
        ApplicationManager.driver.findElement(By.name("group_footer")).sendKeys(group.footer());
        ApplicationManager.driver.findElement(By.name("submit")).click();
        WebDriverWait wait = new WebDriverWait(ApplicationManager.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("group page"))).click();
    }

    public void RemoveGroup() {
        OpenGroupsPage();
        ApplicationManager.driver.findElement(By.name("delete")).click();
        WebDriverWait wait = new WebDriverWait(ApplicationManager.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("group page"))).click();
    }
}
