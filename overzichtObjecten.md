# Overzicht van objecten in verschillende scenario's
Een pijl tussen objecten kan gelezen worden als: een object kent het object waar de pijl naar wijst.

De emoji van een persoon verwijst naar het punt waarmee een agent buiten het domein met het domein interacteert.
## Eén Speler en één Set op Tafel

```mermaid
flowchart LR

AGENT("🧍")
SPELER("Speler")
PLANKJE("Plankje")
TAFEL("Tafel")
POT("Pot")
SET1("Set")

AGENT-->SPELER
SPELER-->PLANKJE
SPELER-->POT
PLANKJE-->TAFEL
TAFEL-->SET1

```

## Drie Spelers en drie Sets op Tafel

```mermaid
flowchart LR

AGENT("🧍")
SPELER1("Speler")
SPELER2("Speler")
SPELER3("Speler")
PLANKJE1("Plankje")
PLANKJE2("Plankje")
PLANKJE3("Plankje")
TAFEL("Tafel")
POT("Pot")
SET1("Set")
SET2("Set")
SET3("Set")

AGENT-->SPELER1
SPELER1-->SPELER2
SPELER2-->SPELER3
SPELER3-->SPELER1
SPELER1-->PLANKJE1
SPELER2-->PLANKJE2
SPELER3-->PLANKJE3
SPELER1-->POT
SPELER2-->POT
SPELER3-->POT
PLANKJE1-->TAFEL
PLANKJE2-->TAFEL
PLANKJE3-->TAFEL
TAFEL-->SET1
TAFEL-->SET2
TAFEL-->SET3

```
