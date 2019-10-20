# Vigenere-Cipher-JAVA-Decoder
### 1. Specyfikacja założeń:
*	alfabet wejściowy i wyjściowy: wielkie i małe litery alfabetu polskiego,
cyfry, spacja, podstawowe znaki interpunkcyjne;
*	dane wejściowe i wyjściowe (wyprowadzane na ekranie do pliku lub zapisywane do pliku na życzenie użytkownika przy jednoczesnej wizualizacji na ekranie)\
DANE WEJŚCIOWE\
Dane można wprowadzić poprzez wpisanie ich w polach aplikacji – kolejno do pola hasło, oraz znajdującego się poniżej pola tekstu.
Drugim sposobem wprowadzania danych jest ich wczytanie z pliku. Odbywa się to poprzez wciśnięcie przycisku wczytaj. Plik można wybrać spośród tych znajdujących się na dysku/dyskach komputera.\
DANE WYJŚCIOWE\
Dane są wyświetlane w określonych zakładkach aplikacji w zależności czy mają one być szyfrowane, czy odszyfrowane.
Można je także zapisać do pliku. Zapisywany jest tekst szyfrowany bądź deszyfrowany.
*	rozmiar danych\
Nie ma ograniczenia co do ilości wprowadzanych danych.
*	format danych\
Dane mogą być wprowadzane
*	format danych\
Wczytywany plik musi być plikiem tekstowym. W pierwszej linii podane jest hasło, następnie tekst który chcemy zaszyfrować.
Aby wprowadzić hasło do aplikacji trzeba je zatwierdzić wciskając przycisk OK. 
*	ewentualne ograniczenia\
Zapisany plik będzie miał nazwę „wynik.txt”, wyniki są w nim nadpisywane. Ostatni wywołany znajduje się w pliku. Dane nie zostaną zapisane, jeżeli brakuje hasła lub tekstu wprowadzanego do szyfrowania lub deszyfrowania.
*	środowisko programistyczne i wykonawcze\
Program napisany jest w języku JAVA. Aby go uruchomić należy wybrać plik o rozszerzeniu .jar oraz posiadać zainstalowany JDK.
### 3. Interfejs graficzny – przyjazny dla użytkownika
*	nazwa: SZYFROMACHINA
*	autor: Alicja Gratkowska
*	opis: prosta aplikacja graficzna napisana w języku Java przeznaczona do szyfrowania lub deszyfrowania tekstu zgodnie z szyfrem Vigenere.
*	Aplikacja napisana jest w języku Java. Plik wykonywalny jest plikiem jar, do którego niezbędne jest zainstalowanie JDK.
*	Algorytm:

*	Podpowiedzi:\
Pamiętaj, żeby po wprowadzenie hasła zatwierdzić je klikając przycisk OK:
### 4. Implementacja
Do implementacji zostały wykorzystane obydwie metody przeznaczone dla szyfru Vigenere. Szyfrowanie odbywa się przy użyciu tablicy dwuwymiarowej, natomiast deszyfrowanie przy użyciu wzoru.

