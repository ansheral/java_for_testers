package manager;

import org.openqa.selenium.By;

public class LoginHelper {
    private final ApplicationManager manager;

    public LoginHelper(ApplicationManager manager){
        this.manager = manager;
    }
    void login(String user, String password) {
        ApplicationManager.driver.findElement(By.name("user")).sendKeys(user);
        ApplicationManager.driver.findElement(By.name("pass")).click();
        ApplicationManager.driver.findElement(By.name("pass")).sendKeys(password);
        ApplicationManager.driver.findElement(By.xpath("//input[@value='Login']")).click();
    }
}
