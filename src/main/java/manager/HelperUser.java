package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public boolean isLogged(){
        List<WebElement> list = wd.findElements(By.xpath("//button[text()='Sign Out']"));
        return list.size() > 0;
    }

    public void logOut(){
        wd.findElement(By.xpath("//button[text()='Sign Out']")).click();
    }

    public void openLoginRegistrationForm(){
        WebElement loginTab = wd.findElement(By.xpath("//a[@href='/login']"));
        loginTab.click();
    }

    public void fillLoginRegistrationForm(String email, String password){
        //Moderation version
        type(By.xpath("//input[@placeholder='Email']"), email);
        type(By.xpath("//input[@placeholder='Password']"), password);

    }

    public void fillLoginRegistrationForm(User user) {
        type(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        type(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }

    public void submitLogin(){
        WebElement submission = wd.findElement(By.xpath("//*[text()=' Login']"));
        submission.click();
    }

    public boolean isAlertPresent(){
        Alert alert = wd.switchTo().alert();
        if(alert == null){
            return false;
        }
        else {return true;}
    }

    public boolean isErrorWrongFormat(){
        Alert alert = wd.switchTo().alert();
        String errorText = alert.getText();
        System.out.println(errorText);
        //Click on [Ok] button
        alert.accept();
        //Click on [Cancel] button
        //alert.dismiss();
        //type text
        //alert.sendKeys("Hello");
        return errorText.contains("Wrong email or password format");
    }
//    public boolean isNoContactsHereDisplayed(){
//        return new WebDriverWait(wd, Duration.ofSeconds(5)).until(ExpectedConditions.textToBePresentInElement(By.cssSelector("[div.contact-page_message__2qafk>h1]"), "No Contacts here!"));
//    }

    public void submitRegistration() {
        click(By.xpath("//*[text()=' Registration']"));
    }

    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        submitLogin();
    }

    public String getTitleMessage(){
        pause(2000);
        return wd.findElement(By.cssSelector(".contact-page_message__2qafk>h1")).getText();
    }
}
