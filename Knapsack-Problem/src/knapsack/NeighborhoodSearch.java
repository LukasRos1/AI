package knapsack;

import java.util.LinkedList;

public class NeighborhoodSearch {

	private Knapsack[] bagList;

	public NeighborhoodSearch (Knapsack[] bagList, LinkedList<Item> itemList, LinkedList<Item> unusedItemsList) {
		//GreedyAlgorithm greedy = new GreedyAlgorithm(bagList, itemList);
		//Collections.sort(itemList, Comparator.comparingDouble(obj -> ((Item) obj).getRelativeValue()).reversed());
		//greedy.getUnusedItems();
		System.out.println("FROM algopalgo:");
		System.out.println(bagList[0].getCapacity());
	}

}
