# Continued Fraction Arithmetic with Gosper Algorithm

> A project by **Mert Esen** & **Kevser Yolcu**  
> **Project Title:** Continued Fraction Arithmetic Implementation with Gosper Algorithm  
> **Year:** 2019  
> **Repository:** [GitHub Link](https://github.com/kevseryolcu/ContinuedFractionArithmetic)

## 📌 Abstract

Continued fractions (CF) offer a unique representation for real numbers, providing alternatives to decimal or binary representations. This project explores continued fraction arithmetic using the **Gosper Algorithm**, which enables exact arithmetic operations on continued fractions by computing the most significant digits first.

## 📚 Table of Contents

- [Abstract](#-abstract)
- [Continued Fractions](#-continued-fractions)
- [Gosper Algorithm](#-gosper-algorithm)
- [Implementation](#-implementation)
- [References](#-references)

## 🔢 Continued Fractions

A continued fraction is an expression like:

```
415 / 93 ≈ 4 + 1/(2 + 1/(6 + 1/7)) → [4, 2, 6, 7]
```

This approach provides better approximation at each step and eventually the exact value for rational numbers.

## ⚙️ Gosper Algorithm

The **Gosper Algorithm** allows performing arithmetic directly on continued fractions — even infinite ones — unlike standard decimal methods.

### Matrix Form Representation

Each operation is represented with an initial matrix of coefficients `(a b c d; e f g h)`:

- **Addition:** `(0 1 1 0; 1 0 0 0)`
- **Subtraction:** `(0 1 -1 0; 1 0 0 0)`
- **Multiplication:** `(0 1 0 0; 0 0 1 0)`
- **Division:** `(0 0 0 1; 1 0 0 0)`

### Algorithm Overview

Let:
```
X = [x0, x1, x2, ...]
Y = [y0, y1, y2, ...]
Z = [z0, z1, z2, ...]  # Result
```

The steps of the algorithm involve:
1. **Output Rule:** If a/c = b/d = e/f = g/h = zk, update matrix for next term.
2. **Stop Condition:** If any matrix division results in ∞ or undefined (0/0), halt.
3. **Input Rule X:** If |b/a - f/e| > |c/a - g/e|, use `xk` to update matrix.
4. **Input Rule Y:** Otherwise, use `yk`.

All operations dynamically generate and update the coefficient matrix based on the current inputs and outputs.

## 💻 Implementation

The application:
- Converts two rational numbers into continued fractions
- Applies the selected arithmetic operation using the Gosper Algorithm
- Returns the result in continued fraction format

### 🔗 GitHub Repository

👉 [github.com/kevseryolcu/ContinuedFractionArithmetic](https://github.com/kevseryolcu/ContinuedFractionArithmetic)

### ▶️ How to Run

1. Clone the repository
2. Compile and run `CFArithmeticsApp.java`
3. Provide two fractional inputs and an operation string (`+`, `-`, `*`, `/`)

## 📚 References

1. William F. Hammond, *Continued Fractions and the Euclidean Algorithm*, 1997  
2. [Wikipedia: Continued Fraction](https://en.wikipedia.org/wiki/Continued_fraction)  
3. Luther Tychonievich, *Continued Fractions*, 2011  
4. Mark Jason Dominus, *Arithmetic with Continued Fractions*, 2005
