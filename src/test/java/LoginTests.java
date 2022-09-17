import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



public class LoginTests extends TestBase{

    @Test
    public void loginSuccess() {

        //open login form
        //WebElement loginTab = wd.findElement(By.cssSelector("[aria-current='page']"));
        WebElement loginTab = wd.findElement(By.xpath("//a[@href='/login']"));
        loginTab.click();
        //fill email sonka04@gmail.com password Sonka04$
        WebElement inputEmail = wd.findElement(By.xpath("//input[@placeholder='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("sonka04@gmail.com");

        WebElement inputPassword = wd.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Sonka04$");

        //submit login
        WebElement submission = wd.findElement(By.xpath("//*[text()=' Login']"));
        submission.click();

        wd.close();

    }

    @Test
    public void loginSuccess() {

        //open login form
        //WebElement loginTab = wd.findElement(By.cssSelector("[aria-current='page']"));
        WebElement loginTab = wd.findElement(By.xpath("//a[@href='/login']"));
        loginTab.click();
        //fill email sonka04@gmail.com password Sonka04$
        WebElement inputEmail = wd.findElement(By.xpath("//input[@placeholder='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("sonka04@gmail.com");

        WebElement inputPassword = wd.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("Sonka04$");

        //submit login
        WebElement submission = wd.findElement(By.xpath("//*[text()=' Login']"));
        submission.click();

        wd.close();

    }

    @Test
    public void loginNegativeWrongEmailFormat() {

    }


    @AfterTest
    public void tearDown() {
        wd.quit();
    }
}
