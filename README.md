Dato-tolk
=========

Dato-tolk er et bibliotek som gjør om norsk tekst til dato-objekter.

F.eks. `i dag`, `på mandag`, `2. tirsdag i august`, ...


Utvikling – Kom i gang
----------------------

### Last ned koden

    $ git clone https://github.com/netcompanyno/fag-sprak-dato-poc.git

### Åpne i IntelliJ

Åpne `build.gradle` i rot-mappa og velg `Open as Project`.

IntelliJ bør begynne å indeksere og konfigurere Gradle og bygge og holde på en 
god stund.

### Konfigurer Gradle

For å få Gradle/IntelliJ til å forstå seg på de genererte filene fra Antlr, må vi endre litt på standard innstillinger.

#### Settings > Build, Execution, Deployment > Build Tools > Gradle

* *Use Auto-import*: **Ja**
* *Create directories for empty content roots automatically*: **Ja**
* *Group modules*: **using explicit module groups**
* *Create separate module per source set*: **Nei**
* *Store generated project files externally*: **Ja**

### Kjør tester

Finn klassen [`KjørCucumberTester`](src/test/kotlin/no/netcompany/datotolk/cucumber/KjørCucumberTester.kt), 
høyreklikk den og velg _Run_.

### Skriv en test

Finn testene i [src/test/resources/features](src/test/resources/features). 
Rediger en eksisterende fil eller lag en ny. Når du kjører Cucumber-testene på 
nytt bør noe feile.

### Få testen til å kjøre

Først når du har en test som feiler, skal du skrive noe kode. Inngangsporten er 
klassen [DatoTolk](src/main/kotlin/no/netcompany/datotolk/DatoTolk.kt). Skriv kode 
helt til testene kjører grønt igjen, og skriv en ny test som feiler, helt til du 
er førnøyd.
