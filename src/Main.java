import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		boolean run = true;
		boolean inputNeeded = true;
		boolean needsAmount = true;

		while (run) {

			int cardAmount = 0;

			while (inputNeeded) {
				try {

					Scanner inputInt = new Scanner(System.in);

					while (needsAmount) {
						System.out.println("How many cards would you like to pull?");
						cardAmount = inputInt.nextInt();
						
						if (cardAmount <= TarotCard.LIMIT) {
							needsAmount = false;
						} else {
							System.out.println();
							System.out.println("Oops! There's not that many cards in the deck.");
						}
					}

					inputInt.close();
					inputNeeded = false;
				}
				catch (Exception e) {

					Scanner inputString = new Scanner(System.in);

					System.out.println();
					System.out.println("An error occurred! If you want to try again, press y:");

					boolean willContinue = inputString.nextLine().replaceAll("\\s", "").toLowerCase().equals("y");
					System.out.println();

					if (!willContinue) {
						inputNeeded = false;
						inputString.close();
					}
				}
			}

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
		}

		System.out.println();
		System.out.println("Goodbye!");
	}

}