import org.junit.jupiter.api.Test;

public class GroupCreationTest extends TestBase{


    @Test
    public void canCreateGroup() {
        OpenGroupsPage();
        CreateGroup("New group 1", "Header1", "Footer1");
    }

    @Test
    public void canCreateEmptyGroup() {
        OpenGroupsPage();
        CreateGroup("", "", "");
    }
}
