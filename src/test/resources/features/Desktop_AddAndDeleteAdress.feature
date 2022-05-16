Feature: Desktop | The user adds new address and delete

  @smoke
  Scenario: Add new address and delete

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "Giriş Yap" button
    When The user enters valid credentials
    And The user clicks "Giriş Yap" buttonn
    And The user clicks "Hesabım" button
    Then The user clicks "Adreslerim" button
    And The user verifies redirected to "/account/addresses" page
    And The user verifies "Kayıtlı adresiniz bulunmamaktadır." message
    When The user clicks "Yeni Adres Ekle" button
    And The user enters valid informations
    And The user clicks "Kaydet" button
    And The user clicks "Sil" button
    And The user verifies "Kayıtlı adresiniz bulunmamaktadır." message
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR" page


