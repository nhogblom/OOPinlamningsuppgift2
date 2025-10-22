OOP Inlämningsuppgift 2

Detta projekt är en inlämningsuppgift i kursen Objektorienterad programmering och syftar till att demonstrera praktisk tillämpning av OOP-principer i Java.

Syfte

Applikationen hanterar medlemsinformation för ett gym och loggar träningshistorik för aktiva medlemmar.

Projektstruktur
├── src/bestGymEver/        # Programkod (entry point: BestGymEver.java)
├── Test/bestGymEver/       # Enhetstester
├── Resources/              # Indatafiler (t.ex. medlemsregister)
├── testResources/          # Testdata
└── README.md

Funktioner

Läser in medlemsinformation från Resources/

Avgör om medlemmen är aktiv baserat på betalningsdatum

Loggar besök för aktiva medlemmar till filen membersactivity

Hanterar felaktig indata och saknade poster robust

Separata tester i Test/bestGymEver

Datafiler

Resources/customers.txt
Innehåller medlemsregister:

Förnamn Efternamn, Personnummer
ÅÅÅÅ-MM-DD


Datum anger senaste betalningsdatum.

membersactivity
Loggfil där träningsbesök sparas för aktiva medlemmar.

Körning

Via IDE (rekommenderat):

Öppna projektet i IntelliJ, Eclipse eller liknande.

Kör BestGymEver.java i src/bestGymEver.

Via terminal:

javac -d bin src/bestGymEver/*.java
java -cp bin bestGymEver.BestGymEver

Testning

Tester finns i Test/bestGymEver och använder resurser från testResources/.
De körs enklast via IDE med JUnit 5.

OOP-principer

Inkapsling: Klassvariabler hålls privata med publika getters/setters.

Arv & Polymorfism: Tillämpas där det är relevant mellan klasser.

Modularisering: Filhantering, logik och användarinteraktion separeras tydligt.

Vidareutveckling

GUI för användarvänlig inmatning

Databaslagring av medlemmar

Statistik över träningsfrekvens

Kontakt

Författare: Niklas Högblom

E-post: nhogblom@gmail.com