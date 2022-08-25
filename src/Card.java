public class Card {

	//SPECIFIC TO EACH DECK
	public static int LIMIT = 0;
	public static String[] CARDNAMES = new String[LIMIT];
	
	//BASIC INFORMATION FOR EACH CARD
	protected String name;
	protected int cardID;
	protected boolean reversed = false;
	
	
	//CONSTRUCTORS
	public Card(boolean useReversed, int limit, String[] cardNames) {
		
		cardID = (int)Math.floor(Math.random() * limit);
		name = cardNames[cardID];
		
		if (useReversed) {
			reversed = ((int)Math.floor(Math.random() * 2)) == 0;
			if (reversed) name += " Reversed";
		}
	}
	
	public Card(int limit, String[] cardNames) {
		this(false, limit, cardNames);
	}
	
	
	//GETTERS
	protected String getName() {
		return name;
	}
	
	protected int getCardID() {
		return cardID;
	}

	protected boolean getReversed() {
		return reversed;
	}
	
}
