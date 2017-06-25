package edu.uark.uarkregisterapp.models.api.enums;

/**
 * Created by me or you on 6/25/2017.
 */
import java.util.HashMap;
import java.util.Map;

import edu.uark.uarkregisterapp.models.api.interfaces.PathElementInterface;

public enum TransactionApiMethod implements PathElementInterface {
    NONE(""),
    TRANSACTION("transaction"),
    SALE("sale"),
    RETURN("return");

    @Override
    public String getPathValue() {
        return value;
    }
    public static TransactionApiMethod map(String key) {
        if (valueMap == null) {
            valueMap = new HashMap<>();
            for (TransactionApiMethod value : TransactionApiMethod.values()) {
                valueMap.put(value.getPathValue(), value);
            }
        }
        return (valueMap.containsKey(key) ? valueMap.get(key) : TransactionApiMethod.NONE);
   }

    private String value;
    private static Map<String, TransactionApiMethod> valueMap = null;
    TransactionApiMethod(String value) {
        this.value = value;
    }
}