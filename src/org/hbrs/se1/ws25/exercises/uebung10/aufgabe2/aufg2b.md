# Simple Test Suite

**Test Object:** `CheckPerson.checkSolvency(Person person)`  
**Parameter:** `age` (Attribut von `Person`)  
**Output:** `int` (Solvenz-Stufe) oder Exception

---

## Test Cases

| TestCase No. | Category (pos; neg) | Input: age | Expected Output |
|--------------|--------------------|------------|-----------------|
| 1 | neg | -1 | ArithmeticException ("Illegal Value!") |
| 2 | neg | 0 | ArithmeticException ("Illegal Value!") |
| 3 | pos | 1 | 0 |
| 4 | pos | 18 | 1 |
| 5 | pos | 65 | 2 |

---

## Zugehörige Äquivalenzklassen

| Parameter | Äquivalenzklasse | Repräsentant | Category (pos; neg) |
|-----------|------------------|--------------|--------------------|
| age | EK1: age ≤ 0 (ungültig) | -1 | neg |
| age | EK2: 1 ≤ age < 18 → Rückgabe 0 | 1 | pos |
| age | EK3: 18 ≤ age < 65 → Rückgabe 1 | 18 | pos |
| age | EK4: age ≥ 65 → Rückgabe 2 | 65 | pos |

---

## Separate Grenzwerte

| Eingabewert (age) | Beschreibung |
|-------------------|--------------|
| 0 | Grenze zum ungültigen Bereich (age ≤ 0 → Exception) |
| 1 | kleinster gültiger Wert |
| 17 | oberer Rand von Rückgabe 0 |
| 18 | unterer Rand von Rückgabe 1 |
| 64 | oberer Rand von Rückgabe 1 |
| 65 | unterer Rand von Rückgabe 2 |
