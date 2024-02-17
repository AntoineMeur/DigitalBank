Feature: Creating a new checking account

  Scenario: Creating a new standard individual checking account
    Given The user is logged in "elonmusk99@spacex.com" , "ElonMusk9"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName             | initialDepositAmount |
      | Standard Checking   | Individual       | Elon's checking account | 100000.0             |
    Then the user should see the green "Successfully created new Standard Checking account named Elon's checking account" message
    And the user should see newly added account card
      | accountName            | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Elon's checking account | Standard Checking | Individual | 486134537     | 0.0%         | 100000.00 |
    And the user should see the following transaction
      | date             | category | description               | amount    | balance   |
      | 2024-01-30 05:30 | Income   | 845325809 (DPT) - Deposit | 100000.00 | 100000.00 |