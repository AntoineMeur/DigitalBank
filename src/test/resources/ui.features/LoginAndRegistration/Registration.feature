@Registration
Feature: Digital Bank registration page

  Scenario: Positive case. As a user, I want to successfully create a DB account.

    Given User navigates to Digital Bank signup page
    When user create account with following fields and with mocked email and ssn
      | title | firstName | lastName | gender | dob        | ssn    | email  | password  | address     | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | termsCheckMarks |
      | Mr.   | Jack      | Test     | M      | 12/12/1998 | random | random | Tester123 | 12 main St. | City     | CA     | 99921      | US      | 2132516658 | 5846857854  | 5486984124 | true            |
    Then the user should be displayed "Success Registration Successful. Please Login."


  Scenario Outline: Negative test case. I want to make sure a user can't register without providing all valid data

      Given User navigates to Digital Bank signup page
      When user create account with following fields and with mocked email and ssn
        | title   | firstName   | lastName   | gender   | dob   | ssn   | email   | password   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMarks |
        | <title> | <firstName> | <lastName> | <gender> | <dob> | <ssn> | <email> | <password> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> |<termsCheckMarks> |
    Then the user should see "<fieldWithError>" required field error message "<errorMessage>"

    Examples:

      | title | firstName | lastName | gender | dob | ssn | email | password | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | termsCheckMarks | fieldWithError | errorMessage                                  |
      |       |           |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                 | title          | Veuillez sélectionner un élément de la liste. |
      | Mr.   |           |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                 | firstName      | Veuillez compléter ce champ.                  |
      | Mr.   | Elon      |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                 | lastName       | Veuillez compléter ce champ.                  |
      | Mr.   | Elon      | Musk     |        |     |     |       |          |         |          |        |            |         |           |             |           |                 | gender         | Veuillez sélectionner l’une de ces options.   |






