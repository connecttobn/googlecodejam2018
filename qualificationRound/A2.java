package googleCode2018;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**Trouble Sort
 * @author sunil.bn
 * Problem: https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard/00000000000079cb
 * 
 */
public class A2 {

    public static void printList(ArrayList<BigInteger> a){
        int N = a.size();
        	System.out.print("\n");
			for(int k=0;k<N;k++){
			    System.out.print(a.get(k).intValue()+" ");
			}
			System.out.print("\n");
    }
	/*
	 * Implementation of trouble sort
	 * TroubleSort(L): // L is a 0-indexed list of integers
	    let done := false
	    while not done:
	      done = true
	      for i := 0; i < len(L)-2; i++:
	        if L[i] > L[i+2]:
	          done = false
	          reverse the sublist from L[i] to L[i+2], inclusive
	 */
	private static ArrayList<BigInteger> troubleSort(ArrayList<BigInteger> a, int N){
		Boolean done = false;
		System.out.print("Before sort");
	    printList(a);
		while(!done){
			done = true;
			for(int i=0;i<N-2;i++){
				if(a.get(i).compareTo(a.get(i+2)) > 0){
					done = false;
					//reverse the sublist from L[i] to L[i+2], inclusive
					//a,b,c => c,a,b
					Collections.swap(a, i, i+2);
				}
			}
		}
		System.out.print("After sort");
	    printList(a);
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println("Trouble Sort\n");
		//read the inputs
		Scanner sc = new Scanner(System.in);
		 //test cases
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i<T; i++) {
			//read length of array
			int N = Integer.parseInt(sc.nextLine());
			ArrayList<BigInteger> a = new ArrayList<BigInteger>();
			String[] in = sc.nextLine().split(" ");
			for(int j=0;j<N;j++){
				a.add(new BigInteger(in[j]));
			}
			troubleSort(a, N);
			int res = isSorted(a, N);
			if(res == -1){
				System.out.println("Case #"+(i+1)+": OK\n");
			}else{
				System.out.println("Case #"+(i+1)+": "+res+"\n");
			}
		}
		sc.close();
		System.out.println("\n\nWe tried Trouble Sort :) ");
		return;
	}

	private static int isSorted(ArrayList<BigInteger> a, int N) {
		for(int i=0;i<N-1;i++){
			if(a.get(i).compareTo(a.get(i+1)) > 0){
				return i;
			}
		}
		return -1;
	}
}