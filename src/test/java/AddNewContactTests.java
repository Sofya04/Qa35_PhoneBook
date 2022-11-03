import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;


public class AddNewContactTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("sonka04@gmail.com").withPassword("Sonka04$"));
        }
    }

    @Test (groups = {"smoke", "sanity"})
    public void addNewContactSuccessWithAllFields(){

        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact = Contact.builder().name("Volodymyr")
                .lastName("Zelenskyy")
                .phone("3849"+i)
                .email("vladimir"+i+"@mail.com")
                .address("Kryvyi Rih")
                .description("My dear friend")
                .build();
        app.helperContact().openAddNewContactForm();
        app.helperContact().fillAllFields(contact);
        app.helperContact().saveNewContact();

        Assert.assertTrue(app.helperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact.getPhone()));

    }

    @Test
    public void addNewContactSuccessWithRequiredFields(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;

        Contact contact1 = Contact.builder()
                .name("Alex")
                .lastName("Kuper")
                .phone("05294" + i)
                .email("alex"+i+"@gmail.com")
                .address("Tel-Aviv")
                .build();

        Contact contact2 = Contact.builder()
                .name("Sonya")
                .lastName("Gurevich")
                .phone("048374" + i)
                .email("sonka04"+i+"@gmail.com")
                .address("Rehovot")
                .build();
        app.helperContact().openAddNewContactForm();
        app.helperContact().fillRequiredFields(contact1);
        app.helperContact().saveNewContact();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact1.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact1.getPhone()));

        app.helperContact().openAddNewContactForm();
        app.helperContact().fillRequiredFields(contact2);
        app.helperContact().saveNewContact();
        Assert.assertTrue(app.helperContact().isContactAddedByName(contact2.getName()));
        Assert.assertTrue(app.helperContact().isContactAddedByPhone(contact2.getPhone()));
    }

    @Test
    public void addNewContactWrongName(){
        Contact contact1 = Contact.builder()
                .name("")
                .lastName("Kuper")
                .phone("052944898")
                .email("alex@gmail.com")
                .address("Tel-Aviv")
                .build();
        app.helperContact().openAddNewContactForm();
        app.helperContact().fillRequiredFields(contact1);
        app.helperContact().saveNewContact();
        Assert.assertTrue(app.helperContact().isPageStillDisplayed());

    }
}