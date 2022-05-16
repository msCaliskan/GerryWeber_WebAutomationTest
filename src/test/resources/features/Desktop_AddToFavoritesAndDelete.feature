Feature: Desktop | Add to favorites and delete
  @smoke
  Scenario: The user can add to favorites and delete

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "Giriş Yap" button
    When The user enters valid credentials
    And The user clicks "Giriş Yap" buttonn
    And The user navigates to "Giyim" "Business Elbiseler" category
    When The user verifies redirected to "/giyim-elbiseler-business-elbiseler" page
    And The user clicks anyone product
    And The user clicks "Favorilere Ekle" button
    And The user closes popUps
    And The user clicks "Hesabım" button
    Then The user clicks "Favori Listem" button
    And The user verifies redirected to "/account/favorites" page
    And The user hovers to product
    When The user clicks "Listeden Çıkar" button
    And The user verifies " Favori listenizde ürün bulunmamaktadır." message
    Then The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR" page
