package com.gmail.takashi316.DescisionTree;

import java.util.ArrayList;

public class Items extends ArrayList<Item> {
	public Items(int[][] items) {
		for (int i = 0; i < items.length; ++i) {
			Item item = new Item(items[i]);
			this.add(item);
		}
	}

	public Classes getClasses() {
		Classes classes = new Classes();
		for (Item i : this) {
			classes.add(i.classId);
		}
		return classes;
	}

}