Mitä en testannut automaattisesti:

UI testaus ei ollut välttämätöntä. Siksi monet testit jäävät aika absraktille tasolle ja kuuntelijoiden ja piirtäjien toimivuus on testattu runsaasti pelaamalla. Näitä on testattu käsin kokeilemalla etsiä virheitä ja painelemalla nappeja ristiin rastiin ja välilehtiä vaihdellen ja mitään virheitä ei ole havaittu.

Pitin mutantit liittyvät oikeastaan ainoastaan Kiekkopeli-luokan ActionPerformed-metodiin ja niitä olisi varmaankin ollut hankala saada kaikkia hengiltä. Otin lähtökohdaksi, että pidän kaikki peliin liittyvät palikat kunnossa ja testattuina, sillä ne eivät muutu olennaisesti. Tiesin projektin aikana, että actionevent, siis niiden käyttö, tulee muuttumaan ja jätin siksi noita mutantteja tappamatta. ActionPerformed pystyy myös näkemään ruudulta ja sitä testattiinkin tätä kautta. Koska testejä tehtiin kokoajan ja rakenne muuttui välillä hieman, ei kaikkia testejä ehditty päivittää. Mutantteja jäi siis muutama muiltakin osin ajanpuutteen takia. Muuten testikattavuus on hyvällä tasolla, kokonaisuudessaan (rivit 93% mutantit 82%), käytännössä siis kaikki muut luokat ~100%.

Radat oliota luotaessa tarkistetaan, ettei parametreina annettavat leveys ja korkeus ole <=0 ja jos näin on tästä heitetään poikkeus("Sekä leveyden, että korkeuden on oltava suurempi kuin nolla!"). Tätä en sitten keksinyt enää kattaa pittiin.

Kuuntelijat (Listener) ja GUI on jätetty testaamatta automaattisesti, ja ActionEvent siis pääasiassa testaamatta. Jos aikaa olisi rajattomasti, voisi nekin testata, mutta loppujen lopuksi integraation kannalta niiden yksikkötestaamisesta ei ole mitään hyötyä, ne toimivat ja sillä sipuli.

Bugit:


-Visuaalinen "bugi", kun peliä pelaa painuu 'peli' -välilehden nappi 'space' -näppäintä painaessa. Kertoopahan, että olet oikealla välilehdellä. Tähän liittyy nimittäin se, että peli-välilehti tulee olla valittuna, jotta voi pelata. Kuuluu siis asiaan, olisi helpostikin muutettavissa, eikä häiritse minua.

-Visuaalinen "bugi", kiekon osuessa koriin liian lujaa(voima>3) jatkaa se liikettä vielä yhden liikkeen verran. Tämä aiheutui aluksi vahingossa ja päätin tehdä siitä ominaisuuden, kun olin jo etukäteen suunnitellut, että pelaajalle tulee "lisäheitto" niin kaipa kiekonkin sietää liikkua. Se kuitenkin voi joskus liikkua korin ulkopuolelle sen sijaan, että liikkuisi vain eteenpäin korin sisällä, osumakohdasta ja liikkumissuunnasta riippuen.
