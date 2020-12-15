package knapsack;
import java.util.LinkedList;

public class Knapsack {
	private LinkedList<Item> knapsack;
	private int capacity;
	private int bagSize;
	private int bagID;
	
	public Knapsack(int capacity, int bagID) {
		this.capacity = capacity;
		this.bagID = bagID;
		this.bagSize = capacity;
		knapsack = new LinkedList<Item>();
	}
		
	public int getCapacity() {
		return capacity;
	}
	
	public int getBagSize() {
		return bagSize;
	}

	public int getBagID() {
		return bagID;
	}
	
	public LinkedList<Item> getBagItems(){
		return knapsack;
	}

	public void addItem(Item item) {
		if (this.capacity-item.getWeight() >= 0) {
			knapsack.add(item);
			this.capacity -= item.getWeight();
		}
	}
	
	public void removeItem(Item item) {
		knapsack.remove(item);
		this.capacity += item.getWeight();
	}

}
