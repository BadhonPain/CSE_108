<div align="center">

# 🎓 CSE 108 — Object Oriented Programming Sessional

### Bangladesh University of Engineering and Technology (BUET)

[![Language: C++](https://img.shields.io/badge/Language-C++-00599C?style=for-the-badge&logo=cplusplus&logoColor=white)](https://isocpp.org/)
[![Language: Java](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)

*A comprehensive collection of assignments, online assessments, and practice problems covering core Object-Oriented Programming concepts in C++ and Java.*

---

</div>

## 📑 Table of Contents

- [About](#-about)
- [Topics Covered](#-topics-covered)
- [Repository Structure](#-repository-structure)
- [Offline Assignments](#-offline-assignments)
- [Online Assessments](#-online-assessments)
- [Practice Problems](#-practice-problems)
- [Related Repositories](#-related-repositories)
- [Tech Stack](#-tech-stack)
- [How to Run](#-how-to-run)
- [Author](#-author)

---

## 📖 About

This repository contains all coursework for the **CSE 108: Object Oriented Programming** course. The course transitions from foundational C++ OOP concepts (classes, memory management, operator overloading) to advanced Java topics (inheritance hierarchies, interfaces, exception handling, multithreading, collections, and generics).

Each assignment is self-contained with its respective problem statement and solution.

---

## 🧠 Topics Covered

| # | Topic | Language | Assessment |
|:-:|-------|:--------:|:----------:|
| 1 | Classes, Encapsulation, Dynamic Memory | C++ | Offline 1, Online 1 |
| 2 | Constructors, Copy Constructors, Destructors | C++ | Offline 2, Online 2, Online 3 |
| 3 | Operator Overloading | C++ | Offline 2, Online 3 |
| 4 | Inheritance & Polymorphism | C++ | Practice |
| 5 | Function Overriding & Virtual Functions | C++ | Practice |
| 6 | Classes, Encapsulation, Arrays of Objects | Java | Online 4 |
| 7 | Abstract Classes & Inheritance | Java | Offline 3, Online 5 |
| 8 | Interfaces & Custom Exceptions | Java | Offline 3, Online 5 |
| 9 | Multithreading (`Thread`, `join`) | Java | Online 6 |
| 10 | Collections, Generics, File I/O | Java | Practice |

---

## 📂 Repository Structure

```
CSE_108/
├── 📁 Offline/                     # Lab assignments
│   ├── 📁 Offline_1/               # C++ — Classes & Dynamic 2D Matrix
│   ├── 📁 Offline_2/               # C++ — Political Party Management System
│   └── 📁 Offline_3/               # Java — Vehicle Workshop (Inheritance + Interface)
│
├── 📁 Online/                      # Timed in-class assessments
│   ├── 📁 Online_01/               # C++ — FileHandler Class & File I/O
│   ├── 📁 Online_02/               # C++ — Playlist (Song + Album Management)
│   ├── 📁 Online_03/               # C++ — ShiftArray (Operator Overloading)
│   ├── 📁 Online_04/               # Java — Gym Membership Fee Calculator
│   ├── 📁 Online_05/               # Java — Delivery Service (Abstract + Exception)
│   └── 📁 Online_06/               # Java — Multi-threaded Prime Sum
│
├── 📁 Practice/                    # Self-practice problems
│   ├── 📁 CPP/                     # Inheritance, Overriding, Operator Overloading
│   └── 📁 Java/                    # Banking System, Movie Collections & Generics
│
├── .gitignore
└── README.md
```

---

## 📝 Offline Assignments

### Offline 1 — Figure Matrix *(C++)*
> **Concepts:** Classes, Encapsulation, Dynamic Memory Allocation, 2D Arrays

Implementation of a `Figure` class that manages dynamically allocated 2D integer matrices. Handles matrix creation, naming based on dimensions, and memory management using constructors and destructors.

<details>
<summary>📄 View Files</summary>

| File | Description |
|------|-------------|
| `Ass1_2405087_Dec25.cpp.cpp` | Complete solution with `Figure` class |
| `Question.docx` | Problem specification |

</details>

---

### Offline 2 — Political Party Management System *(C++)*
> **Concepts:** Composition, Copy Constructor, Deep Copy, Dynamic Arrays, Friend Functions

A system to manage political parties and their members. Features include adding/removing members, nominating candidates, and displaying party details with proper deep-copy semantics.

<details>
<summary>📄 View Files</summary>

| File | Description |
|------|-------------|
| `2405087.cpp` | Solution — `PartyMember` & `Party` classes |
| `CSE108_Offline 2_Specifications.pdf` | Problem specification |

</details>

---

### Offline 3 — Vehicle Workshop Manager *(Java)*
> **Concepts:** Abstract Classes, Inheritance, Interfaces, Custom Exceptions, Polymorphism

A vehicle service workshop simulation featuring an abstract `Vehicle` class extended by `Car`, `Bike`, and `Truck`. Implements a `Serviceable` interface and uses a custom `ServiceException` for validation. The `WorkshopManager` demonstrates polymorphic service cost calculations.

<details>
<summary>📄 View Files</summary>

| File | Description |
|------|-------------|
| `Vehicle.java` | Abstract base class with service cost logic |
| `Car.java` / `Bike.java` / `Truck.java` | Concrete vehicle implementations |
| `Serviceable.java` | Service interface |
| `ServiceException.java` | Custom checked exception |
| `WorkshopManager.java` | Manager class with polymorphic operations |
| `Main.java` | Driver program |

</details>

---

## 💻 Online Assessments

### Online 01 — FileHandler Class *(C++)*
> **Concepts:** File I/O (`ofstream`), Resource Management, Encapsulation

Implements a `FileHandler` class that wraps file operations, ensuring files are opened and closed only once during the object's lifetime.

---

### Online 02 — Playlist Management *(C++)*
> **Concepts:** Composition, Dynamic Arrays, Class Relationships

A music playlist system with `Song` and `Album` classes supporting song management, display, and album operations.

---

### Online 03 — ShiftArray *(C++)*
> **Concepts:** Operator Overloading (`+`, `-`, `++`, `--`, `<<`), Deep Copy, Destructor

Custom array class with circular shift operations via overloaded operators. Demonstrates proper memory management and deep-copy semantics.

---

### Online 04 — Gym Membership Fee Calculator *(Java)*
> **Concepts:** Classes, Arrays, Encapsulation, Object Composition

Calculates late fees for gym members across multiple plans using `GymMember` and `Plan` classes with fee computation logic.

---

### Online 05 — Delivery Service System *(Java)*
> **Concepts:** Abstract Classes, Inheritance, Custom Exceptions, Input Validation

A delivery service with an abstract `DeliveryRequest` base class, extended by `FoodDelivery` and `ParcelDelivery`. Uses `InvalidRequestException` for robust input validation.

---

### Online 06 — Multi-threaded Prime Sum *(Java)*
> **Concepts:** Multithreading, `Thread` class, `join()`, Range Partitioning

Computes the sum of all prime numbers in a given range using multiple threads. Divides the work into chunks and aggregates partial sums via `Thread.join()`.

---

## 🧪 Practice Problems

### C++ Practice
| Problem | Topics |
|---------|--------|
| `PP_week_04.cpp` | Inheritance, Polymorphism, Virtual Functions |
| `Inheritence_practice.cpp` | Class Hierarchies, Method Overriding |
| `function_overridding.cpp.cpp` | Virtual Functions, Runtime Polymorphism |
| `operator_overloading_practice.cpp` | Operator Overloading |

### Java Practice

| Problem | Topics |
|---------|--------|
| **Banking System** (`Java Practice 1/`) | Classes, `Account` & `Branch` management |
| **Movie Collection** (`Java_Practice_Collections_Generics/`) | `ArrayList`, `HashMap`, Generics, File Parsing, Comparable |

---

## 🔗 Related Repositories

Explore other academic repositories containing coursework, implementations, and study materials:

| Repository | Description | Language / Tech |
| :--- | :--- | :--- |
| [🌌 OOPverse](https://github.com/BadhonPain/OOPverse) | A comprehensive repository dedicated to Object-Oriented Programming design patterns, principles, and practice problems. | Java / C++ |
| [🧬 DSA Genesis](https://github.com/BadhonPain/DSA_Genesis) | C++17 implementations of core Data Structures & Algorithms at BUET CSE (CSE-105 & CSE-207), covering trees, graphs, sorting, and dynamic programming. | C++17 |
| [🧪 CSE 106](https://github.com/BadhonPain/CSE_106) | Laboratory coursework, programming assignments, and exam solutions for Data Structures & Algorithms I Sessional at BUET. | C / C++ |

---

## 🛠 Tech Stack

| Tool | Purpose |
|------|---------|
| **C++** (g++) | OOP fundamentals — memory management, operator overloading |
| **Java** (JDK 17+) | Advanced OOP — inheritance, interfaces, threading, collections |
| **Git** | Version control |
| **VS-Code, IntelliJ** | Writing & Editing Code |

---

## 🚀 How to Run

### C++ Programs
```bash
# Compile
g++ -o output filename.cpp

# Run
./output
```

### Java Programs
```bash
# Compile
javac FileName.java

# Run
java FileName
```

> **Note:** Some Java files use package declarations (e.g., `package Online.Online_04;`). To run these, compile and execute from the project root:
> ```bash
> javac Online/Online_04/*.java
> java Online.Online_04.Main
> ```

---

## 👤 Author

**Badhon Pain**
- 🎓 Student ID: `2405087`
- 🏛 Bangladesh University of Engineering and Technology (BUET)
- 🔗 GitHub: [@BadhonPain](https://github.com/BadhonPain)

---

<div align="center">

>*Maintained as part of coursework at BUET.*

</div>
