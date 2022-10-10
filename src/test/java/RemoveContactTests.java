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

        }
        app.helperContact().providerOfContacts();
    }

    @Test
    public void removeOneContact(){

        Assert.assertEquals(app.helperContact().removeOneContact(), 1);
    }

    @Test
    public void removeAllContacts(){

        app.helperContact().removeAllContacts();
        Assert.assertTrue(app.helperContact().isNoContactsHere());

        Assert.assertEquals(app.getHelperUser().getTitleMessage(), "No Contacts here!");
    }
}
