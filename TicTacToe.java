package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> SystemPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		char [][] gameBord= {{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};
		
		
		
		pringBord(gameBord);
		
		
		
		
		while (true) {
			Scanner scan =new Scanner(System.in);
			System.out.println("enter your number from (1-9)");
			int playerPosition=scan.nextInt();
			while (playerPositions.contains(playerPosition) || SystemPositions.contains(playerPosition)) {
				System.out.println("position already taken   try again  ");
				playerPosition=scan.nextInt();
				
			}
			
			
			placeChoice(gameBord,playerPosition,"player");
			String result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			
			Random rend=new Random();
			int systemPositon=rend.nextInt(9) + 1;
			while (playerPositions.contains(systemPositon) || SystemPositions.contains(systemPositon)) {
				systemPositon=rend.nextInt(9) + 1;
			}
			
			placeChoice(gameBord,systemPositon,"system");
			
			pringBord(gameBord);
			
			result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			
			
		}
		
		
		
	}

	public static void pringBord(char[][] gameBord) {
		for (char [] c:gameBord) {
			for (char a:c) {
				System.out.print(a);
				
			}
			System.out.println();
			
		}
	}
	public static void placeChoice(char[][] gameBord, int position, String user) {
		
		char symbol='X';
		if (user.equals("player")) {
			symbol='X';
			playerPositions.add(position);
		} else if (user.equals("system")) {
			symbol='O';
			SystemPositions.add(position);
		}
		
		
		switch (position) {
			case 1:
				gameBord[0][0]=symbol;
				break;
			case 2:
				gameBord[0][2]=symbol;
				break;
			case 3:
				gameBord[0][4]=symbol;
				break;
			case 4:
				gameBord[2][0]=symbol;
				break;
			case 5:
				gameBord[2][2]=symbol;
				break;
			case 6:
				gameBord[2][4]=symbol;
				break;
			case 7:
				gameBord[4][0]=symbol;
				break;
			case 8:
				gameBord[4][2]=symbol;
				break;
			case 9:
				gameBord[4][4]=symbol;
				break;
		}
	}
	public static String checkWinner() {
		List topRow= Arrays.asList(1, 2, 3);
		List midRow= Arrays.asList(4, 5, 6);
		List botRow= Arrays.asList(7, 8, 9);
		List leftCol= Arrays.asList(1, 4, 7);
		List midCol= Arrays.asList(2, 5, 8);
		List rightCol= Arrays.asList(3, 6, 9);
		List cross1= Arrays.asList(1, 5, 9);
		List cross2= Arrays.asList(3, 5, 7);
		
		List<List> winning=new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for (List l:winning) {
			if (playerPositions.containsAll(l)) {
				return "             congratulations you won  '_'            ";
				
			} else if (SystemPositions.containsAll(l)) {
				return "------  System wins sorry---------- ";
				
			} else if (playerPositions.size() + SystemPositions.size() == 9) {
				return "-----------Draw----------------";
				
			}
			
			
		}
		
		
		return "";
		
	}
	
	
}



