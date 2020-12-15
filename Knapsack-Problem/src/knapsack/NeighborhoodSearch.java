package knapsack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class NeighborhoodSearch {

	private Knapsack[] bagList;
	private int iterations = 0;

	public NeighborhoodSearch (Knapsack[] bagList, LinkedList<Item> itemList, LinkedList<Item> unusedItemsList) {
		//GreedyAlgorithm greedy = new GreedyAlgorithm(bagList, itemList);
		//Collections.sort(itemList, Comparator.comparingDouble(obj -> ((Item) obj).getRelativeValue()).reversed());
		//greedy.getUnusedItems();
		this.bagList = bagList;
		System.out.println("FROM algopalgo:");
		System.out.println(bagList[0].getCapacity());
		System.out.println("unused items: " + unusedItemsList.size());
		neighborhoodSearch(bagList, 0);
		//System.out.println(unusedItemsList.get(0).getRelativeValue());
	}
	
	/**
	 * Moves around items in bags to fill as many bags as possible, allowing for more items in bags that is freed up
	 */
	public void neighborhoodSearch(Knapsack[] bagList, int iterations) {
		Arrays.sort(bagList, (a,b) -> Integer.compare(b.getCapacity(), a.getCapacity()));
		int swaps = 0;
		
		if (iterations >= 10) {
			return;
		}
		

		
		
		//Start with bags with highest capacity and see if swaps between other bags can be made 
		
		
		for (int i = 0; i < bagList.length; i++) {
			LinkedList<Item> firstBagItems = bagList[i].getBagItems();
			
			for (int j = 0; j < bagList.length; j++) {
				if (bagList[i] != bagList[j]) { //See if its not the same bag
					LinkedList<Item> secondBagItems = bagList[j].getBagItems();
					
					//For every item, see if it can be swapped with another bag's that results in higher available capacity
					for (int y = 0; y < firstBagItems.size(); y++) {
						Item item = firstBagItems.get(y);
						for (int z = 0; z < secondBagItems.size(); z++) {
							Item itemTwo = secondBagItems.get(z);
							if (itemTwo) {
								
							}
						}
					}
				}
			}
		}
		
		//After the swapping process is done we see if we can add more items to any of the bags
		
		System.out.println("New bag value:");
		printBags();
		//Lastly we recursively call the function again to see if it can be optimized further
		//neighborhoodSearch(bagList, iterations++);
	}
	
	public int getTotalBagValue(Knapsack[] bagList) {
		int totalValue = 0;
		for (int i = 0; i < bagList.length; i++) {
			LinkedList<Item> bagItems = bagList[i].getBagItems();
			for (int j = 0; j < bagItems.size(); j++) {
				totalValue+=bagItems.get(j).getValue();
			}
		}
		return totalValue;
	}

	private void printBags() {
		int totalValue = 0;
		for (int i = 0; i < bagList.length; i++) {
			System.out.println("Bag " + i + " free room: " + bagList[i].getCapacity() + "/" + bagList[i].getBagSize());
			totalValue+=bagList[i].getBagValue();
		}
		System.out.println("Total value of bags: " + totalValue);
	}
	
	private void compact() {
		//First we check if we can compact the bags by moving items from highest capacity available to other bags
		//E.g. Bag1: 4/20 room & Bag2: 2/20 would turn into 6/20 for bag1 and 0/20 for bag 2, given that bag2 had an item of weight 2 
		LinkedList<Item> biggestCapacityBagItems = bagList[0].getBagItems();
		for (int i = 0; i < biggestCapacityBagItems.size(); i++) {
			Item item = biggestCapacityBagItems.get(i);
			for (int j = 1; j < bagList.length; j++) {
				if (item.getWeight() <= bagList[j].getCapacity()) {
					bagList[0].removeItem(item);
					bagList[j].addItem(item);
					System.out.println("Item has been moved to compact");
					printBags();
				}
			}
		}
	}
}
