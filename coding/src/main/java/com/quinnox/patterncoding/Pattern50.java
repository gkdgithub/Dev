package com.quinnox.patterncoding;

public class Pattern50 {

	public static void main(String[] args) {
		
		int hieght=4;
		int maxNumber=7;
		for(int i=hieght;i>0;i--){
			for(int j=hieght;j>i;j--){
				System.out.print(" ");
			}
			for(int k=1;k<=maxNumber;k++){
				System.out.print(k);
			}
			maxNumber-=2;
			System.out.println();
		}

	}

}
