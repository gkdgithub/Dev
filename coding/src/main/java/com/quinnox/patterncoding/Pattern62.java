package com.quinnox.patterncoding;

public class Pattern62 {

	public static void main(String[] args) {
		
		int size=4;
		for(int i=size;i>=1;i--){
			for(int j=1;j<i;j++){
				System.out.print(" ");
			}
			for(int k=size;k>=i;k--){
				System.out.print((char)((k-1)+65));
			}
			System.out.println();
		}
		for(int i=1;i<=size;i++){
			for(int j=1;j<=i;j++){
				System.out.print(" ");
			}
			for(int k=(size-1);k>=i;k--){
				System.out.print((char)(k+65));
			}
			System.out.println();
		}

	}

}
