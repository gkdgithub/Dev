package com.udemy.udemyJava;

public class MethodChallenge {

	public static void main(String[] args) {
		
		boolean gameOver=true;
		int score=80;
		int levelCompleted=2;
		int bonus=10;
		
		int highScore=calculateScore(gameOver, score, levelCompleted, bonus);
		System.out.println("Your final score was : "+highScore);
		
		int positionOfThePlayer=calculateHighScorePosition(highScore);
		displayHighScorePosition("Gaurav", positionOfThePlayer);
		System.out.println("==================================================================");
		
		score=1000;
		levelCompleted=8;
		bonus=200;
		
		highScore=calculateScore(gameOver, score, levelCompleted, bonus);
		System.out.println("Your final score was : "+highScore);
		
		
		positionOfThePlayer=calculateHighScorePosition(highScore);
		displayHighScorePosition("Kumar", positionOfThePlayer);
		System.out.println("====================================================================");
		
		
		positionOfThePlayer=calculateHighScorePosition(1500);
		displayHighScorePosition("Tim", positionOfThePlayer);
		positionOfThePlayer=calculateHighScorePosition(900);
		displayHighScorePosition("Bob", positionOfThePlayer);
		positionOfThePlayer=calculateHighScorePosition(400);
		displayHighScorePosition("Percy", positionOfThePlayer);
		positionOfThePlayer=calculateHighScorePosition(50);
		displayHighScorePosition("Gilbert", positionOfThePlayer);
		
	}
	
	public static int calculateScore(boolean gameOver, int score, int levelCompleted,int bonus){
		if(gameOver){
			int finalScore=score+(levelCompleted*bonus);
			finalScore+=20;
			return finalScore;
		}
		return -1;			
	}
	
	public static void displayHighScorePosition(String playerName,int positionOfThePlayer){
		System.out.println(playerName+" managed to get into position "
							+positionOfThePlayer+" on the high score table.");
	}
	
	public static int calculateHighScorePosition(int playerScore){
		
/*		if(playerScore>=1000){
			return 1;
		}		
		else if(playerScore>=500 && playerScore<1000){
			return 2;
		}	
		else if(playerScore>=100 && playerScore<500){
			return 3;
		}
		else{
			return 4;
		}*/
		
		int position=4;  // assuming position 4 will be return 
		if(playerScore>=1000)
			position=1;
		else if(playerScore>=500)
			position=2;
		else if(playerScore>=100)
			position= 3;
			
		return position;
	}

}
