
package HRM.Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
public class Admin
{
    public WebDriver driver;
    public int menuitems;

    public Admin(WebDriver driver)
    {
        this.driver=driver;
    }

    private @FindBy(xpath="//li[@class='oxd-main-menu-item-wrapper']")
    List<WebElement> menulist;
    private @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement username;
    private @FindBy(xpath="//button[@type='submit']")
    WebElement searchbutton;
    private @FindBy(xpath="//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border']")
    List<WebElement> row;
    private @FindBy(xpath="//div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell']")
    List<WebElement> cell;
    private @FindBy(xpath="//button[text()=' Reset ']")
    WebElement resetbutton;
    private @FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]")
    WebElement userroledropdown;
    private @FindBy(xpath="//div[@role='option']")
    List<WebElement> userrolelist;
    private @FindBy(xpath="(//div[@class=\"oxd-select-text--after\"])[2]")
    WebElement statusdropdown;
    private @FindBy(xpath="//div[@role='option']")
    List<WebElement> statuslist;

    public void refreshingpage()
    {
        resetbutton.click();
    }
    public int ListofMenu(String menuselection)
    {
        System.out.println("----------------------------------");
        System.out.println("***List of Menu Items***");
        for(WebElement i:menulist)
        {
            System.out.println(i.getText());
        }
        System.out.println("--------------------------------");
        for(WebElement i:menulist)
        {
            i.getText();
            if (i.getText().contains(menuselection))
            {
                System.out.println("Option Selected From Menu:- " +i.getText());
                i.click();
                break;
            }
        }
        return menuitems=menulist.size();
    }
    public void UserRoleDropdown(String optionselect)
    {
        userroledropdown.click();
        Utility.bootstrapdropdown(userrolelist, optionselect);
        searchbutton.click();
        Utility.addWait();
        System.out.println("Total Number Of Entries: -" +row.size());
        System.out.println("-------------------------------------");
        System.out.println("***Total Record Found***");
        for(int i=0; i<row.size(); i++)
        {
            for(int c=(i*6)+1; c<(6+(i*6)); c++)
            {
                System.out.print(cell.get(c).getText()+"\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }
    public void statusdropdown(String optionselect)
    {
        statusdropdown.click();
        Utility.bootstrapdropdown(statuslist, optionselect);
        searchbutton.click();
        Utility.addWait();
        System.out.println("Total Number Of Entries: -" +row.size());
        System.out.println("-------------------------------------");
        System.out.println("***Total Record Found***");
        for(int i=0; i<row.size(); i++)
        {
            for(int c=(i*6)+1; c<(6+(i*6)); c++)
            {
                System.out.print(cell.get(c).getText()+"\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }
    public void Usernamesrchbox(String usernamesrch)
    {
        username.sendKeys(usernamesrch);
        searchbutton.click();
        Utility.addWait();
        System.out.println("Total Number Of Entries: -" +row.size());
        System.out.println("-------------------------------------");
        System.out.println("***Total Record Found***");
        for(int i=0; i<row.size(); i++)
        {
            for(int c=(i*6)+1; c<(6+(i*6)); c++)
            {
                System.out.print(cell.get(c).getText()+"\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
    }
}
