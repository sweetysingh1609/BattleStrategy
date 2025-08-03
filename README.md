#  Battle Strategy Console App – Java OOP

A console-based Java application to simulate a medieval battle where you must arrange your platoons in a way that guarantees **winning at least 3 out of 5** battles against your opponent.

---

##  Problem Statement

You are a medieval king attacking 5 enemy locations. Each location has a platoon of a specific **class** and **soldier count**.

Each of your platoons must be arranged to fight one enemy platoon.

- One soldier beats one enemy soldier in 1:1 match.
- But **class advantage** doubles effective power.

###  Class Advantage Table:

| Class           | Has Advantage Over                          |
|-----------------|---------------------------------------------|
| Militia         | Spearmen, LightCavalry                      |
| Spearmen        | LightCavalry, HeavyCavalry                  |
| LightCavalry    | FootArcher, CavalryArcher                   |
| HeavyCavalry    | Militia, FootArcher, LightCavalry          |
| CavalryArcher   | Spearmen, HeavyCavalry                      |
| FootArcher      | Militia, CavalryArcher                      |

---

## Objective

Rearrange your 5 platoons to maximize wins using **OOPS and clean logic**. Print one such valid winning arrangement.

---

##  Features

- Class-based design (`Platoon`)
- Map-based advantage system
- Full permutation search (only 120 total)
- Clean console interaction
- Follows object-oriented best practices

---

##  How to Run

```bash
javac BattleStrategy.java
java BattleStrategy
