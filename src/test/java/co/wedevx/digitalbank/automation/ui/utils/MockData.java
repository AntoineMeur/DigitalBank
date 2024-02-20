package co.wedevx.digitalbank.automation.ui.utils;

import co.wedevx.digitalbank.automation.ui.models.User;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class MockData {

    private FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());


    public User generateRandomUser(){
       String title = generateRandomTitle();
       String firstName =  generateFirstName();
       String lastName = generateLastName();
       String email = generateRandomEmail();
       char gender = generateGender();
       String dob =generateBirthdate();
       String ssn = generateSsn();
       String password = generatePassword();
       String address = generateAddress();
       String locality = generateLocality();
       String region = generateRegion();
       String zipCode = generateZipcode();
       String country = generateCountry();
       String homePhone = generatePhone();
       String mobilePhone = generatePhone();
       String workPhone = generatePhone();
       User user = new User(title, firstName, lastName,gender, dob, ssn,  email, password, address, locality, region, zipCode, country, homePhone, mobilePhone, workPhone );
       user.signup();
       return user;
    }
    public String generateRandomTitle(){
        String[] titles = {"Mr.", "Mrs.","Ms."};
        int index = new Random().nextInt(titles.length);
        return titles[index];
    }

    public String generateFirstName(){
        String firstName = fakeValuesService.bothify(new Faker().name().firstName());
        return firstName;
    }

    public String generateLastName(){
        String lastName = fakeValuesService.bothify(new Faker().name().lastName());
        return lastName;
    }

    public String generateRandomEmail(){
        String email = fakeValuesService.bothify(generateFirstName() + "####@gmail.com");
        return email;
    }

    public char generateGender(){
        char[] gender = {'M', 'F'};
        int index = new Random().nextInt(gender.length);
        return gender[index];
    }

    public String generateBirthdate(){
        Faker faker = new Faker();
        Date date = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);

    }

    public String  generateSsn(){
        Random random = new Random();
        int part1 = random.nextInt(1000);
        int part2 = random.nextInt(100);
        int part3 = random.nextInt(10000);
        return String.format("%03d-%02d-%04d", part1, part2, part3);
    }

    public String generatePassword(){
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        password.append((char) (random.nextInt(26) + 'A'));
        password.append((char) (random.nextInt(26) + 'a'));
        password.append(random.nextInt(10));

        for (int i = 3; i < 15; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            password.append(c);
        }

        return password.toString();
    }

    public String generateAddress(){
        String address = fakeValuesService.bothify(new Faker().address().streetAddress());
        return address;
    }
    public String generateLocality(){
        String locality = fakeValuesService.bothify(new Faker().address().city());
        return locality;
    }

    public String generateRegion(){
        String region = fakeValuesService.bothify(new Faker().address().stateAbbr());
        return region;
    }
    public String generateZipcode(){
        String zipcode = fakeValuesService.bothify(new Faker().address().zipCode());
        return zipcode;
    }
    public String generateCountry(){
        String country = fakeValuesService.bothify(new Faker().address().country());
        return country;
    }
    public String generatePhone(){
        String phone = fakeValuesService.bothify(new Faker().phoneNumber().cellPhone());
        return phone;
    }


    public static void main(String[] args) {
        MockData mockData = new MockData();
        mockData.generateRandomUser();

    }
}
