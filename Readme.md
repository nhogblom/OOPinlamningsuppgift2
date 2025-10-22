

# 🏋️‍♂️ OOP Inlämningsuppgift 2

> **Kurs:** Objektorienterad programmering  
> **Språk:** Java  
> **Författare:** [Niklas Högblom](https://github.com/nhogblom)

Ett projekt som demonstrerar objektorienterade principer i praktiken genom att hantera medlemsinformation och träningshistorik för ett gym.

<p align="center">
  <img src="logo.png" alt="BestGymEver logo" width="600"/>
</p>

<p align="center"><i>Where every rep counts – and every member matters.</i></p>

---

## 🎯 Syfte  
Programmet läser in ett medlemsregister, avgör vilka medlemmar som är aktiva och loggar deras träningsbesök.

---

## 🗂️ Projektstruktur

```
├── src/bestGymEver/        # Programkod (entry point: BestGymEver.java)
├── Test/bestGymEver/       # Enhetstester (JUnit)
├── Resources/              # Indatafiler (t.ex. medlemsregister)
├── testResources/          # Testdata för tester
└── README.md
```

---

## ⚙️ Funktioner

✅ Läser medlemsinformation från `Resources/`  
✅ Kontrollerar medlemsstatus utifrån betalningsdatum  
✅ Loggar individuella träningsbesök till mappen `membersactivity`  
✅ Hanterar felaktig indata robust  
✅ Innehåller separata enhetstester i `Test/bestGymEver`

---

## 📄 Datafiler

| Fil / Mapp                 | Beskrivning                                                                 |
|----------------------------|-----------------------------------------------------------------------------|
| **`Resources/gym-medlemmar.txt`** | Medlemsregister med namn, personnummer, datum som personen blev medlem, datum för senaste betalningsdatum samt medlemsnivå. |
| **`membersactivity/personnummer.txt`**        | Loggfil där varje incheckning av aktiv medlem sparas.                     |
| **`testResources/`**         | Testdata som används vid enhetstester.                                    |

---

## 🚀 Körning

### 💻 Via IDE (rekommenderas)  
1. Öppna projektet i **IntelliJ**, **Eclipse** eller motsvarande.  
2. Kör filen **`BestGymEver.java`** under `src/bestGymEver/`.

### 🧰 Via terminal
```bash
javac -d bin src/bestGymEver/*.java
java -cp bin bestGymEver.BestGymEver
```

---

## 🧪 Testning  
Enhetstester finns i `Test/bestGymEver/` och använder testdata från `testResources/`.

---

## 🧱 Objektorienterade principer

| Princip            | Tillämpning                                                                 |
|---------------------|-----------------------------------------------------------------------------|
| **Inkapsling**       | Klassvariabler hålls privata med publika getters/setters.                  |
| **Arv & Polymorfism** | Utnyttjas mellan relaterade klasser där det är relevant.                   |
| **Modularisering**    | Logik, filhantering och användarinteraktion separeras tydligt.             |

---

## 🌱 Vidareutveckling  
- Grafiskt gränssnitt (GUI) för enklare användning  
- Databaslagring av medlemmar  
- Statistik och analys av träningsfrekvens  

---

## 📬 Kontakt  
**👤 Niklas Högblom**  
📧 [nhogblom@gmail.com](mailto:nhogblom@gmail.com)  
🔗 [GitHub‑profil](https://github.com/nhogblom)

---
