package edu.uark.uarkregisterapp.models.api.services;

import android.util.Log;

import org.json.JSONObject;

import edu.uark.uarkregisterapp.models.api.Transaction;
import edu.uark.uarkregisterapp.models.api.enums.ApiLevel;
import edu.uark.uarkregisterapp.models.api.enums.TransactionApiMethod;
import edu.uark.uarkregisterapp.models.api.interfaces.PathElementInterface;

/**
 * Created by me or you on 6/25/2017.
 */


public class TransactionService extends BaseRemoteService {
    private static final String TAG = TransactionService.class.getSimpleName();
    public Transaction putTransaction(Transaction transaction) {
        JSONObject rawJsonObject = this.putSingle(
                (new PathElementInterface[]{ TransactionApiMethod.TRANSACTION , ApiLevel.ONE,TransactionApiMethod.SALE }), transaction.convertToJson()
        );

        if (rawJsonObject != null) {
            return (new Transaction()).loadFromJson(rawJsonObject);

        } else {
            Log.d(TAG,"There is an UNKNOWN ERROR");
            return null;
        }
    }

}