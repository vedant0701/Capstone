
package HRM.Utility;

import org.testng.Assert;
import org.testng.annotations.Test;
public class LoginTestClass extends BaseClass
{
    @Test
    public void LoginFunctionality()
    {
        System.out.println("Login Functionality Testing Started");
        System.out.println("Username Entered - Admin");
        System.out.println("Password Entered - admin123");
        lp.LoginDetails("Admin", "admin123");
        Assert.assertTrue(lp.geturl().contains("dashboard"),"HRM Login Failed");
        System.out.println("HRM Login Functionality Passed");
        System.out.println("Login Functionality Testing Completed");
        System.out.println("--------------------------------------");
        //lp.logout();
        Utility.addWait();
    }

    @Test(dependsOnMethods = "LoginFunctionality")
    public void testLogout()
    {
        System.out.println("Logout Functionality Testing Started");
        lp.logout();
        Assert.assertTrue(lp.geturl().contains("login"),"Logout Function Failed");
        System.out.println("Successfully Logout from the HRM Application");
        System.out.println("Logout Functionality Testing Completed");
        System.out.println("-----------------------------------------------");
    }
}
