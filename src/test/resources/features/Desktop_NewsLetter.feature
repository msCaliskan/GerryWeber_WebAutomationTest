@smoke
Feature: Desktop | NewsLetter Form

  Scenario: Check the NewsLetter Form with empty values
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks submit button
    And The user verifies "Bu alan zorunludur." message
    And The user verifies "Bu alan zorunludur." messagee

  Scenario: Check the NewsLetter Form empty email
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks Confirm Privacy Policy button
    And The user clicks submit button
    And The user verifies "Bu alan zorunludur." message

  Scenario: Check the Newsletter Form with invalid email
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user enters invalid emails
    And The user clicks Confirm Privacy Policy button
    And The user clicks submit button
    And The user verifies "Geçerli bir mail adresi giriniz." message

  Scenario: Check the NewsLetter Form with valid email
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user enters valid emails
    And The user clicks Confirm Privacy Policy button
    And The user clicks submit button
    And The user verifies "Kaydolduğunuz İçin Teşekkür Ederiz" message

