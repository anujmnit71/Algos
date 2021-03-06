package com.amazon.dp;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	/**
	 * with given v1 v2 v3.....Vn coins make a sum/change of P where v1 = 1
	 * C(P) = min i 1->n {C(P-vi} +1
	 */
	static int P =15;
	int[] coins = {1,5};
	Map<Integer,Integer> result = new HashMap<Integer,Integer>();
	public static void main(String[] args) {
		System.out.println(new CoinChange().change(P));
	}
	public int change(int changeP){
		if(result.get(changeP)!=null) return result.get(changeP);
		System.out.println("called C("+changeP+")");
		if(changeP==0) return 0;
		int min = Integer.MAX_VALUE;
		for(int i =0;i<=coins.length-1;i++){
			int changeVal = changeP-coins[i];
			if(changeVal < 0 ) continue;
			if (!result.containsKey(changeVal)) result.put(changeVal, change(changeVal) );
			System.out.println(String.format("For %s calculated C(%s)=%s",changeP,changeVal, result.get(changeVal)));
			min = Math.min(min,result.get(changeVal));
		}
		return min+1;
	}
}
