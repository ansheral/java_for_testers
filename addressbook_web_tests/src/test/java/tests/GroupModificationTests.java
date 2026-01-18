package tests;

import model.GroupData1;
import org.junit.jupiter.api.Test;

public class GroupModificationTests extends TestBase{
    @Test
    void canModifyGroup(){
    if (!app.groups().isGroupPresent(app)) {
            app.groups().CreateGroup(new GroupData1("New group 1", "Header1", "Footer1"));
        }
    app.groups().modifyGroup(new GroupData1().withName("modified name"));
    }
}
