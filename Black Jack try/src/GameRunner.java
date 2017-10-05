
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		
		boolean playAgain = true;
		
		Scanner play = new Scanner(System.in);
		String ans2;
			
		Scanner dollar = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		// initialize deck
		Deck theDeck = new Deck(1, true);
		
		// initialize player objects
		Player one = new Player("Eddy");
		Player dealer = new Player ("Dealer");
		
		int money = 100;
		int bet;
		int left;
		int payOut = 0;
		
		
		while (playAgain = true) {
		
		one.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		one.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		System.out.println("How much do you want to bet?");
		bet = dollar.nextInt();
		System.out.print("Your bet is: "+bet +". ");
		left = money - bet;
		System.out.println("Money left: "+left);
		
		
		// flags for when each player is finished hitting
				boolean oneDone = false;
				boolean dealerDone = false;
				//boolean blackJack= false;
				String ans;
		
		// print initial hands
		System.out.println("Cards are dealt\n");
		one.printHand(true);
		System.out.println("total for player: " +one.getHandSum());
		dealer.printHand(false);
		System.out.println("\n");
		if (one.getHandSum() == 21) {
			System.out.println("***************");
			System.out.println("***BLACKJACK***");
			System.out.println("***************");
			oneDone = true;
			dealerDone = true;
			//blackJack = true;
			int bj=22;
			bj=dealer.getHandSum();
		
			
			
		}
		
		
		
		while(!oneDone ) {
			
			//player´s turn
			if (!oneDone) {
				
				System.out.println("Hit or Stay? (Enter H or S): " );
				ans = sc.next();
				System.out.println();
				
				//if the player hits
				if (ans.compareToIgnoreCase("H") == 0) {
					
					//add next card in the deck and store whether player is busted
					oneDone = !one.addCard(theDeck.dealNextCard());
					
					one.printHand(true);
					System.out.println("total for player: " +one.getHandSum());
					
					if (one.getHandSum() > 21) {
						System.out.println("<<<<<<BUSTED>>>>>>");
						dealerDone = true;
					}
					if (one.getHandSum() == 21) {
						System.out.println("Congratulations!!! 21");
						oneDone = true;
					}
					
				} else if (ans.compareToIgnoreCase("S") == 0){
					
					oneDone = true;
				} else {
					System.err.println("input wrong, try again ...push a button ");
					
				}
					
				
			}
			System.out.println();
			
		}
		dealer.printHand(true);
		
		while(!dealerDone) {
			
			//dealer´s turn
			if (!dealerDone) {
				
				
				if (dealer.getHandSum()<one.getHandSum() && (one.getHandSum()>=17 && one.getHandSum()<22)) {
					System.out.println("The dealer hits\n");
					dealerDone = !dealer.addCard(theDeck.dealNextCard());
					
					dealer.printHand(true);
					System.out.println("total for dealer: " +dealer.getHandSum());
					
					if (dealer.getHandSum() < 17) {
						System.out.println("The dealer hits\n");
						dealerDone = !dealer.addCard(theDeck.dealNextCard());
						dealer.printHand(true);
						System.out.println("total: " +dealer.getHandSum());
						
					}
				} else {
					System.out.println("The dealer stays\n");
					dealerDone = true;
					System.out.println("total for dealer: " +dealer.getHandSum());
				}
			}
			System.out.println();
		}
		
	
		
		//print final hands
		one.printHand(true);
		dealer.printHand(true);
		
		int oneSum = one.getHandSum();
		int dealerSum = dealer.getHandSum();
		
	
		
		if ((oneSum > dealerSum && oneSum <= 21 || dealerSum > 21) ) {
			System.out.println("Total for player: " + one.getHandSum());
			System.out.println("You win " +2*bet );
			
			
			money = left + 2*bet;
			
			System.out.println("Your actual stack is: " +money);
		
		
			
		
			}
			
			
			
		 else {
			System.out.println("Total for dealer: " + dealer.getHandSum());
			System.out.println("Dealer wins ");
			money = money - bet;
			System.out.println("Your actual stack is: " +money);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Play again? y/n");
		ans2 = play.next();
		
		if (ans2.compareToIgnoreCase("Y") == 0) {
			playAgain = true;
			one.emptyHand();
			dealer.emptyHand();
			bet = 0;
		
			
		} else if  (ans2.compareToIgnoreCase("N") == 0) {
			playAgain = false;
			sc.close();
			play.close();
			dollar.close();
			
			System.exit(0);
		}
		
		}
		
	}

}
