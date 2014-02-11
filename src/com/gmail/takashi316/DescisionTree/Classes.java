package com.gmail.takashi316.DescisionTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Classes extends ArrayList<Integer> {
	public double getEntropy() {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i = 0; i < this.size(); ++i) {
			Integer v = m.get(this.get(i));
			if (v == null) {
				m.put(this.get(i), new Integer(1));
			} else {
				v = v + 1;
			}
		}
		double entropy = 0;
		double denom = this.size();
		for (Iterator<Integer> i = m.keySet().iterator(); i.hasNext();) {
			Integer k = i.next();
			Integer v = m.get(k);
			System.out.println("" + k + " " + v);
			double p = v / denom;
			double e = p * Math.log(p) / Math.log(2);
			entropy += e;
		}
		return -entropy;
	}

	static public void main(String[] args) {
		Classes classes = new Classes();
		classes.add(1);
		classes.add(2);
		classes.add(3);
		classes.add(4);
		classes.add(5);
		classes.add(6);
		// it should be 2.58
		System.out.println("1,2,3,4,5,6 => " + classes.getEntropy());
	}
}