## Arrays (Java)

```java
int[] arr = new int[5]
```

# Definition
* A fixed-size contiguous block of memory.
* Holds elements of the same type.
* Fast indexed access: O(1).
* Size cannot change once allocated.

# Key operations
* Access (direct index look up): arr[i]
* Update (overwrites in place): arr[i] = x
* Search: O(n) [unless sorted: binary search O(log n)]
* Insert at index (requires shifting elements): O(n)
* Delete at index (requires shifting elements): O(n)

# Declaration forms
* Primitive arrays store values.
* Object arrays store references.

# Common pitfalls
* ArrayIndexOutOfBoundsException.
* Zero-indexed.
* Null entries with object arrays.

# Iteration
* For loop:
  ```java
  for (int i = 0; i < arr.length; i++) { ... }

  for ( int x : arr ) { ... }
  ```

# Copying and resizing
* Arrays cannot resize, so “resizing” means allocating a new array.
  ```java
  int[] newArr = Arrays.copyOf(oldArr, newSize);
  ```
* Deep copy for primitives, shallow copy for objects.

# Sorting
* Arrays.sort(arr);
  * Dual-pivot quicksort for primitives.
  * TimSort for objects.
  * Stable for objects, not necessarily for primitives.

# Searching
* Linear search
  ```java
  for (int x : arr) { ... }
  ```
* Binary search on sorted arrays
  ```java
  int idx = Arrays.binarySearch(arr, target);
  ```
  
# Multidimensional arrays
* Rectangular
  ```java
  int[][] matrix = new int[3][4];
  ```
* Jagged
  ```java
  int[][] jag = new int[3][];
  jag[0] = new int[2];
  jag[1] = new int[5];
  ```

# Use arrays when:
* Size is fixed or rarely changed.
* You need fastest possible indexed access.
* You need tight memory control (arrays are very compact).
* You are implementing lower-level data structures (ArrayList, heap, tries).

# Avoid arrays when:
* You need frequent insertions/deletions in the middle.
* The size grows unpredictably (use ArrayList instead).
