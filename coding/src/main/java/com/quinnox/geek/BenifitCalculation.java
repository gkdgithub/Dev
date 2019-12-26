package com.quinnox.geek;

import java.util.Scanner;
import java.util.TreeSet;

public class BenifitCalculation {

	public static void main(String[] args) {
		System.out.println("Enter the principal amount : ");
		Scanner scanner=new Scanner(System.in);
		int principalAmount=scanner.nextInt();
		benifitCalculation(principalAmount);
		scanner.close();
	}

	private static void benifitCalculation(int principalAmount) {
		int benifitAmount=0;
		int newPrincipalAmount=0;
		TreeSet<Integer> benifitTreeSet=new TreeSet<>();
		Integer[]  presentStockRate={175,128,145,132,97};
		Integer[]  futureStockRate={200,109,165,140,120};
		
		if(presentStockRate.length==futureStockRate.length){
			for(int i=0;i<futureStockRate.length;i++){
				newPrincipalAmount=principalAmount;
				if(futureStockRate[i]>presentStockRate[i]){
					if(newPrincipalAmount>=futureStockRate[i]){
						newPrincipalAmount=newPrincipalAmount-futureStockRate[i];
						benifitAmount=futureStockRate[i]-presentStockRate[i];
						for(int j=i+1;j<futureStockRate.length;j++){
							if(futureStockRate[j]>presentStockRate[j]){
								if(newPrincipalAmount>=futureStockRate[j]){
									benifitAmount=futureStockRate[j]-presentStockRate[j];
									
									benifitAmount=benifitAmount+(futureStockRate[j]-presentStockRate[j]);
									newPrincipalAmount=newPrincipalAmount-futureStockRate[i];
								}
							}
						}
					}
				}
				benifitTreeSet.add(benifitAmount);
			}
			
		}
		
		System.out.println("Max benifit is : "+benifitTreeSet.last());		
	}

}
