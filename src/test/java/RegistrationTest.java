import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getHelperUser().isLogged())
        app.getHelperUser().logOut();
    }

    @Test(invocationCount = 3, groups = {"smoke", "sanity"})
    public void registrationSuccess(){
        System.currentTimeMillis();
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        User user = new User().withEmail("helloworld" +i+ "@gmail.com").withPassword("Helloworld123$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        logger.info("Data "+ user.toString());
        Assert.assertTrue(app.getHelperUser().isLogged());
    }

    @Test
    public void registrationWithWrongEmailWithoutSpecialSymbol(){
        User user = new User().withEmail("hellomail.com").withPassword("Helloworld123$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }

    @Test
    public void registrationWithWrongEmailLackOfSymbols(){
        User user = new User().withEmail("hello@gmail.c").withPassword("Helloworld123$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    }

    @Test
    public void registrationWithWrongPasswordWithoutUppercaseLetter(){
        User user = new User().withEmail("ivanloginov41@yandex.ru").withPassword("ivanloginov41$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    }

    @Test
    public void registrationWithWrongPasswordWithoutLowercaseLetter(){
        User user = new User().withEmail("ivanloginov41@yandex.ru").withPassword("IVANLOGINOV41$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    }

    @Test
    public void registrationWithWrongPasswordWithoutDigit(){
        User user = new User().withEmail("ivanloginov41@yandex.ru").withPassword("Ivanloginov$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    }

    @Test
    public void registrationWithWrongPasswordWithoutSpecialSymbol(){
        User user = new User().withEmail("ivanloginov41@yandex.ru").withPassword("Ivanloginov123");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());
    }
}
