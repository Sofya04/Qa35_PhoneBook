package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Random;


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



    public void addNewContacts(Contact contact) {
        openAddNewContactForm();
        fillAllFields(contact);
        saveNewContact();


    }
    public int removeOneContact() {
        int before =countOfContact();

        if(!isCountListEmpty()) {
            removeContact();
        }

        int after = countOfContact();
        return before-after;
    }

    private boolean isCountListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(500);
    }

    private int countOfContact() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
//        List <WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
//        for (int i = 0; i < list.size(); i++) {
//            click(By.cssSelector(".contact-item_card__2SOIM"));
//            click(By.xpath("//button[text()='Remove']"));
//            pause(500);
//        }

        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            removeContact();
        }
    }
    public boolean isNoContactsHere() {
        return new WebDriverWait(wd, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector(".contact-page_message__2qafk h1")),"No Contacts here!" ));
    }

    public void providerOfContacts() {
        //check count of contacts <3 --- > add 3 contacts
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        if(wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()<=3){
            addNewContacts(Contact.builder().name("Alexandr").lastName("Markov").phone("74665"+i).email("alexandr"+i+"@mail.com").address("Haifa").build());
            addNewContacts(Contact.builder().name("Evgenii").lastName("Huston").phone("5682"+i).email("evgenii"+i+"@mail.com").address("New York").build());
            addNewContacts(Contact.builder().name("Matilda").lastName("Kohen").phone("2543"+i).email("matilda"+i+"@mail.com").address("Jerusalem").build());

        }

    }
}
