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
		itemList.add(new Item(1, 6, 4));
		itemList.add(new Item(2, 6, 8));
		itemList.add(new Item(3, 5, 6));
		itemList.add(new Item(4, 1, 1));
		itemList.add(new Item(5, 9, 6));
		itemList.add(new Item(6, 5, 7));
		itemList.add(new Item(7, 2, 3));
		itemList.add(new Item(8, 4, 2));
		itemList.add(new Item(9, 2, 1));
		itemList.add(new Item(10, 2, 5));
		itemList.add(new Item(11, 4, 5));
		itemList.add(new Item(12, 10, 7));
		itemList.add(new Item(13, 1, 3));
		itemList.add(new Item(14, 8, 8));
		itemList.add(new Item(15, 10, 4));
		itemList.add(new Item(16, 2, 4));
		itemList.add(new Item(17, 10, 14));
		itemList.add(new Item(18, 15, 14));
		itemList.add(new Item(19, 5, 9));
		itemList.add(new Item(20, 8, 10));
		itemList.add(new Item(21, 9, 4));
		itemList.add(new Item(22, 12, 20));
		itemList.add(new Item(23, 2, 10));
		itemList.add(new Item(24, 6, 5));
		itemList.add(new Item(25, 7, 20));
		itemList.add(new Item(26, 12, 15));
		itemList.add(new Item(27, 9, 10));

		return itemList;	
	}

	public double getRelativeValue() {
		return relativeValue;
	}
}
