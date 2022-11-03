Feature: Desktop | Multi Language

  @smoke
  Scenario: User checks category names and header names and login

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "Türkçe" button
    And The user clicks "English" button
    Then The user verifies redirected to "/en-US" page
    And The user verifies categories
      | NEW            |
      | CLOTHING       |
      | SUSTAINABILITY |
      | INSPIRATION    |
      | BRANDS         |
    And The user verifies header menu names
      | Order Tracking   |
      | Customer service |
      | F.A.Q.           |
      | English          |
      | Favorites        |
      | Login            |
      | Cart             |
    And The user clicks "Login" button
    And The user enters valid credentials
    And The user clicks "Login" buttonnn
    When The user clicks "My Account" button
    And The user verifies redirected to "/en-US/account/info" page
    And The user checks "Musa", "Caliskan", "musainveon@gmail.com" and "0507 500 29 20" informations
    And The user clicks "Log Out" button
    And The user verifies redirected to "/en-US?logout=true" page