package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.NewCheckingAccountPage;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefactoredCheckingAccountSteps {

    WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private NewCheckingAccountPage newCheckingAccountPage = new NewCheckingAccountPage(driver);

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }


    @Before
    public void the_user_on_dbank_homepage() {
        driver.get("https://dbank-qa.wedevx.co/bank/login");

    }

    @Given("The user is logged in {string} , {string}")
    public void the_user_is_logged_in(String username, String password) {
        loginPage.login(username, password);

    }
    @When("the user creates a new checking account with the following data")
    public void the_user_creates_a_new_checking_account_with_the_following_data(List<NewCheckingAccountInfo> checkingAccountInfoList) {
        NewCheckingAccountInfo testDataForCheckingAccount = checkingAccountInfoList.get(0);
        // user clicks on checking button
        WebElement checkingMenu = driver.findElement(By.id("checking-menu"));
        checkingMenu.click();
        // user clicks on new checking button
        WebElement newCheckingMenuItem = driver.findElement(By.id("new-checking-menu-item"));
        newCheckingMenuItem.click();
        newCheckingAccountPage.createNewAccount(testDataForCheckingAccount.getCheckingAccountType(),testDataForCheckingAccount.getAccountOwnership(),
                testDataForCheckingAccount.getAccountName(), String.valueOf(testDataForCheckingAccount.getInitialDepositAmount()));

    }




    @Then("the user should see the green {string} message")
    public void the_user_should_see_the_green_message(String expectedConfMessage) {
        WebElement newAccountConf = driver.findElement(By.id("new-account-msg"));
        assertEquals(expectedConfMessage, newAccountConf.getText());

    }

    @Then("the user should see newly added account card")
    public void the_user_should_see_newly_added_account_card(List<AccountCard> accountCardList) {
        List<WebElement> allFirstRowDivs = driver.findElements(By.xpath("//div[@id='firstRow']/div"));
        WebElement lastAccountCard = allFirstRowDivs.get(allFirstRowDivs.size()-1);
        String actualResult = lastAccountCard.getText();

        String actualAccountName = actualResult.substring(0,actualResult.indexOf("\n"));
        System.out.println(actualAccountName);

        String actualAccType = actualResult.substring(actualResult.indexOf("\n"),actualResult.indexOf("Ownership"));
        System.out.println(actualAccType.trim());

        String actualOwnership = actualResult.substring(actualResult.indexOf("Ownership"),actualResult.indexOf("Account Number"));
        System.out.println(actualOwnership.trim());

        String actualAccountNumber = actualResult.substring(actualResult.indexOf("Account Number"),actualResult.indexOf("Interest Rate"));
        System.out.println(actualAccountNumber.trim());

        String actualInterestRate = actualResult.substring(actualResult.indexOf("Interest Rate"),actualResult.indexOf("Balance"));
        System.out.println(actualInterestRate.trim());

        String actualBalance = actualResult.substring(actualResult.indexOf("Balance"));
        System.out.println(actualBalance.trim());


        AccountCard expectedResult = accountCardList.get(0);

        Assertions.assertEquals(expectedResult.getAccountName(), actualAccountName);
        Assertions.assertEquals("Account: " + expectedResult.getAccountType(), actualAccType.trim());
        Assertions.assertEquals("Ownership: " + expectedResult.getOwnership(), actualOwnership.trim());
        Assertions.assertEquals("Interest Rate: " + expectedResult.getInterestRate(), actualInterestRate.trim());

        String expectedBalance = String.format("%.2f", expectedResult.getBalance());
        Assertions.assertEquals("Balance: $" + expectedBalance, actualBalance);

        System.out.println("///////////////////////////////////////////");

    }

    @Then("the user should see the following transaction")
    public void the_user_should_see_the_following_transaction(List<BankTransaction> expectedTransactions) {
        WebElement firstRowOfTransactions = driver.findElement(By.xpath("//table[@id='transactionTable']/tbody/tr"));
        List<WebElement> firstRowColumns = firstRowOfTransactions.findElements(By.xpath("td"));

        String actualCategory = firstRowColumns.get(1).getText();
        double actualAmount = Double.parseDouble(firstRowColumns.get(3).getText().substring(1));
        double actualBalance = Double.parseDouble(firstRowColumns.get(4).getText().substring(1));

        BankTransaction expectedTransaction = expectedTransactions.get(0);
        Assertions.assertEquals(expectedTransaction.getCategory(), actualCategory, "Category mismatch");
        Assertions.assertEquals(expectedTransaction.getAmount(), actualAmount, "Amount mismatch");
        Assertions.assertEquals(expectedTransaction.getBalance(), actualBalance, "Balance mismatch");


    }



}
