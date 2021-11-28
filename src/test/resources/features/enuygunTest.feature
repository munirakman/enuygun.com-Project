Feature: US1001 enuygun uçak bileti rezervasyonu

  @enuygun
  Scenario Outline: TC01 enuygun.com uçak rezervasyonu yapma
    Given kullanici "enuygunUrl" sayfasina gider
    When ucak bileti bolumune tiklar
    And nereden box'inda istanbul'a tiklar
    And nereye box'inda Paris'e tiklar
    And gidis tarihine gecerli tarihi girer
    And ucuz bilet bul butonuna tiklar
    And listelenen ucuslardan birinde sec butonuna tiklar
    And ilgili kutulara "<eposta>" "<ceptelefonu>" "<ad>" "<soyad>" bilgileri girer
    And dogum tarihi dropdown menusunden girer
    And bu bileti sonrasi icin ayir butonuna basar
    And sayfa kapanir

    Examples:
    |eposta                   |ceptelefonu    |ad          |soyad|
    |munirakman2607@gmail.com | 452525980     |Munir       |Akman|


