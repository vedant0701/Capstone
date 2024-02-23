package HRM.Utility;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;

//import HRM.Utility.Utility;
public class BaseClass
{
    public WebDriver driver;
    public LoginPage  lpage;
    public Admin apage;
    @BeforeTest
    public void Setup()
    {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        lpage=PageFactory.initElements(driver, LoginPage.class);
        apage=PageFactory.initElements(driver, Admin.class);
    }
    @DataProvider(name="UserData")
    public Object[][] ExcelDataReader() throws IOException
    {
        Object Utility;
        return Utility.ExcelDataRead("/Users/vedantnaik/Desktop/Dataset.xlsx", "userdata");
    }
    @BeforeClass
    public void setup()
    {
        System.out.println("Application Logain Started "
                + "\n Username Entered : - Admin "
                + "\n Password Entered : - amin123");
        lpage.LoginDetails("Admin", "admin123");
        System.out.println("Login Succefully"
                + "\n---------------------------------");
    }
    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
