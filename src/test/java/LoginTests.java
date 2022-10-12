import manager.DataProviderUser;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test (dataProvider = "loginSuccess", dataProviderClass = DataProviderUser.class)
    public void loginSuccess(String email, String password) {

        logger.info("email "+email+" && password "+password);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitLogin();

        app.getHelperUser().pause(2000);

        Assert.assertTrue(app.getHelperUser().isLogged());

        logger.info("Assert checked the presence of Sign out button");
    }

    @Test (dataProvider = "loginSuccessModel", dataProviderClass = DataProviderUser.class)
    public void loginSuccessModel(User user) {

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();
        //app.getHelperUser().pause(2000);

        Assert.assertTrue(app.getHelperUser().isLogged());

        logger.info("User with such data "+user.getEmail()+user.getPassword()+"has successfully logged in");
    }

    @Test (dataProvider = "loginNegativeWrongEmailFormat", dataProviderClass = DataProviderUser.class)
    public void loginNegativeWrongEmailFormat(User user){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

        logger.info("User with wrong email: "+user.getEmail()+" cannot login");

    }

    @Test (dataProvider = "loginNegativeWrongPasswordFormat", dataProviderClass = DataProviderUser.class)
    public void loginNegativeWrongPasswordFormat(User user){

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitLogin();

        Assert.assertFalse(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
        Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

        logger.info("User with wrong password: "+user.getPassword()+" cannot login");


    }
}
