import java.util.Scanner;

/**
 * @author Daniel
 *
 */
public class Hand {
	Dice[] die;
	int rollsLeft;
	int diceNumber;
	Scanner scan = new Scanner(System.in);
	
	public Hand(int initialDiceNumber, int initialRollsLeft) {
		diceNumber = initialDiceNumber;
		rollsLeft = initialRollsLeft;
		die = new Dice[diceNumber];
		for (int i = 0; i < diceNumber; i++) {
			die[i] = new Dice(6);
		}
	}
	
	public void rollHand() {
		for (int i = 0; i < diceNumber; i++) {
			if (die[i].getKept() != true) {
				die[i].roll();
			}
		}
	}
	
	public int getRollsLeft() {
		return rollsLeft;
	}
	
	public void setRollsLeft(int newRollsLeft) {
		rollsLeft = newRollsLeft;
	}
	
	public int getDiceNumber() {
		return diceNumber;
	}
	
	public void setDiceNumber(int newDiceNumber) {
		diceNumber = newDiceNumber;
	}
	
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
	
	public void changeHand() {
		
		String newHand;
		
		do {
			System.out.print("Y/N for keep: ");
			newHand = scan.next();
		} while (newHand.length() != diceNumber);

		
		for (int i = 0; i < diceNumber; i++){
			if ((newHand.charAt(i)) == ('N') || (newHand.charAt(i)) == ('n')) {
				die[i].roll();
			}
		}
	}
	
	
}