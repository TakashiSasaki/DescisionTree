package com.gmail.takashi316.DescisionTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Items extends ArrayList<Item> {

	public Items() {
		super();
	}

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

	public ArrayList<Integer> getAttributeValues(int attribute) {
		Set<Integer> value_set = new HashSet<Integer>();
		for (int i = 0; i < this.size(); i++) {
			value_set.add(this.get(i).attributeValues[attribute]);
		}
		ArrayList<Integer> values = new ArrayList<Integer>(value_set);
		Collections.sort(values);
		return values;
	}

	public DividedItems divide(int attribute, int threshold) {
		return new DividedItems(this, attribute, threshold);
	}

	public ArrayList<DividedItems> divideAll() {
		assert(this.size()>0);
		ArrayList<DividedItems> aldi = new ArrayList<DividedItems>();
		for (int i = 0; i < this.get(0).attributeValues.length; i++) {
			ArrayList<Integer> attribute_values = this.getAttributeValues(i);
			for (int j = 0; j < attribute_values.size(); ++j) {
				int threshold = attribute_values.get(j);
				DividedItems di = new DividedItems(this, i, threshold);
				aldi.add(di);
				System.out.println("attribute=" + i + " threshold=" + threshold
						+ " entropyGain=" + di.entropyGain);
			}
		}
		Collections.sort(aldi, new DividedItemsComparator());
		return aldi;
	}

	public DividedItems divideAtMaxEntropyGain() {
		ArrayList<DividedItems> aldi = divideAll();
		return aldi.get(0);
	}

	public ArrayList<DividedItems> divideRecursively() {
		ArrayList<DividedItems> aldi = new ArrayList<DividedItems>();
		if (this.size() <= 1) {
			aldi.add(new DividedItems(this));
			return aldi;
		}
		DividedItems di = divideAtMaxEntropyGain();
		aldi.addAll(di.smallerItems.divideRecursively());
		aldi.addAll(di.largerOrEqualItems.divideRecursively());
		return aldi;
	}

	static public void main(String[] args) {
		int[][] x = { { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 2 }, { 5, 2 } };
		Items items = new Items(x);
		System.out.println(items.getAttributeValues(0));
		System.out.println(items.divideAtMaxEntropyGain());
		System.out.println(items.divideRecursively());
	}
}