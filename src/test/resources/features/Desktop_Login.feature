@smoke
Feature: Desktop | Login with valid and invalid credentials

  Background:
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "Giriş Yap" button

  Scenario: Login with valid credentials
    And The user enters valid credentials
    And The user clicks "Giriş Yap" buttonn
    When The user clicks "Hesabım" button
    And The user verifies redirected to "/account/info" page
    And The user checks "Musa", "Çalışkan", "musainveon@gmail.com" and "0507 500 29 20" informations
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR" page

  Scenario: The user must not be able to login with invalid email
    And The user enters invalid email
    And The user clicks "Giriş Yap" buttonn
    And The user verifies "E-posta adresiniz ve/veya şifreniz hatalıdır." message

  Scenario: The user must not be able to login with invalid password
    And The user enters invalid password
    And The user clicks "Giriş Yap" buttonn
    And The user verifies "E-posta adresiniz ve/veya şifreniz hatalıdır." message
