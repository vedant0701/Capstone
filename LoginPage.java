
package HRM.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import HRM.Utility.Utility;
import java.util.List;
public class LoginPage
{
    private WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private @FindBy(name="username") WebElement usernamefield;

    private @FindBy(name="password") WebElement passwordfield;

    private @FindBy(xpath="//button[@type=\"submit\"]") WebElement button;

    private @FindBy(xpath="//i[contains(@class,'userdropdown')]") WebElement profile;

    private By DropdownElement=By.xpath("//ul[@class=\"oxd-dropdown-menu\"]//li//a[@class=\"oxd-userdropdown-link\"]");

    public String geturl()
    {
        return driver.getCurrentUrl();
    }

    public String gettitle()
    {
        return driver.getTitle();
    }

    public void LoginDetails(String username, String password)
    {
        usernamefield.sendKeys(username);
        Utility.addWait();
        passwordfield.sendKeys(password);
        Utility.addWait();
        button.click();
    }
    public void logout()
    {
        profile.click();
        List<WebElement> list1= driver.findElements(DropdownElement);
        for (WebElement i : list1)
        {
            i.getText();
            if (i.getText().contains("Logout"))
            {
                i.click();
                break;
            }
        }
    }
}


