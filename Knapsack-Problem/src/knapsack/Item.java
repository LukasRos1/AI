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
		itemList.add(new Item(1, 12, 4));
		itemList.add(new Item(2, 10, 8));
		itemList.add(new Item(3, 8, 12));
		itemList.add(new Item(4, 7, 1));
		itemList.add(new Item(5, 9, 6));
		itemList.add(new Item(6, 13, 14));
		itemList.add(new Item(7, 6, 7));
		itemList.add(new Item(8, 4, 5));
		itemList.add(new Item(9, 8, 8));
		itemList.add(new Item(10, 2, 6));
		itemList.add(new Item(11, 1, 3));
		itemList.add(new Item(12, 5, 7));
		itemList.add(new Item(13, 6, 3));
		itemList.add(new Item(14, 3, 5));
		itemList.add(new Item(15, 5, 6));
		itemList.add(new Item(16, 7, 4));
		itemList.add(new Item(17, 3, 13));
		itemList.add(new Item(18, 10, 5));
		itemList.add(new Item(19, 4, 9));
		itemList.add(new Item(20, 8, 20));
		itemList.add(new Item(21, 10, 6));
		itemList.add(new Item(22, 6, 13));
		itemList.add(new Item(23, 7, 10));
		itemList.add(new Item(24, 10, 6));
		itemList.add(new Item(25, 12, 15));
		itemList.add(new Item(26, 4, 4));
		itemList.add(new Item(27, 8, 12));
//		
		itemList.add(new Item(28, 8, 13));
		itemList.add(new Item(29, 5, 5));
		itemList.add(new Item(30, 8, 4));
		itemList.add(new Item(31, 2, 20));
		itemList.add(new Item(32, 6, 6));
		itemList.add(new Item(33, 7, 13));
		itemList.add(new Item(34, 3, 10));
		itemList.add(new Item(35, 8, 3));
		itemList.add(new Item(36, 2, 19));
//		itemList.add(new Item(37, 6, 4));
//		itemList.add(new Item(38, 8, 12));

		return itemList;	
	}

	public double getRelativeValue() {
		return relativeValue;
	}
}
