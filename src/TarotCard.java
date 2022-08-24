import java.util.HashSet;

public final class TarotCard extends Card {
	
	public static int LIMIT = 78;
	public static String[] CARDNAMES = new String[]{
			"The Fool", "The Magician", "The High Priestess", "The Empress", "The Emperor",
			"The Hierophant", "The Lovers", "The Chariot", "Strength", "The Hermit", "Wheel of Fortune",
			"Justice", "The Hanged Man", "Death", "Temperance", "The Devil", "The Tower", "The Star",
			"The Moon", "The Sun", "Judgement", "The World", "Ace of Pentacles", "Two of Pentacles",
			"Three of Pentacles", "Four of Pentacles", "Five of Pentacles", "Six of Pentacles",
			"Seven of Pentacles", "Eight of Pentacles", "Nine of Pentacles", "Ten of Pentacles",
			"Page of Pentacles", "Knight of Pentacles", "Queen of Pentacles", "King of Pentacles",
			"Ace of Cups", "Two of Cups", "Three of Cups", "Four of Cups", "Five of Cups", "Six of Cups",
			"Seven of Cups", "Eight of Cups", "Nine of Cups", "Ten of Cups", "Page of Cups", "Knight of Cups",
			"Queen of Cups", "King of Cups", "Ace of Wands", "Two of Wands", "Three of Wands", "Four of Wands",
			"Five of Wands", "Six of Wands", "Seven of Wands", "Eight of Wands", "Nine of Wands", "Ten of Wands",
			"Page of Wands", "Knight of Wands", "Queen of Wands", "King of Wands", "Ace of Swords", "Two of Swords",
			"Three of Swords", "Four of Swords", "Five of Swords", "Six of Swords", "Seven of Swords", "Eight of Swords",
			"Nine of Swords", "Ten of Swords", "Page of Swords", "Knight of Swords", "Queen of Swords", "King of Swords"
	};

	
	public TarotCard(boolean useReversed) {
		
		super(useReversed, 78);
		name = CARDNAMES[cardID] + name;
	}

	public TarotCard() {
		this(false);
	}


	public static TarotCard[] createSpread(int amount, boolean useReversed) {

		TarotCard[] cardSpread = new TarotCard[amount];
		HashSet<Integer> cardIDSet = new HashSet<Integer>();

		for (int i = 0; i < amount; i++) {

			TarotCard toAdd = new TarotCard(useReversed);
			
			while(!cardIDSet.add(toAdd.getCardID())) {
				toAdd = new TarotCard(useReversed);
			}
			
			cardSpread[i] = toAdd;
		}
		
		return cardSpread;
	}
}
