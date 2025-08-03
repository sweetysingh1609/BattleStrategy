# Battle Strategy Console App – Java OOP

This is a console-based Java application that simulates a medieval battle scenario. Your task is to rearrange your own 5 platoons to fight against 5 enemy platoons and win at least **3 out of 5** battles.

---

##  Problem Statement

You're a medieval king attacking 5 enemy locations. Each location has a **platoon of soldiers**, and each platoon belongs to one of six predefined **unit classes**.

Each of your platoons must be assigned to attack exactly one enemy platoon. You win a battle if your platoon overpowers the opponent.

### Win Rules:

- If both platoons are of equal size and class, it's a **draw**.
- If your platoon has **more soldiers**, you **win**.
- If your platoon has **class advantage**, each of your soldiers counts as **2 soldiers**.

---

## Unit Class Advantage Table

| Class           | Has Advantage Over                          |
|-----------------|---------------------------------------------|
| Militia         | Spearmen, LightCavalry                      |
| Spearmen        | LightCavalry, HeavyCavalry                  |
| LightCavalry    | FootArcher, CavalryArcher                   |
| HeavyCavalry    | Militia, FootArcher, LightCavalry          |
| CavalryArcher   | Spearmen, HeavyCavalry                      |
| FootArcher      | Militia, CavalryArcher                      |

---

##  Objective

Find an arrangement of your 5 platoons that gives you at least **3 wins** out of 5 battles.

If no such arrangement is possible, the program should print:

There is no chance of winning


---

##  Features

- Fully **object-oriented** design
- Uses **`Platoon` class** to model domain elements
- **Battle logic** and **input parsing** separated for clean code
- Uses **class advantages** to compute 2x strength logic
- Tries all **120 permutations** of your platoons to find one valid winning arrangement
- Provides a **clean console interface**
- Includes a **self-contained test file**

---

##  Object-Oriented Concepts Used

| Concept         | How it's used |
|-----------------|---------------|
| **Class**       | `Platoon` class models each army unit |
| **Encapsulation** | Each platoon’s data (unitClass, soldier count) is wrapped in `Platoon` |
| **Abstraction** | Logic for advantage, permutation, and battle result is cleanly abstracted |
| **Reusability** | Utility methods like `hasAdvantage` and `getBattleResult` are reused |
| **Single Responsibility** | Each function performs a focused task: parsing, comparing, permuting |
| **Testability** | A separate `BattleStrategyTest` file validates core methods |

---

##  How to Run the App

### Compile and Run

```bash
javac BattleStrategy.java
java BattleStrategy

Input Format (from console)
Two lines:

First line: your platoons

Second line: enemy platoons

Each platoon format: Class#SoldierCount, separated by semicolons.


## How to Run the Test File
javac BattleStrategyTest.java
java BattleStrategyTest

## Project Structure
BattleStrategy.java         // Main program with OOP logic and console interaction
BattleStrategyTest.java     // Test file to validate battle logic
README.md                   // This documentation
