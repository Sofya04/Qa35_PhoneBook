package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class HelperContact extends HelperBase {

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddNewContactForm() {
        pause(5000);
        click(By.cssSelector("a[href='/add']"));

    }

    public void fillAllFields(Contact contact) {
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

    public boolean isContactAddedByName(String name) {//id=phone number
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name)) {
                return true;
            }
        }
        return false;

    }

    public void fillRequiredFields(Contact contact) {
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
    }

    public boolean isContactAddedByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPageStillDisplayed() {
        return wd.findElements(By.cssSelector("a[href='/add'].active")).size() > 0;
    }

    public void findContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
    }

    public void clickRemoveButton() {
        click(By.xpath("//button[text()='Remove']"));
        pause(200);
    }

    public void removeAllContacts() {
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        for (WebElement el : list) {
            click(By.cssSelector(".contact-item_card__2SOIM"));
            click(By.xpath("//button[text()='Remove']"));
            pause(2000);
        }

    }

    public boolean isContactBookEmpty() {
      List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
      return list.size() == 0;
    }


    public void addNewContacts(Contact contact) {
        openAddNewContactForm();
        fillAllFields(contact);
        saveNewContact();


    }
}
