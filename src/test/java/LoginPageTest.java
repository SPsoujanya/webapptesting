import com.qa.base.BasePage;
import com.qa.pages.HomePageClass;
import com.qa.pages.LoginPageClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.PriorityQueue;

import static org.testng.Assert.assertTrue;

public class LoginPageTest extends BasePage {

    LoginPageClass loginPage;
    HomePageClass homepage;


    //to call parentclass constructor, you need to create constructor
    public LoginPageTest() {
        super(); //properties are initialized
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        //create object of loginpageclass
        loginPage = new LoginPageClass();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
    }

    @Test(priority = 2)
    public  void imgLogoTest() {
        boolean flag = loginPage.validateimgLogo();
        assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginPageTest() {
        homepage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
