package edu.uark.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionType {
	NOT_DEFINED(0),
	SALE(1),
	RETURN(2);
	
	private int value;
	private static Map< Integer, TransactionType> valueMap = null;
	
	public int getValue() {	return value; }
	
	private TransactionType(int value){  this.value = value;  }
	
	public static TransactionType map(int key){
			if(valueMap == null){
			valueMap = new HashMap<Integer, TransactionType>();
				for (TransactionType status: TransactionType.values()){
				valueMap.put(status.getValue(), status);
				}
			}
		return (valueMap.containsKey(key) ? valueMap.get(key) : TransactionType.NOT_DEFINED);
	}

	
}
