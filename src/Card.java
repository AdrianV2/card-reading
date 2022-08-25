public class Card {

	public static int LIMIT = 0;
	public static String[] CARDNAMES = new String[LIMIT];
	
	
	protected String name;
	protected int cardID;
	protected boolean reversed = false;
	
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
	
	public String getName() {
		return name;
	}
	
	public int getCardID() {
		return cardID;
	}

	public boolean getReversed() {
		return reversed;
	}
	
}
