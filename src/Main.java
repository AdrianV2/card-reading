import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static BufferedReader USERINPUT = new BufferedReader(new InputStreamReader(System.in));

	
	public static void main(String[] args) throws IOException {

		boolean run = true;
		boolean needsDeck = true;

		while (run) {

			int cardAmount = 0;
			String menuInput = "";

			//MENU OPTIONS FOR DECKS
			while (needsDeck) {
				System.out.println("Which deck would you like to use?");
				System.out.println("A. Tarot Deck");
				System.out.println("B. Green Witch Deck");
				System.out.println("C. Quit");

				menuInput = USERINPUT.readLine().replaceAll("\\s", "").replaceAll("\\.", "").toLowerCase();
				System.out.println();


				switch(menuInput) {

				//TAROT
				case "a":
					cardAmount = getCardAmount(TarotCard.LIMIT, USERINPUT);
					needsDeck = false;

					if (cardAmount == 0) run = false;
					else {

						TarotCard[] cardSpread = TarotCard.createSpread(cardAmount, true);

						System.out.println();
						System.out.println("Here is your card spread:");
						System.out.println();


						for (TarotCard t : cardSpread) {

							System.out.println(t.getName());

						}

					}
					break;

				//GREEN WITCH
				case "b":
					cardAmount = getCardAmount(GreenWitchCard.LIMIT, USERINPUT);
					needsDeck = false;

					if (cardAmount == 0) run = false;
					else {

						GreenWitchCard[] cardSpread = GreenWitchCard.createSpread(cardAmount);

						System.out.println();
						System.out.println("Here is your card spread:");
						System.out.println();


						for (GreenWitchCard g : cardSpread) {

							System.out.println(g.getName());

						}

					}
					break;

				//CLOSE PROGRAM
				case "c":
					needsDeck = false;
					run = false;
					break;

				//INVALID INPUT
				default:
					System.out.println();
					System.out.println("That's not an option.");
				}
			}

			//ASK TO CONTINUE USING PROGRAM
			if (run) {
				System.out.println();
				System.out.println("If you want to draw more cards then press y:");
				if (!USERINPUT.readLine().replaceAll("\\s", "").toLowerCase().equals("y")) run = false;
				else needsDeck = true;
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("Goodbye!");
	}


	//RETURNS NUMBER INPUT FROM ASKING USER HOW MANY CARDS
	public static int getCardAmount(int limit, BufferedReader br) throws IOException {

		boolean inputNeeded = true;
		boolean needsAmount = true;
		int inputAmount = 0;

		while (inputNeeded) {

			//PROTECTS AGAINST INPUT ERROR
			try {

				while (needsAmount) {

					//ASKS USER FOR AMOUNT
					System.out.println("How many cards would you like to pull?");
					inputAmount = Integer.parseInt(USERINPUT.readLine());

					//CHECKS IF DECK HAS ENOUGH
					if (inputAmount <= limit) {
						needsAmount = false;
					} else {
						System.out.println();
						System.out.println("Oops! There's not that many cards in the deck.");
					}
				}
				
				inputNeeded = false;
			}
			//ERROR FOUND WITH INPUT
			catch (Exception e) {

				System.out.println();
				System.out.println("An error occurred! If you want to try again then press y:");

				System.out.println();

				//USER DOESN'T WANT TO CONTINUE
				if (!USERINPUT.readLine().replaceAll("\\s", "").toLowerCase().equals("y")) {
					inputNeeded = false;
				}

				System.out.println();
			}
		}

		return inputAmount;
	}
}