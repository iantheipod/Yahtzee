import java.util.Scanner;

/* 
 * Author: Daniel Abrahms
 * Last Edited: 2/5/17
 * Class: CPSC 224-02
 * Class: hand
 * Description: This is the Hand Class. It holds an array of Dice and has a counter for number of rolls left. 
 */
public class Hand {
	// the array of dice objects
	private Dice[] die;
	// the number of rollsLeft in this round
	private int rollsLeft;
	// The number of Dice in game
	private int diceNumber;
	private Scanner scan = new Scanner(System.in);
	
	// constructor for Hand
	// instantiates array of dice
	public Hand(int initialDiceNumber, int initialRollsLeft) {
		diceNumber = initialDiceNumber;
		rollsLeft = initialRollsLeft;
		die = new Dice[diceNumber];
		for (int i = 0; i < diceNumber; i++) {
			die[i] = new Dice(6);
		}
	}
	
	// rolls each die, unless die's kept is true
	public void rollHand() {
		for (int i = 0; i < diceNumber; i++) {
			if (!die[i].getKept()) {
				die[i].roll();
			}
		}
	}
	
	// returns the Dice at a given index
	public Dice getDice(int index) {
		return die[index];
	}

	// returns the rollsLeft attribute
	public int getRollsLeft() {
		return rollsLeft;
	}
	
	// sets the rollsLeft attribute
	public void setRollsLeft(int newRollsLeft) {
		rollsLeft = newRollsLeft;
	}
	
	// gets the diceNumber attribute
	public int getDiceNumber() {
		return diceNumber;
	}
	
	// sets the diceNumber attribute
	public void setDiceNumber(int newDiceNumber) {
		diceNumber = newDiceNumber;
	}
	
	// prints each die
	public void displayHand(){
		System.out.print("Hand: ");
		for (int i = 0; i < diceNumber; i++) {
			System.out.print(die[i].getValue());
			if (i != diceNumber-1) { 
				System.out.print("-");
			}
		}
		System.out.println();
	}
	
	// prompts user for which die to roll
	public void changeHand() {
		
		String newHand;
		
		do {
			System.out.print("Y/N for keep: ");
			newHand = scan.next();
		} while (newHand.length() != diceNumber);

		
		for (int i = 0; i < diceNumber; i++){
			if ((newHand.charAt(i)) == ('N') || (newHand.charAt(i)) == ('n')) {
				die[i].setKept(false);
			}
		}
		rollHand();

	}
	
	// sorts hand from lowest -> highest 
	public void sortHand() {
		Dice temp;
		for (int i = 0; i < diceNumber - 1; i++) {
			for (int j = 1; j < diceNumber - i; j++) {
				if (die[j-1].getValue() > die[j].getValue()) {
					temp = die[j - 1];
					die[j - 1] = die[j];
					die[j] = temp;
				}
			}
		}
	}
	
	// returns sum of die's value
	public int sum() {
		int sum = 0;
		for (int i = 0; i < diceNumber; i++) {
			sum += die[i].getValue();
		}
		return sum;
	}
	
	
}
