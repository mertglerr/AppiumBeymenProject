Feature: Beymen Mobil Uygulama Testi
  @beymen
  Scenario: Urun arama, sepete ekleme ve kontrol
    Given kullanici Beymen uygulamasini acar
    When arama kutucuguna excelden alinan 0. sutun 0. satirdaki veri girilir
    And arama kutucugu temizlenir sonra 0. sutun 1. satirdaki veri girilir
    And enter tusuna basilir
    And rastgele bir urun secilir
    Then secilen urun bilgisi ve fiyati txt dosyasina yazilir
    Then urun sepete eklenir
    Then urun sayfasindaki fiyat ile sepetteki fiyat karsilastirilir
    Then adet arttirilir ve adet 2 oldugu dogrulanir
    Then urun silinir ve sepetin bos oldugu kontrol edilir
