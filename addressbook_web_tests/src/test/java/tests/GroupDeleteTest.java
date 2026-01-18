package tests;

import manager.ApplicationManager;
import model.GroupData1;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupDeleteTest extends TestBase {

    @Test
    public void canDeleteGroup() {
        ApplicationManager.driver.findElement(By.linkText("groups")).click();
        List<WebElement> checkboxesBefore = ApplicationManager.driver.findElements(By.name("selected[]"));
        int before = checkboxesBefore.size();
        if (before > 0) {
            checkboxesBefore.get(0).click();
        } else {
            throw new AssertionError("Группы отсутсвуют");
        }
        app.groups().RemoveGroup();
        List<WebElement> checkboxesAfter = ApplicationManager.driver.findElements(By.name("selected[]"));
        int after = checkboxesAfter.size();
        assertEquals(before - 1, after);
    }

    @Test
    public void canDeleteGroupWithCreation() {
        if (!app.groups().isGroupPresent(app)) {
            app.groups().CreateGroup(new GroupData1("New group 1", "Header1", "Footer1"));
        }
        app.groups().RemoveGroup();
    }
}
