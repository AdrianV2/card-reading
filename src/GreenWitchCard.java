import java.util.HashSet;

public class GreenWitchCard extends Card {

	public static int LIMIT = 44;
	public static String[] CARDNAMES = new String[]{
			"Carrot", "Pea", "Cos Lettuce", "Cucumber", "Potato", "Broccoli", "Beetroot", "Kent Pumpkin", "Onion",
			"Sweet Corn", "Cauliflower", "Sorrel", "Thyme", "Chives", "Majoram", "Rosemary", "Tarragon", "Chilli",
			"Fennel", "Peppermint", "Basil", "Bay", "Grape", "Strawberry", "Lemon", "Apple", "Banana", "Orange",
			"Watermelon", "Tomato", "Lime", "Fig", "Black Mulberry", "Pansy", "Stock", "Pink Rose", "Geranium",
			"Daffodil", "Chrysanthemum", "Marigold", "Snapdragon", "Dahlia", "Violet", "Nasturtium"
	};
	
	
	public GreenWitchCard() {
		
		super(false, LIMIT, CARDNAMES);
	}

	
	public static GreenWitchCard[] createSpread(int amount) {

		GreenWitchCard[] cardSpread = new GreenWitchCard[amount];
		HashSet<Integer> cardIDSet = new HashSet<Integer>();

		for (int i = 0; i < amount; i++) {

			GreenWitchCard toAdd = new GreenWitchCard();
			
			while(!cardIDSet.add(toAdd.getCardID())) {
				toAdd = new GreenWitchCard();
			}
			
			cardSpread[i] = toAdd;
		}
		
		return cardSpread;
	}
}
