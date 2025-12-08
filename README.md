# DataStructures Repo

This repository contains a collection of fundamental data structure and algorithm examples in Java, intended for study, practice, and reference.  

**Note:** Each method has been annotated with **time complexity comments** to help understand the efficiency of operations and guide decisions when choosing data structures or algorithms.  

# Time Complexity Cheat Sheet (Java Examples)

## O(1) — Constant Time

Occurs when the work does not depend on input size.

**Example:**

```java
int getFirst(int[] arr) {
    return arr[0];
}
```

---

## O(n) — Linear Time

Occurs when the algorithm touches each element once.

**Example:**

```java
int sum(int[] arr) {
    int s = 0;
    for (int x : arr) s += x;
    return s;
}
```

---

## O(log n) — Logarithmic Time

Occurs when the problem size is cut by a constant factor each step.

**Example:**

```java
int binarySearch(int[] arr, int target) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int m = (l + r) / 2;
        if (arr[m] == target) return m;
        if (arr[m] < target) l = m + 1;
        else r = m - 1;
    }
    return -1;
}
```

---

## O(n log n) — Linearithmic Time

Occurs when an algorithm performs a log n operation for each of n elements.

**Example (sorting):**

```java
Arrays.sort(arr);
```

---

## O(n²) — Quadratic Time

Occurs with nested loops over the same data.

**Example:**

```java
void printPairs(int[] arr) {
    for (int i = 0; i < arr.length; i++)
        for (int j = 0; j < arr.length; j++)
            System.out.println(arr[i] + ", " + arr[j]);
}
```

---

## O(2ⁿ) — Exponential Time

Occurs when exploring all subsets.

**Example:**

```java
void subsets(int[] arr, int i) {
    if (i == arr.length) return;
    subsets(arr, i + 1);
    subsets(arr, i + 1);
}
```

---

## O(n!) — Factorial Time

Occurs when generating all permutations.

**Example:**

```java
void permute(List<Integer> nums, int start) {
    if (start == nums.size()) return;
    for (int i = start; i < nums.size(); i++) {
        Collections.swap(nums, start, i);
        permute(nums, start + 1);
        Collections.swap(nums, start, i);
    }
}
```

---

## Quick Recognition Guide

* **Single step** → O(1)
* **Single loop** → O(n)
* **Halving** → O(log n)
* **Loop + halving** → O(n log n)
* **Nested loops** → O(n²)
* **Branching recursion** → O(2ⁿ)
* **Permutations** → O(n!)
