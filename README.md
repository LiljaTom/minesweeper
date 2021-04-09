# Ohjelmistotekniikka, kevät 2021


## Dokumentaatio 

[Vaatimusmäärittely](/documentation/maarittelydokumentti.md)

[Tuntikirjanpito](/documentation/tuntikirjanpito.md)

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
