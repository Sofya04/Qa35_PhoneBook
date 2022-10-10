import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        logger.info("Start authorization check");
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
            logger.info("Test was needed in logout");
        }
    }

    @Test
    public void loginSuccess() {

        logger.info("email sonka04@gmail.com && password Sonka04$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sonka04@gmail.com", "Sonka04$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert checked the presence of Sign out button");

    }

    @Test
    public void loginSuccessModel() {

        User user = new User().withEmail("sonka04@gmail.com").withPassword("Sonka04$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        //app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test
    public void loginNegativeWrongEmailFormat(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(new User().withEmail("sonka04gmail.com").withPassword("Sonka04$"));
        app.getHelperUser().submitLogin();
        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }

    @Test
    public void loginNegativeWrongPasswordFormat(){

        User user = new User().withEmail("sonka04gmail.com").withPassword("kotic74387$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

    }
}
