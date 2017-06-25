package edu.uark.uarkregisterapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

import edu.uark.uarkregisterapp.models.api.Transaction;
import edu.uark.uarkregisterapp.models.api.enums.TransactionType;
import edu.uark.uarkregisterapp.models.api.services.TransactionService;

/**
 * Created by me or you on 6/25/2017.
 */

public class BeginTransaction extends AppCompatActivity{
    private static final String TAG = BeginTransaction.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_transaction);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    public void saveButtonClick(View view){
        (new CreateTransactionTask()).execute(
                (new Transaction()).
                        setId(UUID.randomUUID()).
                        setCashierId(this.getCashierIdText().getText().toString()).
                        setReferenceId(new UUID(0,0)).
                        setTotalAmount(Integer.parseInt(this.getTotalAmountText().getText().toString())).
                        setTransactionType(TransactionType.SALE)
        );
    }



    private class CreateTransactionTask extends AsyncTask< Transaction, Void, Transaction> {
        @Override
        protected Transaction doInBackground(Transaction... transaction){
            Log.d(TAG,"Info sent cashier id: " + transaction[0].getCashierId());
            return (new TransactionService()).putTransaction(transaction[0]);
        }

        protected void onPostExecute(Transaction transaction){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

    }

    private EditText getCashierIdText() {
        return (EditText) this.findViewById(R.id.edit_text_transaction_create_cashier_id);
    }

    private EditText getTotalAmountText() {
        return  (EditText) this.findViewById(R.id.edit_text_transaction_create_cashier_id);
    }


}
