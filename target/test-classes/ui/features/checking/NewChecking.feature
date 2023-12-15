Feature: Creating a new checking account

  Scenario: Create a standard individual checking account
    Given The user with "elonmusk@gmail.com" is not in DB
    And User navigates to Digital Bank signup page
    When User creates account with following fields
      | title | firstName | lastName | gender | dob        | ssn         | email             | password  | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | termsCheckMark |
      | Mr.   | Elon      | Musk     | M      | 12/12/1990 | 123-11-1435 | elonmusk@gmail.com | Tester123 | 12 Main st | City     | CA     | 99921      | US      | 2146591008 | 2136591208  | 1126593008 | true           |
    Then User should be displayed with the message "Success Registration Successful. Please Login."
    Given the user logged in as "elonmusk@gmail.com" "Tester123"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnership | accountName               | initialDepositAmount |
      | Standard Checking   | Individual       | Elon Musk Second Checking | 100000.0             |
    Then the user should see the green "Successfully created new Standard Checking account named Elon Musk Second Checking" message
    And the user should see newly added account card
      | accountName               | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Elon Musk Second Checking | Standard Checking | Individual | 486131037     | 0.0%         | 100000.00 |
    And the user should see the following transactions
      | date             | category | description               | amount   | balance  |
      | 2023-08-30 21:51 | Income   | 845321734 (DPT) - Deposit | 100000.0 | 100000.0 |




