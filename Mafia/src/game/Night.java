package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Night {
	Scanner x = new Scanner(System.in);
	boolean repeat = false;
	String target;
	int mafiaTotal;
	public void actions(int players, List<Integer> roles, List<String> names){
		for (int turn = 0; turn < players; turn ++){
			//Instead of 'turns', for the webpage, it will all happen at the same time and there should be a timer
			switch(roles.get(turn)){
			case 1: 
				mayor();
				break;
			case 2: 
				investigator(turn, names, players, roles);
				break;
			case 3: 
				jailor(turn, players, names);
				break;
			case 4: 
				normal();
				break;
			case 5: 
				escort(turn, players, names);
				break;
			case 6: 
				medic(turn, players, names);
				break;
			case 7: 
				bodyguard(turn, players, names);
				break;
			case 8: 
				paparazzi(turn, players, names);
				break;
			case 9: 
				jester();
				break;
			case 10:
				executioner(turn, names, players);
				break;
			case 11:
				mafia(turn, names, roles);
				break;
			case 12:
				SK(turn, names);
				break;
			}
		}
	}

	public void mayor(){
		System.out.println("You are the mayor. You cannot do anything in the night");
	}
	public void investigator(int turn, List<String> names, int players, List<Integer> roles){
		System.out.println("You are the investigator.\nChoose a person to investigate");
		displayNames(turn, players, names);
		String choice = x.next();
		if(roles.get(names.indexOf(choice)) >= 9){
			System.out.println("This suspect is suspicious");
		}
		else{
			System.out.println("This suspect is a townie");
		}
	}
	public void jailor(int turn, int players, List<String> names){
		System.out.println("You are the jailor.\nChoose a person to jail");
		displayNames(turn, players, names);
		String choice = x.next();
		//Need to finish
	}
	public void normal(){
		System.out.println("You are a normal townie, you can't do anything in the night");
	}
	public void escort(int turn, int players, List<String> names){
		System.out.println("You are the escort.\nChoose someone to distract");
		displayNames(turn, players, names);
		String choice = x.next();
		//Need to finish
	}
	public void medic(int turn, int players, List<String> names){
		System.out.println("You are the medic.\nChoose a person to heal");
		displayNames(turn, players, names);
		System.out.println(names.get(turn));
		String choice = x.next();
		//Need to finish

	}
	public void bodyguard(int turn, int players, List<String> names){
		System.out.println("You are the bodyguard.\nChoose a person to guard");
		displayNames(turn, players, names);
		String choice = x.next();
		//Need to finish
	}
	public void paparazzi(int turn, int players, List<String> names){
		System.out.println("You are the paparazzi.\nChoose a person to visit");
		displayNames(turn, players, names);
		String choice = x.next();
		//Need to finish
	}
	public void jester(){
		System.out.println("You are the jester. You do nothing in the night");
	}
	public void executioner(int turn, List<String> names, int players){
		Random random = new Random();
		if (repeat == false){
			target = names.get(random.nextInt(players));
		}
		System.out.println("You are the executioner. Your target for the game is " + target);
		repeat = true;
	}
	public void mafia(int turn, List<String> names, List<Integer> roles){
		List<String> votes = new ArrayList<String>();
		mafiaTotal = 1;
		System.out.println("You are the mafia.\nThe other mafia members are: ");
		for (int i = 0; i < names.size(); i ++){
			if (roles.get(i) == 11 && i != turn){
				System.out.println(names.get(i));
				mafiaTotal ++;
			}
		}
		//Need to add messaging here between mafia on webpage
		System.out.println("Vote for a person to kill");
		displayNames(turn, names.size(), names);
		votes.add(x.next());
		//Need to find majority here
		String choice; // = majority
	}
	public void SK(int turn, List<String> names){
		System.out.println("You are the serial killer.\nChoose a person to kill");
		displayNames(turn, names.size(), names);
		String choice = x.next();
	}
	public void displayNames(int turn, int players, List<String> names){
		for (int i = 0; i < players; i ++){
			if (turn != i){
				System.out.println(names.get(i));
			}
		}
	}
}
