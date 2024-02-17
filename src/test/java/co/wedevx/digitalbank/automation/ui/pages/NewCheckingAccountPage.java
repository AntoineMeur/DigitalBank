package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCheckingAccountPage {

    private WebDriver driver;


    public NewCheckingAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Standard Checking")
    private WebElement standardCheckingRadio;
    @FindBy(id="Interest Checking")
    private WebElement interestCheckingRadio;

    @FindBy(id="Individual")
    private WebElement individualRadio;
    @FindBy(id="Joint")
    private WebElement jointRadio;

    @FindBy(id="name")
    private WebElement accountNameInput;

    @FindBy(id="openingBalance")
    private WebElement openingBalanceInput;

    @FindBy(id="newCheckingSubmit")
    private WebElement submit ;

    public void createNewAccount( String selectAccount, String selectOwnership,
                                  String accountName, String openingBalance ) {

        if(selectAccount.equalsIgnoreCase("Standard Checking")){
            standardCheckingRadio.click();
        } else {
            interestCheckingRadio.click();
        }

        if(selectOwnership.equalsIgnoreCase("Individual")){
            individualRadio.click();
        } else {
            jointRadio.click();
        }

        accountNameInput.sendKeys(accountName);
        openingBalanceInput.sendKeys(openingBalance);
        submit.click();
    }

}
