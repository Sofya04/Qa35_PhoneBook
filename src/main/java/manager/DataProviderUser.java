package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> loginSuccess(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"sonka04@gmail.com","Sonka04$"});
        list.add(new Object[]{"helloworld3125@gmail.com","Helloworld123$"});
        list.add(new Object[]{"helloworld3128@gmail.com","Helloworld123$"});
        list.add(new Object[]{"helloworld3126@gmail.com","Helloworld123$"});
        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[]> loginSuccessModel(){

        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("sonka04@gmail.com").withPassword("Sonka04$")});
        list.add(new Object[]{new User().withEmail("helloworld3125@gmail.com").withPassword("Helloworld123$")});
        list.add(new Object[]{new User().withEmail("helloworld3126@gmail.com").withPassword("Helloworld123$")});
        list.add(new Object[]{new User().withEmail("helloworld3128@gmail.com").withPassword("Helloworld123$")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginNegativeWrongEmailFormat(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("sonka04gmail.com").withPassword("Sonka04$")});
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> loginNegativeWrongPasswordFormat(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{new User().withEmail("sonka04@gmail.com").withPassword("kotic74387$")});
        return list.iterator();

    }
}
