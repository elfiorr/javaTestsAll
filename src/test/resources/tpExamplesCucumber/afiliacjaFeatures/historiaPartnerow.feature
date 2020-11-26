Feature: Historia Partnerow

  Background:
    Given Jestem na stronie logowania do aplikacji
    Given Loguje sie do aplikacji totalpanel
    When Klikam w menu Afiliacja -> Historia Partnerow

  @TP_REGRESSION
  Scenario: Zaladowanie zakladki Historia Partnerow
    Then Widze przycisk Eksportuj CSV w Historii Partnerow
    Then Widze przycisk Wyswietl w Historii Partnerow
    Then Widze przycisk Wyczysc w Historii Partnerow
    Then Widze Tytul zakladki Historia Partnerow
    Then Widze input Data rejestracji od w Historia Partnerow
    Then Widze input Data rejestracji do w Historia Partnerow
    Then Widze selekt Okres w Historia Partnerow
    Then Widze input Partner w Historii Partnerow
    Then Widze input Wykonane przez w Historia Partnerow
    Then Widze input Akcja w Historia Partnerow

  @TP_REGRESSION
  Scenario: Zaladowanie zakladki Historia partnerow i weryfikacja istnienia kolumn
    Then Widze kolumne Nazwa partnera
    Then Widze kolumne Akcja
    Then Widze kolumne Wykonane przez
    Then Widze kolumne Data akcji
    Then Widze kolumne Adres IP
    Then Widze kolumne Szczegoly
