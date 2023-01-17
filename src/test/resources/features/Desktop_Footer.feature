Feature: Desktop | Footer links are addressed correctly or not?

  @smoke
  Scenario Outline: Footer links validation

    Given The user visits GerryWeber homepage
    And The user verifies redirected to homepage
    And The user clicks "<Links>" and verifies "<Title>"

    Examples:
      | Links                                                  | Title                                                  |
      | Hakkımızda                                             | Hakkımızda                                             |
      | Çerez Politikası                                       | ÇEREZ (COOKİE) POLİTİKASI                              |
      | Kişisel Verilerin Korunmasına İlişkin Aydınlatma Metni | Kişisel Verilerin Korunmasına İlişkin Aydınlatma Metni |
      | Sıkça Sorulan Sorular                                  | Sıkça Sorulan Sorular                                  |
      | İade Koşulları ve Değişim                              | Cayma - İade Koşulları                                 |