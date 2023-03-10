Feature: Desktop | Add to basket

 @smoke
  Scenario:Add to basket and delete product from basket
  Given The user visits GerryWeber homepage
  And The user verifies redirected to homepage
  And The user clicks "Giriş Yap" button
  When The user enters valid credentials
  And The user clicks "Giriş Yap" buttonnn
  And The user navigates to "GİYİM" "Casual Elbiseler" category
  When The user verifies redirected to "/tr-TR/giyim-elbiseler-casual-elbiseler" page
  And The user clicks any product
  And The user chooses size
  And The user clicks "SEPETE EKLE" button
  And The user clicks "Sepete Git" button
  And The user verifies redirected to "/tr-TR/basket" page
  When The user clicks "Sepeti Onayla" button
  And The user verifies redirected to "/tr-TR/checkout/payment" page
  When The user enters valid informations
  And The user clicks "Adresi Kaydet" button
  When The user clicks "Ödemeye Geç" button
  And The user enters invalid informations
  And The user selects On Bilgilendirme and Mesafeli Satis Sozlesmesi buttons
  And The user clicks "Siparişi Tamamla" button
  And The user verifies "Kart numarası geçersizdir" message
  Then The user clicks Back button
  And The user clicks "Sil" button
  And The user verifies "Alışveriş sepetiniz boş!" message
  And The user clicks "Hesabım" button
  And The user clicks "Adreslerim" button
  And The user clicks "Sil" button
  And The user verifies "Kayıtlı adresiniz bulunmamaktadır." message
  Then The user clicks "Çıkış Yap" button
  And The user verifies redirected to "/tr-TR?logout=true" page
