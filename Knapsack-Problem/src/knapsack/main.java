package knapsack;

import java.util.ArrayList;
import java.util.LinkedList;

public class main {
	
	public static void main(String[] args) {
		Knapsack[] bagList = new Knapsack[4];
		bagList[0] = new Knapsack(40, 1);
		bagList[1] = new Knapsack(60, 2);
		bagList[2] = new Knapsack(40, 3);
		bagList[3] = new Knapsack(50, 4);


		LinkedList<Item> itemList = Item.initItemList();
		GreedyAlgorithm greedy = new GreedyAlgorithm(bagList, itemList);
		new NeighborhoodSearch(bagList, itemList, greedy.getUnusedItems());
	}

}
