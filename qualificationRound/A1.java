package googleCode2018;

import java.math.BigInteger;
import java.util.Scanner;

/** Saving The Universe Again
 * @author sunil.bn
 * Problem: https://codejam.withgoogle.com/2018/challenges/00000000000000cb/dashboard
 * 
 */
public class A1 {

	private static BigInteger calcDamage(String s){
		BigInteger d = new BigInteger("0");
		BigInteger c = new BigInteger("1");
		final BigInteger two = new BigInteger("2");
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == 'S'){
				d = d.add(c);
			}else if(s.charAt(i) == 'C'){
				c = c.multiply(two);
			}
		}
		return d;
	}
	
	public static void main(String[] args) {
		System.out.println("Saving The Universe Again\n");
		//read the inputs
		Scanner sc = new Scanner(System.in);
		 //test cases
		int T = Integer.parseInt(sc.nextLine());
		for (int i = 0; i<T; i++) {
			//read damage and sequence
			String[] in = sc.nextLine().split(" ");
			BigInteger D = new BigInteger(in[0]);
			StringBuilder s = new StringBuilder(in[1]);
			//System.out.println("Damage: "+D.intValue()+" Pattern: "+s);
			//System.out.println(calcDamage(s));
			int L = s.length();
			String origin = s.toString();
			int swaps =0;
			Boolean found = false;
			while(calcDamage(s.toString()).compareTo(D) > 0){
				for(int j=L-2;j>=0;j--){
					//look for the last CS charge and shoot
					if(s.charAt(j) == 'C' && s.charAt(j+1) == 'S'){
						s.setCharAt(j, 'S');
						s.setCharAt(j+1, 'C');
						swaps++;
						found = true;
						break;
					}
				}
				if(!found) break;
			}
			if(calcDamage(s.toString()).compareTo(D) >0){
				System.out.println("Case #"+(i+1)+ "(Pattern: "+origin+" Max Damage:"+D+"): IMPOSSIBLE");
			}else{
				System.out.println("Case #"+(i+1)+ "(Pattern: "+origin+" Max Damage:"+D+"): "+swaps);
			}
		}
		sc.close();
		System.out.println("\n\nWe tried saving the Universe :) ");
		return;
	}
}