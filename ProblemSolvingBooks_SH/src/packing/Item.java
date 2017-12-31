package packing;

public class Item {

	public String name;
	public int volume;
	public int priority;
	public Item[] nextItems;
	
	public Item(String name, int volume, int priority) {
		this.name = name;
		this.volume = volume;
		this.priority = priority;
		nextItems = new Item[2];
	}
	
	public void addBest(Item item) {
		if(nextItems[0] == null) nextItems[0] = item;
		else nextItems[1] = item;
	}
	
}
