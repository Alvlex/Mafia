package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Setup {
	Scanner x = new Scanner(System.in);

	List<String> names = new ArrayList<String>();
	List<Integer> roles = new ArrayList<Integer>();

	public void setup(){
		int players = getPlayerNo();
		System.out.println("How many townies? (Default is " + Math.round(players/2) + ")");
		roles = rolesSetup(x.nextInt(), players);
		names = getPlayerNames(players);
		roles = setRoles(roles);
	}

	public List<Integer> rolesSetup(int townies, int players){
		System.out.println("Choose town roles\n(1)Mayor\n(2)Investigator\n(3)Jailor\n(4)Normal\n(5)Escort\n(6)Medic\n(7)Bodyguard\n(8)Paparazzi");
		for (int i = 0; i < townies; i ++){
			roles.add(x.nextInt());
		}
		System.out.println("Choose anti-town roles\n(1)Jester\n(2)Executioner\n(3)Mafia\n(4)Serial Killer");
		for (int i =0; i < (players - townies); i ++){
			roles.add(x.nextInt() + 8);
		}
		return roles;
	}
	
	public int getPlayerNo(){
		System.out.println("How many people are playing?");
		return x.nextInt();
	}
	public List<String> getPlayerNames(int players){
		List<String> names = new ArrayList<String>();
		for(int i = 0; i < players; i ++){
			System.out.println("Player " + (i + 1) + " name: ");
			names.add(x.next());
		}
		return names;
	}
	public List<Integer> setRoles(List<Integer> roles){
		List<Integer> randomizedRoles = new ArrayList<Integer>();
		Random random = new Random();
		int index;
		for(int i = 0; i < roles.size(); i ++){
			index = random.nextInt(roles.size());
			randomizedRoles.add(roles.get(index));
			roles.remove(index);
		}
		return randomizedRoles;
	}
}
