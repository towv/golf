**Aihe:** Golffauspeli. 

**Kuvaus:** Frisbee lentää koriin.
Kiekolla on ominaisuuksia. Pelaajalla on kiekkoja. Kiekko heitetään koriin antamalla heiton voimakkuus ja suunta. Korin sijainti riippuu radasta.

Aluksi kiekko heitetään koriin, mahdollisimman vähillä heitoilla. Jotta kiekko menisi koriin on sen osuttava riittävän lähelle korin keskustaa, ilman liian suurta jäljelle jäävää voimaa. Kiekkoa, väylää, sekä rataa voi kaikkia vaihtaa. Tuloskortista näkee miten meni.

Pelataan näppäimistöllä. Hiirtä käytetään valikoissa siirtymiseen.

***Tulevat laajennukset***
Toteutuksessa on pyritty hyvään laajennettavuuteen.
Aluksi yksinpeli, myöhemmin ehkä moninpeli.
Radalle tulee esteitä. Näitten kannalta on erittäin tärkeää, että Pelaajalla on Sijainti. 
Mukaan tulee mahdollisesti myös olosuhteet(tuuli).
Pelaajalle annetaan mahdollisuus valikoida kiekkojensa statsit.


**Käyttäjä:** Pelaaja, (pelaajat)

**Kaikkien käyttäjien toiminnot:** Pelaajatunnuksen luominen, frisbeen heittäminen

**Kaaviot:** 

![Luokkakaavio](Kaaviot/luokkakaavio.png)
![Sekvenssikaavio: Nappaimistonkuuntelija](Kaaviot/Sekvenssikaaviot/heitto_yksi_suunta.png)
![Sekvenssikaavio: Kiekkopeli actionevent](Kaaviot/Sekvenssikaaviot/Kiekkopeli_Actionevent_Voima1.png)
![Sekvenssikaavio: Kiekkopeli osuu koriin liialla voimalla](Kaaviot/Sekvenssikaaviot/osuuKoriinLiikaaVoimaa.png)

**Rakennekuvaus:**
Kiekkopeli on pääpeliluokka. Se luodaan mainissa ensin ja sitten annetaan pääkäyttöliittymäluokalle Kayttoliittyma parametrina tätä luodessa.

Yhteydet muihin ui luokkiin kulkevat Kayttoliittyman ja sitä kautta Kiekkopeli luokan kautta, josta saadaan haettua tarvittavat muut luokat, eri asioiden ruudulle päivittämistä varten.

Tapahtumankuuntelijat kuuntelevat mitä käyttäjä tekee ja pyytävät logiikkaluokkia toimimaan tämän mukaisesti. Nappaimistonkuuntelija on itse pelaamisesta(heittämisestä) vastuullinen tapahtumankuuntelija. Kiekonvaihtonapinkuuntelija kuuntelee milloin käyttäjä haluaa vaihtaa kiekkoa, ja ilmoittaa tästä logiikalle. Vaylanvaihtonapinkuuntelija tekee saman väylien vaihdon suhteen. Muut kuuntelijat liittyvät valikossa liikkumiseen.

Pelin valikossa on neljä ikkunaa, ja näihin liittyy nappeja tai JPaneleita, jotka näyttävät halutut asiat käyttäjälle.

Logiikkaan kuuluu useita luokkia, jotka avustavat pääpeliluokkaa eli Kiekkopeliä. Näitä ovat mm. Pelaaja, jolla on Kiekkoja ja Heitto, sekä Rata, johon kuuluu Vaylia.
