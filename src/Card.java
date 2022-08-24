public class Card {

	protected String name = "";
	protected int cardID = 0;
	protected boolean reversed = false;
	
	public Card(boolean useReversed, int limit) {
		
		this.cardID = (int)Math.floor(Math.random() * limit);
		if (useReversed) {
			reversed = ((int)Math.floor(Math.random() * 2)) == 0;
			if (reversed) name = " Reversed";
		}
	}
	
	public Card(int limit) {
		this(false, limit);
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
