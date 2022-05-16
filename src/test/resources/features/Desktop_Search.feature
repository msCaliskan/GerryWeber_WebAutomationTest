Feature: Desktop | Search User searchs for a product

  @smoke
  Scenario: User searchs for a product
    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user fills "Pantolon" in the searchbox and click
    And The user verifies redirected to "/tr-TR/tum-urunler?searchValue=Pantolon" page
    Then The user should see all search results match with "Pantolon"
