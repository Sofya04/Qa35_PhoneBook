package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperContact extends HelperBase{

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddNewContactForm() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillAllFields(Contact contact) {
        pause(200);
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDescription());
    }

    public void saveNewContact() {
        click(By.cssSelector("button b"));
    }
//    public int getContactsCountBeforeCreation(){
//        return wd.findElements(By.cssSelector("div.contact-item_card__2SOIM")).size();
//    }
//    public int getContactsCountAfterCreation(){
//        return wd.findElements(By.cssSelector("div.contact-item_card__2SOIM")).size()-getContactsCountBeforeCreation();
//    }
    public boolean isContactAdded(String phone){//id=phone number
        List<WebElement> list = wd.findElements(By.cssSelector("div.contact-item_card__2SOIM>h3"));
        return list.contains(phone);

    }

    public void fillRequiredFields(Contact contact) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("input[placeholder='Name']"))));
        //pause(200);
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
    }
}
