Feature: Desktop | Filter feature
@wip
  Scenario:

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "GİYİM" button
    When The user verifies redirected to "/tr-TR/giyim" page
    And The user clicks "Kategori" button
    And The user clicks "Elbiseler" buttonn
    And The user verifies redirected to "/tr-TR/giyim-elbiseler" page
    And The user clicks "Casual Elbiseler" button
    And The user verifies redirected to "/tr-TR/giyim-elbiseler?category=2680_2643&pageIndex=0" page
