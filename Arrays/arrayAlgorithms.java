import java.util.Arrays;

public class arrayAlgorithms {

	// Print the array
	static void print(int [] arr) {
		System.out.println();
		System.out.print("[");
		for ( int a : arr ) {	
			System.out.print(" " + a + " ");
		}
		System.out.print("]");
	}
	
	// Reverse an array in-place without using a second array
	static int reverse(int[] arr) {
	    int l = 0, r = arr.length - 1;
	    while ( l < r ) {
	        int tmp = arr[l];
	        arr[l] = arr[r];
	        arr[r] = tmp;
	        l++;
	        r--;
	    }
		return r;
	}

	// Find the max and min in one pass
	static int[] minMax(int[] arr) {
	    int min = arr[0], max = arr[0];
	    for ( int x : arr ) {
	        if ( x < min ) min = x;
	        if ( x > max ) max = x;
	    }
	    return new int[]{min, max};
	}

	// Check if array is sorted (strictly non-decreasing)
	static boolean isSorted(int[] arr) {
	    for ( int i = 1; i < arr.length; i++ ) {
	        if ( arr[i] < arr[i - 1] ) 
	        	return false;
	    }
	    return true;
	}

	// Remove duplicates from sorted array in-place and return new length
	static int[] removeDuplicates(int[] arr) {
		if (arr.length == 0) return new int[0];

	    int w = 1;	// Write pointer; first element arr[0] is unique by default as no preceding 
	    // values,so next unique value should go into arr[1]
	    for ( int r = 1; r < arr.length; r++ ) {
	        if ( arr[r] != arr[r - 1] ) { // if arr[0] & arr[1] are unique
	            arr[w++] = arr[r]; 
	            /* In first iteration current w = 1 → arr[1] = arr[1] → writes 8 to itself
				 * THEN w++ → w = 2
				 * 		Post-increment operator:
				 * 		Step 1: Use the current value of w in the expression.
				 * 		Step 2: After the expression is evaluated, increment w by 1.
				 * 		So the increment happens after the assignment.
				 * 		Compare to pre-increment operator ++w.
				 * 		arr[++w] = arr[r];
				 * 		Step 1: Increment w first
				 * 		Step 2: Use the new value of w (2) in the assignment
				 * 			w++ → “use, then increment”
				 * 			++w → “increment, then use”
	             * Write current value (arr[r] to it and then increment w (arr[2])
	             * ie (don't want to overwrite unique value at arr[1]).
	             */
	        }
	    }
        // Create a new array with only the unique elements
	    int[] uniqueArr = Arrays.copyOf(arr, w);
	    return uniqueArr;
	}
	
	// Move all zero values to the end while keeping the order of non-zero elements.
	static int[] moveZeroes(int[] arr) {
	    int w = 0;
	    for ( int r = 0; r < arr.length; r++ ) {
	        if ( arr[r] != 0 ) 
	        	arr[w++] = arr[r];
	    }
	    while (w < arr.length) arr[w++] = 0;
	    
	    return arr;
	}
	
	// Two-sum in sorted array (two pointers) - avoids unnecessary checks.
	// In sorted array, find if any pair sums to target.
	static boolean twoSum(int[] arr, int target) {
	    int l = 0, r = arr.length - 1;
	    while ( l < r ) {
	        int sum = arr[l] + arr[r];
	        if ( sum == target ) return true;
	        if ( sum < target ) l++;
	        else r--;
	    }
	    return false;
	}

	// Max subarray sum (Kadane’s algorithm)
	// Return max sum of contiguous subarray.
	static int maxSubArray(int[] arr) {
	    int cur = arr[0];	// maximum sum of a contiguous subarray ending at index i.
	    int max = arr[0];	// best sum found so far
	    for ( int i = 1; i < arr.length; i++ ) {	// extending the previous subarray to include arr[i].
	        cur = Math.max(arr[i], cur + arr[i]);	 // arr[i] starts a new subarray at i if the previous sum is negative.
	        max = Math.max(max, cur);	// stores the largest sum seen so far.
	    }
	    return max;
	}

	// Prefix sum range query
	// Precompute a prefix sum array so you can answer sum(l, r) in O(1).
	// Don’t have to loop through the array to compute sums.
	static int[] buildPrefix(int[] arr) {
	    int[] pre = new int[arr.length + 1];	// extra space for leading 0, pre[0] = 0
	    for ( int i = 1; i < pre.length; i++ ) {
	        pre[i] = pre[i - 1] + arr[i - 1];	// stores sum of first i elements.
	    }
	    return pre;
	}

	static int rangeSum(int[] pre, int l, int r) {
	    return pre[r + 1] - pre[l];	// sum of arr[l..r] in O(1) time
	}

	/* In an rray of size n containing numbers 0..n, find the missing number.
	 * XOR is a bitwise operator written as ^. XOR outputs 1 only when the bits are different.
	 * XOR compares numbers bit-by-bit. Same bits cancel to 0.
	 * XORing a whole set of numbers leaves only the non-cancelled number.
	 * XOR properties:
	 * 		a ^ a = 0 (so pairs cancel each other out)
	 * 		a ^ 0 = a
	 * 		XOR is commutative (order doesn’t matter) and associative (grouping doesn’t matter)
	 * XOR is used for:
	 * 		finding a missing number
	 * 		finding the single number where all others appear twice
	 * 		parity checks
	 * 		bit manipulation tricks
	 * 
	 * The XOR method does not work if there are numbers outside 0..n.
	 */
	
	static int missingNumber(int[] arr) {
	    int xor = 0;
	    for ( int i = 0; i < arr.length; i++ ) 
	    	xor ^= i ^ arr[i];
	    	/* Compute the XOR of:
	    	 * 		i ^ arr[i] -->  the current index i and the value at that index arr[i]
	    	 * 						This produces some integer (bitwise XOR).
	    	 * 		xor ^= x  -->	Take the current value of xor and XOR it with x.
	    	 * */
	    return xor ^ arr.length;
	}

	// Rotate array right by k.
	// Technique: Reverse whole array → reverse first k → reverse rest.
	static int[] rotate(int[] arr, int k) {
	    int n = arr.length;
	    k %= n;		// Modulo - remainder after division.
	    reverse(arr, 0, n - 1);
	    reverse(arr, 0, k - 1);
	    reverse(arr, k, n - 1);
	    return arr;
	}

	static void reverse(int[] arr, int l, int r) {
	    while (l < r) {
	        int tmp = arr[l];
	        arr[l] = arr[r];
	        arr[r] = tmp;
	        l++; r--;
	    }
	}
	
	public static void main(String[] args) {
		int[] arr = {-100, -44, -44, -10, -8, 2, 0};
		int[] arr2 = {0, 2, 3};
		int k = 1;
		print(arr);
		reverse(arr);
		print(arr);
		print(minMax(arr));
		System.out.println(isSorted(arr));
		print(removeDuplicates(arr));
		print(moveZeroes(arr));
		System.out.println(twoSum(arr, 9));
		System.out.println(maxSubArray(arr));
		System.out.println(rangeSum(buildPrefix(arr), 3, 4)); 	// 100 - 44
		System.out.println(missingNumber(arr2));
		print(rotate(arr2, k));
	}
}
