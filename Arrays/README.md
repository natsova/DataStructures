## Arrays (Java)

int[] arr = new int[5]

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
* Null entries of object arrays.

# Iteration
* For loop:
  for ( int x : arr ) { ... }

#
