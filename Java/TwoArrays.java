/*
You are given two integer arrays, A and B, each containing N integers. The size of the array is less than or equal to 1000.
You are free to permute the order of the elements in the arrays.

Now here's the real question: Is there an permutation A', B' possible of A and B, such that, 
A'i+B'i ≥ K for all i, where A'i denotes the ith element in the array A' and B'i denotes ith element in the array B'.


Input Format
The first line contains an integer, T, the number of test-cases. T test cases follow. Each test case has the following format:

The first line contains two integers, N and K. The second line contains N space separated integers, denoting array A.
The third line describes array B in a same format.

Output Format
For each test case, if such an arrangement exists, output "YES", otherwise "NO" (without quotes).


Constraints
1 <= T <= 10
1 <= N <= 1000
1 <= K <= 109
0 <= Ai, Bi ≤ 109


Sample Input
2
3 10
2 1 3
7 8 9
4 5
1 2 2 1
3 3 3 4

Sample Output
YES
NO

Explanation

The first input has 3 elements in Array A and Array B, we see that the one of the arrangements,
3 2 1 and 7 8 9 has each pair of elements (3+7, 2 + 8 and 9 + 1) summing upto 10 and hence the answer is "YES".

The second input has array B with three 3s.
So, we need at least three numbers in A that are greater than 1. As this is not the case, the answer is "NO".
*/
import java.util.*;

public class TwoArrays
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        while(--testCases >= 0) {
            int size = sc.nextInt();
            int k = sc.nextInt();

            TreeMap<Integer,Integer> a = new TreeMap<Integer,Integer>();
            int [] b = new int[size];
            int i;
            for (i = 0; i < size; i++) {
                int input = sc.nextInt();
                if (null == a.get(input)) {
                    a.put(input, 1);
                } else {
                    int val = a.get(input);
                    a.put(input, ++val);
                }
            }
            
            for (i = 0; i < size; i++) {
                b[i] = sc.nextInt();
            }

            for (i = 0; i < size; i++) {
                Map.Entry<Integer,Integer> entry = a.ceilingEntry(k - b[i]);
                if (null != entry) {
                    int key = entry.getKey();
                    int val = entry.getValue();
                    if (--val == 0) {
                        a.remove(key);
                    } else {
                        a.put(key, val);
                    }
                } else {
                    System.out.println("NO");
                    break;
                }
            }
            if (i == size) {
                System.out.println("YES");
            }
        }
    }
}