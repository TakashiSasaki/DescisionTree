package com.gmail.takashi316.DescisionTree;

public class DescitionTree {

	public static void main(String[] args) {
		int x[][] = { { 1, 2, 3, 1 }, { 1, 3, 5, 3 }, { 1, 3, 3, 2 },
				{ 1, 3, 3, 4 }, { 1, 1, 3, 5 }, { 1, 0, 3, 6 } };
		Items items = new Items(x);
		System.out.println(items.getClasses().getEntropy());
		DividedItems divided_items = new DividedItems(items, 1, 2);
		System.out.println(divided_items.largerOrEqualItem);
		System.out.println(divided_items.smallerItem);
	}
}
