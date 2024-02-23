
package HRM.Utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminTest extends BaseClass
{
    @Test(priority=1)
    public void verifyMenutIteam()
    {
        System.out.println("Verification of Number of Items in Menu List");
        int itemnumber=ap.ListofMenu("Admin");
        Assert.assertEquals(itemnumber, 12);
        System.out.println("-----------------------------------");
        System.out.println("Total Number of Acctual Items In Menu : -"+ itemnumber);
        System.out.println("Total Number of Expected Items In Menu : - 12");
        System.out.println("Total Number of Items Matched"
                + "\n===========================================");
    }

    @Test(priority=2)
    public void verifyUsernameSearch()
    {
        System.out.println("Automating Username Searchbox");
        ap.Usernamesrchbox("Admin");
        System.out.println("Automation Completed");
        Utility.addWait();
        System.out.println("Refreshing the Page");
        ap.refreshingpage();
        System.out.println("Refreshing of Page Completed"
                + "\n-------------------------------------");
    }

    @Test(priority=3)
    public void verifyUserRoleSearch()
    {
        System.out.println("Automating User role DropDown");
        ap.UserRoleDropdown("Admin");
        System.out.println("Automation Completed");
        Utility.addWait();
        System.out.println("Refreshing the Page");
        ap.refreshingpage();
        System.out.println("Refreshing of Page Completed"
                + "\n-------------------------------------");
    }

    @Test(priority=4)
    public void verifyStatusSearch()
    {
        System.out.println("Automating Status DropDown");
        ap.statusdropdown("Enabled");
        System.out.println("Automation completed");
        Utility.addWait();
        System.out.println("Refreshing the Page");
        ap.refreshingpage();
        System.out.println("Refreshing of Page Completed"
                + "\n-------------------------------------");

    }
}
