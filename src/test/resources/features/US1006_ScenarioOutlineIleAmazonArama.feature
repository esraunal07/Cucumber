Feature: US1006 Kullanici Scenario outline ile birden fazla kelime aratir.


  Scenario Outline: TC10 Amazon coklu urun testi

    Given kullanici "amazonUrl" anasayfaya gider
    Then amazonda "<Kelimeler>" icin arama yapar
    And sonuclarin "<Kelimeler>" icerdigini test eder


    Examples:
    |Kelimeler |
    |Nutella   |
    |Java      |
    |Samsung   |
    |Apple     |
    |Furkan    |
