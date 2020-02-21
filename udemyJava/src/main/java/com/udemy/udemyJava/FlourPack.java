package com.udemy.udemyJava;

public class FlourPack {

	public static void main(String[] args) {
		System.out.println(canPack(4, 18, 19));
	}
	
	public static boolean canPack(int bigCount, int smallCount, int goal){
		
		if(bigCount<0 || smallCount<0 || goal<0){
			return false;
		}
		else{
			int bigCountWeight=bigCount*5;
			int smallCountWeight=smallCount*1;
			
			if((bigCountWeight+smallCountWeight)<=goal){
				return true;
			}
			else if((bigCountWeight+smallCountWeight)>goal){
				if(bigCountWeight==goal){
					return true;
				}
				else if(bigCountWeight<goal){
					return true;
				}
				else{
					// to-do
					int diff=bigCountWeight-goal;
					if(diff>=goal){
						return true;
					}
					else{
						return false;
					}
				}
			}
			else{
				return false;
			}	
		}
		
	}
	
}
