package com.gmail.takashi316.DescisionTree;

public class DescitionTree {

	public static void main(String[] args) {
		int x[][] = { { 1, 2, 3, 1 }, { 1, 3, 5, 3 }, { 1, 3, 3, 2 },
				{ 1, 3, 3, 4 }, { 1, 1, 3, 5 }, { 1, 0, 3, 6 }, { 1, 1, 3, 5 } };
		Items items = new Items(x);
		System.out.println(items.getClasses().getEntropy());
		DividedItems divided_items = new DividedItems(items, 1, 2);
		System.out.println("largerOrEqualItems "
				+ divided_items.largerOrEqualItems);
		System.out.println("smallerItems " + divided_items.smallerItems);
		System.out.println("entropyBeforeDivision "
				+ divided_items.entropyBeforeDivision);
		System.out.println("entropyOfLargerOrEqualItems "
				+ divided_items.entropyOfLargerOrEqualItems);
		System.out.println("entropyOfSmallerItems "
				+ divided_items.entropyOfSmallerItems);
		System.out.println("entropyAfterDivision "
				+ divided_items.entropyAfterDivision);
		System.out.println(divided_items.entropyAfterDivision
				- divided_items.entropyBeforeDivision);
		System.out.println(divided_items.entropyGain);
	}
}
