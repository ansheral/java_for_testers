package manager;

import model.GroupData1;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupHelper extends HelperBase{

    public GroupHelper(ApplicationManager manager){
        super(manager);
    }

    public void CreateGroup(GroupData1 group) {
        OpenGroupsPage();
        initGroupCreation();
        click(By.id("content"));
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void RemoveGroup() {
        OpenGroupsPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupsPage();
    }

    public void modifyGroup(GroupData1 modifiedGroup) {
        OpenGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }

    private void fillGroupForm(GroupData1 group) {
        click(By.name("group_name"));
        ApplicationManager.driver.findElement(By.name("group_name")).clear();
        type(By.name("group_name"),group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());
    }

    private void initGroupModification() {
        click(By.name("edit"));
    }

    private void selectGroup() {
        click(By.name("selected[]"));
    }

    public void OpenGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));
        }
    }

    public boolean isGroupPresent(ApplicationManager manager) {
        OpenGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void returnToGroupsPage() {
        WebDriverWait wait = new WebDriverWait(ApplicationManager.driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("group page"))).click();
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void initGroupCreation() {

        click(By.name("new"));
    }
    private void removeSelectedGroup() {
        click(By.name("delete"));
    }
}
