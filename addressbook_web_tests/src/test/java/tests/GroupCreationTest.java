package tests;

import model.GroupData1;
import org.junit.jupiter.api.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void canCreateGroup() {
        app.OpenGroupsPage();
        app.CreateGroup(new GroupData1("New group 1", "Header1", "Footer1"));
    }

    @Test
    public void canCreateEmptyGroup() {
        app.OpenGroupsPage();
        app.CreateGroup(new GroupData1());
    }
      @Test
    public void canCreateNameOnlyGroup() {
        app.OpenGroupsPage();
        var emptyGroup = new GroupData1();
        var groupWithName = new GroupData1().withName("some name");
        app.CreateGroup(groupWithName);
    }
}
