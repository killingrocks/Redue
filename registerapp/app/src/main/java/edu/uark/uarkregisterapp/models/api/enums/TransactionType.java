package edu.uark.uarkregisterapp.models.api.enums;

/**
 * Created by me or you on 6/25/2017.
 */

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;


public enum TransactionType {
    NOT_DEFINED(0),
    SALE(1),
    RETURN(2);

    public static TransactionType mapValue(int key) {
        if (valueMap == null) {
            valueMap = new SparseArray<>();
            for (TransactionType status : TransactionType.values()) {
                valueMap.put(status.getValue(), status);
            }
        }
        return ((valueMap.indexOfKey(key) >= 0) ? valueMap.get(key) : TransactionType.NOT_DEFINED );
    }

        public static TransactionType mapName(String name) {
            if (nameMap == null) {
                nameMap = new HashMap<>();

                for (TransactionType status : TransactionType.values()) {
                    nameMap.put(status.name(), status);
                }
            }
            return (nameMap.containsKey(name) ? nameMap.get(name) : TransactionType.NOT_DEFINED );
        }

        private int value;
        private static Map<String, TransactionType> nameMap = null;
        private static SparseArray<TransactionType> valueMap = null;


    public int getValue() { return value;}
    private TransactionType(int value) { this.value = value; }
}
