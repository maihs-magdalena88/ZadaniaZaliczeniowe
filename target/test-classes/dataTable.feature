Feature: Data table
  Dodawanie nowego adresu dla zalogowanego uzytkownika

  Scenario Outline:
    Given Jestem na stronie addresses
    When Wypelnienie formularza <alias>, <address>, <city>, <zip>, <country>, <phone>
    Then Nowy adres powinien zostac dodany

    Examples:
      |alias          |address            |city        |zip      |country            |phone      |
      |"NataszaDom"   |"Sloneczna 32"     |"Ptaszkow"  |"58-100" |"United Kingdom"   |"523325564"|
