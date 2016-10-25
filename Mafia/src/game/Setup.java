package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Setup {
	Scanner x = new Scanner(System.in);
	int players;
	Random random = new Random();
	List<String> names = new ArrayList<String>(), roles = new ArrayList<String>();
	
	public void setup(){
		System.out.println("How many people are playing?");
		players = x.nextInt();
		rolesSetup();
		for(int i = 0; i < players; i ++){
			System.out.println("Player " + (i + 1) + " name: ");
			names.add(x.next());
		}
		random.nextInt(players);
	}
	
	public void rolesSetup(){
		
	}
}
