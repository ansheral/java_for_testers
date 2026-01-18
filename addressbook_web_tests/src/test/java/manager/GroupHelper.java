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
        initGroupCreation();
        ApplicationManager.driver.findElement(By.id("content")).click();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    private static void submitGroupCreation() {
        ApplicationManager.driver.findElement(By.name("submit")).click();
    }

    private static void initGroupCreation() {
        ApplicationManager.driver.findElement(By.name("new")).click();
    }

    public void RemoveGroup() {
        OpenGroupsPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupsPage();
    }

    private static void removeSelectedGroup() {
        ApplicationManager.driver.findElement(By.name("delete")).click();
    }

    public void modifyGroup(GroupData1 modifiedGroup) {
        OpenGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }

    private void returnToGroupsPage() {
         WebDriverWait wait = new WebDriverWait(ApplicationManager.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("group page"))).click();
    }

    private void submitGroupModification() {
        ApplicationManager.driver.findElement(By.name("update")).click();
    }

    private void fillGroupForm(GroupData1 group) {
        ApplicationManager.driver.findElement(By.name("group_name")).click();
        ApplicationManager.driver.findElement(By.name("group_name")).clear();
        ApplicationManager.driver.findElement(By.name("group_name")).sendKeys(group.name());
        ApplicationManager.driver.findElement(By.name("group_header")).click();
        ApplicationManager.driver.findElement(By.name("group_header")).sendKeys(group.header());
        ApplicationManager.driver.findElement(By.name("group_footer")).click();
        ApplicationManager.driver.findElement(By.name("group_footer")).sendKeys(group.footer());
    }

    private void initGroupModification() {
        ApplicationManager.driver.findElement(By.name("edit")).click();
    }

    private void selectGroup() {
        ApplicationManager.driver.findElement(By.name("selected[]")).click();
    }

}
