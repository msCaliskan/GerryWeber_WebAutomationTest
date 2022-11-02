Feature: Desktop | Guest add to basket

  @smoke
  Scenario:Guest add to basket and delete product from basket
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "GİYİM" button
    When The user verifies redirected to "/tr-TR/giyim" page
    And The user clicks any product
    And The user chooses size
    And The user clicks "SEPETE EKLE" button
    And The user clicks "Sepete Git" button
    And The user verifies redirected to "/tr-TR/basket" page
    Then The user clicks "Sepeti Onayla" button
    When The user clicks "Üye Olmadan Devam Et" button
    And The user verifies redirected to "/tr-TR/checkout/payment" page
    When The user enters valid informations for guest
    And The user clicks "Adresi Kaydet" button
    When The user clicks "Ödemeye Geç" button
    And The user enters invalid informations
    And The user selects On Bilgilendirme and Mesafeli Satis Sozlesmesi buttons
    And The user clicks "Siparişi Tamamla" button
    And The user verifies "Kart numarası geçersizdir" message
    Then The user clicks Back button
    And The user clicks Cart button
    And The user clicks "Sil" button
    Then The user verifies "Alışveriş sepetiniz boş!" message


