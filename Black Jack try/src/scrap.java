
while(!oneDone || !dealerDone) {
			
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
					
				} else {
					oneDone = true;
				}
			}
			
			//dealer´s turn
			if (!dealerDone) {
				if (dealer.getHandSum() < 17) {
					System.out.println("The dealer hits\n");
					dealerDone = !dealer.addCard(theDeck.dealNextCard());
					dealer.printHand(false);
				} else {
					System.out.println("The dealer stays\n");
					dealerDone = true;
				}
			}
			System.out.println();
		}