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
        

    }

}
