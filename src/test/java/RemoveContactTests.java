import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("sonka04@gmail.com").withPassword("Sonka04$"));

            if (app.helperContact().isContactBookEmpty()) {
                app.helperContact().addNewContacts(Contact.builder().name("Alex").lastName("Herzel").phone("857875983").email("alex54@mail.ru").address("Haifa").build());
                app.helperContact().addNewContacts(Contact.builder().name("Nikita").lastName("Malinov").phone("47873043").email("nikita2003@gmail.com").address("Moscow").build());
                app.helperContact().addNewContacts(Contact.builder().name("Simha").lastName("Digilov").phone("5398239843").email("simha2000@gmail.com").address("Rehovot").build());
            }
        }
    }

    @Test
    public void removeOneContact(){
        app.helperContact().findContact();
        app.helperContact().clickRemoveButton();

        //Assert.assertTrue("");
    }

    @Test
    public void removeAllContacts(){
        app.helperContact().findContact();
        app.helperContact().removeAllContacts();

        Assert.assertEquals(app.getHelperUser().getTitleMessage(), "No Contacts here!");
    }
}
