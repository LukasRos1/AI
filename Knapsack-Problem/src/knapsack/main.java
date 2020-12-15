package knapsack;

import java.util.ArrayList;
import java.util.LinkedList;

public class main {
	
	public static void main(String[] args) {
		Knapsack[] bagList = new Knapsack[5];
		bagList[0] = new Knapsack(30, 1);
		bagList[1] = new Knapsack(20, 2);
		bagList[2] = new Knapsack(15, 3);
		bagList[3] = new Knapsack(10, 4);
		bagList[4] = new Knapsack(20, 5);


		LinkedList<Item> itemList = Item.initItemList();
		GreedyAlgorithm greedy = new GreedyAlgorithm(bagList, itemList);
		new NeighborhoodSearch(bagList, itemList, greedy.getUnusedItems());
	}

}
