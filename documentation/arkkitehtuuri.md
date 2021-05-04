# Arkkitehtuurikuvaus


## Käyttöliittymä

Käyttöliittymä sisältää tällä hetkellä (release 2) vain näkymän pelistä.

Käyttöliittymän rakentaa MinesweeperUi-luokka, mikä hyödyntää GameBoard ja GameNode luokkia. MinesweeperUi luo GameService-olion, minkä se antaa GameBoard-oliolle. GameBoard rakentaa Pane olion, mille se luo GameService olion perusteella GameNode olioita. GameNode-luokan vastuulla on kuvata pelilaudan ruutuja, mihin se käyttää pääasiassa StackPane oliota.

## Sovelluslogiikka

Sovelluslogiikassa päävastuu on GameService-luokalla. GameService luo DifficultyLevel olion sille parametrina annetun tiedon perusteella, ja DifficultyLevel kertoo GameServicelle, että millä parametreilla sen pitää kutsua/luoda pelipöydästä vastaava Board olio.

Board-luokan päätehtävä on lähinnä vain koota Grid-luokan toiminta. Kyseinen Grid-luokka sisältää peliruudukon tärkeimmät toiminnallisuudet. Grid vuorostaan sisältää Node-luokan ilmentymiä, mitkä toimivat sovelluksen pienimpinä palasina.



### ALustava kuvaus sovelluksen rakenteesta

![](https://github.com/LiljaTom/minesweeper/blob/main/documentation/photos/sovellusrakenne.png)

### Pelin luominen

![](https://github.com/LiljaTom/minesweeper/blob/main/documentation/photos/PelinLuominen.png)


