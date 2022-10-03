import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("sonka04@gmail.com").withPassword("Sonka04$"));
        }
    }

    @Test
    public void addNewContactSuccessWithAllFields(){

        Contact contact = Contact.builder().name("Volodymyr")
                .lastName("Zelenskyy")
                .phone("38493729109")
                .email("vladimir78@mail.com")
                .address("Kryvyi Rih")
                .description("My dear friend")
                .build();
        app.helperContact().openAddNewContactForm();
        app.helperContact().fillAllFields(contact);
        app.helperContact().saveNewContact();

       //Assert.assertTrue(app.helperContact().isContactAdded(contact.getPhone()));


    }

    @Test
    public void addNewContactSuccessWithRequiredFields(){
        Contact contact = Contact.builder()
                .name("Alex")
                .lastName("Kuper")
                .phone("0529457983")
                .email("alex85@gmail.com")
                .address("Tel-Aviv")
                .build();
        app.helperContact().openAddNewContactForm();
        app.helperContact().fillRequiredFields(contact);
        app.helperContact().saveNewContact();
        //Assert.assertTrue(app.helperContact().isContactAdded(contact.getPhone()));

    }
}