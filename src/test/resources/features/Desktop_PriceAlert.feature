Feature: Desktop | Price Alert
  @smoke1
  Scenario: The user can select to PriceAlert and delete

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "Giriş Yap" button
    When The user enters valid credentials
    And The user clicks "Giriş Yap" buttonn
    And The user navigates to "GİYİM" "Business Elbiseler" category
    When The user verifies redirected to "/tr-TR/giyim-elbiseler-business-elbiseler" page
    And The user clicks anyone product
    Then The user clicks "Fiyatı Düşünce Haber Ver" button
    And The user enters valid price
    Then The user clicks "Kaydet" button
    And The user verifies "İlgili ürün indirime girdiğinde sizleri bilgilendireceğiz. İlginiz için teşekkürler." message
    And The user closes popUps
    And The user clicks "Hesabım" button
    Then The user clicks "Fiyat Alarmı" button
    And The user verifies redirected to "/tr-TR/account/price-subscription" page
    And The user remove product
    And The user verifies "Fiyat alarmınız bulunmamaktadır." message
    Then The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/tr-TR?logout=true" page

    # Web görünümde Listeden çıkar butonu olmadığı için beklemeye alınmıştır. Mail atıldı