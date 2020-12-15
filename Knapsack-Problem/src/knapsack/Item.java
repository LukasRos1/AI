package knapsack;

import java.util.ArrayList;
import java.util.LinkedList;

public class Item {
	
	private double weight;
	private double value;
	private int itemID;
	private double relativeValue;
	
	public Item(int itemID, double weight, double value) {
		this.itemID = itemID;
		this.weight = weight;
		this.value = value;
		this.relativeValue = value/weight;
		this.relativeValue = (double)Math.round(relativeValue * 100d) / 100d;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public double getWeight() {
		return weight;
	}

	public double getValue() {
		return value;
	}

	public int getItemID() {
		return itemID;
	}

	public static LinkedList<Item> initItemList() {
		LinkedList<Item> itemList = new LinkedList<>();
		//itemID, weight, value
		//itemList.add(new Item(1, 6, 4));
		itemList.add(new Item(2, 12, 16));
		itemList.add(new Item(3, 10, 12));
		//itemList.add(new Item(4, 1, 1));
		//itemList.add(new Item(5, 9, 6));
		itemList.add(new Item(6, 6, 14));
		itemList.add(new Item(7, 4, 7));
		itemList.add(new Item(8, 8, 5));
		itemList.add(new Item(9, 12, 8));
		itemList.add(new Item(10, 4, 10));
		itemList.add(new Item(11, 8, 10));
		itemList.add(new Item(12, 10, 7));
		itemList.add(new Item(13, 2, 6));
		itemList.add(new Item(14, 8, 5));
		itemList.add(new Item(15, 10, 6));
		itemList.add(new Item(16, 4, 8));
		itemList.add(new Item(17, 3, 28));
		itemList.add(new Item(18, 7, 14));
		itemList.add(new Item(19, 9, 18));
		itemList.add(new Item(20, 6, 20));
		itemList.add(new Item(21, 9, 6));
		itemList.add(new Item(22, 7, 26));
		itemList.add(new Item(23, 4, 20));
		itemList.add(new Item(24, 7, 6));
		itemList.add(new Item(25, 5, 40));
		itemList.add(new Item(26, 4, 30));
		itemList.add(new Item(27, 7, 20));

		return itemList;	
	}

	public double getRelativeValue() {
		return relativeValue;
	}
}
