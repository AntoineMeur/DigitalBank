package co.wedevx.digitalbank.automation.ui.models;


import co.wedevx.digitalbank.automation.ui.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class User {

    private String title;
    private String firstName;
    private String lastName;
    private char gender;
    private String dateOfBirth;
    private String ssn;
    private String email;
    private String password;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;

    public User(String title, String firstName, String lastName, char gender, String dateOfBirth, String ssn, String email, String password, String address, String city, String region, String postalCode, String country, String homePhone, String mobilePhone, String workPhone) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.ssn = ssn;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
    }

    public void signup (){
        WebDriver driver = Driver.getDriver();
        driver.get("https://dbank-qa.wedevx.co/bank/signup");

        WebElement selectInput = driver.findElement(By.id("title"));
        Select select = new Select(selectInput);
        select.selectByValue(title);
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys(lastName);
        WebElement genderRadio = driver.findElement(By.xpath("//input[@value='" + gender + "']"));
        genderRadio.click();
        WebElement dateOfBirthInput = driver.findElement(By.id("dob"));
        dateOfBirthInput.sendKeys(dateOfBirth);
        WebElement ssnInput = driver.findElement(By.id("ssn"));
        ssnInput.sendKeys(ssn);
        WebElement emailInput = driver.findElement(By.id("emailAddress"));
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement confirmPasswordInput = driver.findElement(By.id("confirmPassword"));
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        WebElement nextButton = driver.findElement(By.xpath("//button"));
        nextButton.click();
        WebElement addressInput = driver.findElement(By.id("address"));
        addressInput.sendKeys(address);
        WebElement localityInput = driver.findElement(By.id("locality"));
        localityInput.sendKeys(city);
        WebElement regionInput = driver.findElement(By.id("region"));
        regionInput.sendKeys(region);
        WebElement postalCodeInput = driver.findElement(By.id("postalCode"));
        postalCodeInput.sendKeys(postalCode);
        WebElement countryInput = driver.findElement(By.id("country"));
        countryInput.sendKeys(country);
        WebElement homePhoneInput = driver.findElement(By.id("homePhone"));
        homePhoneInput.sendKeys(homePhone);
        WebElement mobilePhoneInput = driver.findElement(By.id("mobilePhone"));
        mobilePhoneInput.sendKeys(mobilePhone);
        WebElement workPhoneInput = driver.findElement(By.id("workPhone"));
        workPhoneInput.sendKeys(workPhone);
        WebElement agreeBox = driver.findElement(By.id("agree-terms"));
        agreeBox.click();
        WebElement register = driver.findElement(By.xpath("//button[@type='submit']"));
        register.click();
        passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();



    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
}
