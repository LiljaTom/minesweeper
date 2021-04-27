# Ohjelmistotekniikka, kevät 2021

Sovellus on versio perinteisestä miinaharava pelistä. 

## Dokumentaatio 

[Vaatimusmäärittely](/documentation/maarittelydokumentti.md)

[Arkkitehtuuri](/documentation/arkkitehtuuri.md)

[Tuntikirjanpito](/documentation/tuntikirjanpito.md)

## Releaset

[Viikko 5](https://github.com/LiljaTom/minesweeper/releases)

## Komentorivitoiminnot

### Sovelluksen koodin suorittaminen

```
mvn compile exec:java -Dexec.mainClass=minesweeper.Main
```

### Testaus

Testit voidaan suorittaa komennolla

```
mvn test
```

Testikattavuusraportti voidaan luoda komennolla

```
mvn jacoco:report
```

Checkstyle voidaan suorittaa komennolla

```
mvn jxr:jxr checkstyle:checkstyle
```
Sovelluksesta voidaan luoda jar-tiedoston komennolla 

```
mvn package
```
Komento generoi target hakemistoon tiedoston Minesweeper-1.0-SNAPSHOT.jar

Jar-tiedosto voidaan suorittaa komennolla 
```
java -jar Minesweeper-1.0-SNAPSHOT.jar
```