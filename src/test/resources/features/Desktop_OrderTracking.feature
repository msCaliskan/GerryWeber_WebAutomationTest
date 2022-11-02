Feature: Desktop | Order Tracking feature

  @smoke
  Scenario: Order tracking with informations

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "Sipariş Takip" button
    And The user verifies redirected to "/tr-TR/order-tracking" page
    And The user enters informations
    And The user clicks "Sorgula" button
    And The user verifies "Sipariş kaydı bulunamadı." message