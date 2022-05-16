Feature: Desktop | Forget Password - The user tries to send forget password email
  @smoke
  Scenario: The user tries to send an email with empty inputs
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "Giriş Yap" button
    And The user clicks "Şifremi unuttum" button
    And The user verifies redirected to "/auth/forgot-password" page
    Then The user clicks "Şifremi Sıfırla" button
    And The user verifies "Bu alan zorunludur." message
    And The user enters forget password email address
    And The user clicks "Şifremi Sıfırla" button
    Then The user verifies "Şifrenizi yenilemek için gerekli link email adresinize yollanmıştır. Lütfen emailinizi kontrol ediniz." message