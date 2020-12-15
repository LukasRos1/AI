package knapsack;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class GreedyAlgorithm {
	private Knapsack[] bagList;
	private LinkedList<Item> unusedItemsList = new LinkedList<>();
	private int totalValue;

	public GreedyAlgorithm(Knapsack[] bagList, LinkedList<Item> itemList) {
		this.bagList = bagList;
		Collections.sort(itemList, Comparator.comparingDouble(obj -> ((Item) obj).getRelativeValue()).reversed());
		fillBags(bagList, itemList);
	}
	
	public void fillBags(Knapsack[] bagList, LinkedList<Item> itemList) {
		System.out.println();
		Item itemOne = null;
		Item itemTwo = null;
		
		if (itemList.size() == 0) {
			System.out.println("No more items.");
			return;
		}
		
		if (itemList.size() >= 0) {
			Item item = itemList.get(0);
			int index = getBestFit(item.getWeight());
			if (index >= 0) {
				System.out.println("Adding item with weight " + item.getWeight() + " to bag " + index);
				bagList[index].addItem(item);
				totalValue+=item.getValue();
				System.out.println("Bag capacity: " + bagList[index].getCapacity());
			} else {
				System.out.println("No room for last item");
				unusedItemsList.add(item);
			}	
			itemList.remove(0);
			
			printBags();
			fillBags(bagList, itemList);
			return;
		}
		
		
	}

	public int getBestFit(double weight) {
		double bestFit = Double.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < bagList.length; i++) {
			if ((bagList[i].getCapacity() - weight >= 0) && (bagList[i].getCapacity() < bestFit)) {
				bestFit = bagList[i].getCapacity() - weight;
				index = i;
			}
		}
		return index;
	}
	
	private void printBags() {
		for (int i = 0; i < bagList.length; i++) {
			System.out.println("Bag " + i + " free room: " + bagList[i].getCapacity() + "/" + bagList[i].getBagSize());
		}
		System.out.println("Total value of bags: " + totalValue);
	}
	
	public LinkedList<Item> getUnusedItems() {
		return this.unusedItemsList;
	}

}
