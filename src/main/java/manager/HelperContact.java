package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        click(By.xpath("//*[text()='Save']"));
    }
//    public int getContactsCountBeforeCreation(){
//        return wd.findElements(By.cssSelector("div.contact-item_card__2SOIM")).size();
//    }
//    public int getContactsCountAfterCreation(){
//        return wd.findElements(By.cssSelector("div.contact-item_card__2SOIM")).size()-getContactsCountBeforeCreation();
//    }
//    public boolean isContactAdded(){
//       return getContactsCountAfterCreation() > getContactsCountBeforeCreation();
//    }

    public void fillRequiredFields(Contact contact) {
        pause(200);
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
    }
}
