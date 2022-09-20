import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void loginSuccess() {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sonka04@gmail.com", "Sonka04$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());

    }

    @Test
    public void loginSuccessModel() {

        User user = new User().withEmail("sonka04@gmail.com").withPassword("Sonka04$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("sonka04@gmail.com", "Sonka04$");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);
        Assert.assertTrue(app.getHelperUser().isLogged());

    }
}
