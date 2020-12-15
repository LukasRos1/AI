package knapsack;

import java.util.LinkedList;

public class GreedyAlgorithm {
	private Knapsack[] bagList;
	private LinkedList<Item> unusedItemsList = new LinkedList<>();
	private int totalValue;

	public GreedyAlgorithm(Knapsack[] bagList, LinkedList<Item> itemList) {
		this.bagList = bagList;
		//Collections.sort(itemList, Comparator.comparingDouble(obj -> ((Item) obj).getRelativeValue()).reversed());
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
		
		if (itemList.size() == 1) {
			Item item = itemList.get(0);
			int index = getBestFit(item.getWeight());
			if (index >= 0) {
				System.out.println("Adding last item of list, with weight " + item.getWeight() + " to bag " + index);
				bagList[index].addItem(item);
				totalValue+=item.getValue();
				System.out.println("Bag capacity: " + bagList[index].getCapacity());
			} else {
				System.out.println("No room for last item");
			}	
			itemList.remove(0);
			unusedItemsList.add(item);
			
			printBags();
			return;
		}
		
		if (itemList.size() > 1) {
			itemOne = itemList.get(0);
			itemTwo = itemList.get(1);
			System.out.println("Retrieving items: " + itemOne.getItemID() + " (Value: " + itemOne.getRelativeValue() + ") and " + itemTwo.getItemID() + " (Value: " + itemTwo.getRelativeValue() + ")");
		}
		
		if (itemOne.getRelativeValue() >= itemTwo.getRelativeValue()) {
			int index = getBestFit(itemOne.getWeight());
			if (index >= 0) {
				System.out.println("Adding first item with weight " + itemOne.getWeight() + " to bag " + index);
				bagList[index].addItem(itemOne);
				totalValue+=itemOne.getValue();
				System.out.println("Bag capacity: " + bagList[index].getCapacity());
			} else {
				System.out.println("Item does not fit in any of the bags, moving onto next item.");
				printBags();
			}
			itemList.remove(0);
			unusedItemsList.add(itemOne);
			
			fillBags(bagList, itemList);
		} else {
			int index = getBestFit(itemTwo.getWeight());
			if (index >= 0) {
				System.out.println("Adding second item with weight " + itemTwo.getWeight() + " to bag " + index);
				bagList[index].addItem(itemTwo);
				totalValue+=itemTwo.getValue();
				System.out.println("Bag capacity: " + bagList[index].getCapacity());
			} else {
				System.out.println("Item does not fit in any of the bags, moving onto next item");
				printBags();
			}
			itemList.remove(1);
			unusedItemsList.add(itemTwo);
			
			fillBags(bagList, itemList);
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
			System.out.println("Bag " + i + " capacity: " + bagList[i].getCapacity() + "/" + bagList[i].getBagSize());
		}
		System.out.println("Total value of bags: " + totalValue);
	}
	
	public LinkedList<Item> getUnusedItems() {
		return this.unusedItemsList;
	}

}
