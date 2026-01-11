import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupDeleteTest extends TestBase {

    @Test
    public void canDeleteGroup() {
        driver.findElement(By.linkText("groups")).click();
        List<WebElement> checkboxesBefore = driver.findElements(By.name("selected[]"));
        int before = checkboxesBefore.size();
        if (before > 0) {
            checkboxesBefore.get(0).click();
        } else {
            throw new AssertionError("Группы отсутсвуют");
        }
        RemoveGroup();
        List<WebElement> checkboxesAfter = driver.findElements(By.name("selected[]"));
        int after = checkboxesAfter.size();
        assertEquals(before - 1, after);
    }

    @Test
    public void canDeleteGroupWithCreation() {
        OpenGroupsPage();
        List<WebElement> checkboxesBefore = driver.findElements(By.name("selected[]"));
        if (!isGroupPresent()) {
            CreateGroup("New group 1", "Header1", "Footer1");
        }
        RemoveGroup();
    }
}
