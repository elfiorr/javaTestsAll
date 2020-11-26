Feature: Kartoteka partnerow

  Background:
    Given Jestem na stronie logowania do aplikacji
    Given Loguje sie do aplikacji totalpanel
    When Klikam w menu Afiliacja -> Kartoteka Partnerow

  @TP_REGRESSION
  Scenario: Zaladowanie zakladki Kartoteka partnerow
    Then Widze przycisk Wyswietl w Kartotece Partnerow
    Then Widze przycisk Wyczysc w Kartotece Partnerow
    Then Widze Tytul zakladki Kartoteka Partnerow
    Then Widze input Partner w Kartotece Partnerow
    Then Widze input Email
    Then Widze input Numer telefonu
    Then Widze input Pesel
    Then Widze input Nip
    Then Widze input Zrodlo
    Then Widze selekt Specjalizacja
    Then Widze input Data rejestracji od
    Then Widze input Data rejestracji do
    Then Widze selekt Okres
    Then Widze input Rejestracja z polecenia
    Then Widze multi-selekt Status w Kartotece Partnerow

  @TP_REGRESSION
  Scenario: Zaladowanie zakladki Kartoteka partnerow i weryfikacja istnienia kolumn
    Then Widze kolumne ID partnera
    Then Widze kolumne Partner
    Then Widze kolumne Login
    Then Widze kolumne Specjalizacja
    Then Widze kolumne Email
    Then Widze kolumne Telefon
    Then Widze kolumne Pesel
    Then Widze kolumne NIP
    Then Widze kolumne Nr rejestracyjny
    Then Widze kolumne Data rejestracji
    Then Widze kolumne Aktywny
    Then Widze kolumne Autologowanie

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po ID
    When Z pola Partner w Kartotece Partnerow wybieram partnera o id "partnerId"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie tylko jeden rekord
    Then Wyswietlony rekord zawiera id o wartosci "partnerId"

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po nazwie
    When Z pola Partner w Kartotece Partnerow wybieram partnera o nazwie "partnerName"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie tylko jeden rekord
    Then Wyswietlony rekord zawiera nazwe o wartosci "partnerName"

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po emailu
    When Pole Email w Kartotece Partnerow uzupelniam wartoscia "email"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie tylko jeden rekord
    Then Wyswietlony rekord zawiera email o wartosci "email"

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po telefonie
    When Pole Telefon w Kartotece Partnerow uzupelniam wartoscia "telefonValue"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie co najmniej jeden rekord
    Then Wyswietlony rekord zawiera telefon o wartosci "telefonValue"

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po nipie
    When Pole Nip w Kartotece Partnerow uzupelniam wartoscia "nipValue"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie co najmniej jeden rekord
    Then Wyswietlony rekord zawiera nip o wartosci "nipValue"

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po zrodle
    When Pole Zrodlo w Kartotece Partnerow uzupelniam wartoscia "sourceValue"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie tylko jeden rekord
    Then Wyswietlony rekord zawiera id o wartosci "partnerId"

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po id zrodla
    When Pole Zrodlo w Kartotece Partnerow uzupelniam wartoscia id "sourceId"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie tylko jeden rekord
    Then Wyswietlony rekord zawiera id o wartosci "partnerId"

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po peselu
    When Pole Pesel w Kartotece Partnerow uzupelniam wartoscia "peselValue"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie tylko jeden rekord
    Then Wyswietlony rekord zawiera pesel o wartosci "peselValue"

  @TP_REGRESSION
  @TP_REGRESSION_STAGE
  Scenario: Wyszukiwanie partnera po numerze rejestracyjnym
    When Pole Numer rejestracyjny w Kartotece Partnerow uzupelniam wartoscia "numerRejestracyjnyValue"
    When Zatwierdzam przyciskiem Wyswietl w Kartotece Partnerow
    Then Wyswietlil sie co najmniej jeden rekord
    Then Wyswietlony rekord zawiera numer rejestracyjny o wartosci "numerRejestracyjnyValue"

  @TP_REGRESSION
  Scenario: Wybranie partnera i sprawdzenie istnienia pol na partnerze
    When Wybieram pierwszego partnera z listy
    Then Widze zakladke Dane podstawowe w Kartotece partnerow
    Then Widze zakladke Dane Kontaktowe w Kartotece partnerow
    Then Widze zakladke MLM w Kartotece partnerow
    Then Widze zakladke Historia w Kartotece partnerow
    Then Widze zakladke Grupy dostepnosci w Kartotece partnerow
    Then Widze zakladke Mapa dostepnosci kampanii w Kartotece partnerow
    Then Widze zakladke Indywidualne dostepnosci w Kartotece partnerow
