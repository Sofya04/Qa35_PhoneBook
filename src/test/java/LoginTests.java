import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    WebDriver wd;
    public void loginSuccess(){

        wd = new ChromeDriver();
        wd.manage().window().maximize();//open full screen
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//will check during 5 sec
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
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
        wd.quit();

    }
    @Test
    public void loginNegativeWrongEmailFormat(){

    }
}
