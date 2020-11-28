package com.adib.shopinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String MORE_ITEMS = "com.adib.shopinglist.extra.ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void selectItem(View view) {
        Intent return_items_intent = new Intent();

        switch (view.getId()){
            case R.id.button_cheese:
                return_items_intent.putExtra(MORE_ITEMS, "Cheese"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_rice:
                return_items_intent.putExtra(MORE_ITEMS, "Rice"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_apple:
                return_items_intent.putExtra(MORE_ITEMS, "Apple"); setResult(RESULT_OK, return_items_intent); finish();
                break;

            case R.id.button_milk:
                return_items_intent.putExtra(MORE_ITEMS, "Milk"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_eggs:
                return_items_intent.putExtra(MORE_ITEMS, "Eggs"); setResult(RESULT_OK, return_items_intent); finish();
                break;

            case R.id.button_wheat:
                return_items_intent.putExtra(MORE_ITEMS, "Wheat Flour"); setResult(RESULT_OK, return_items_intent); finish();
                break;

            case R.id.button_sugar:
                return_items_intent.putExtra(MORE_ITEMS, "Sugar"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_salt:
                return_items_intent.putExtra(MORE_ITEMS, "Salt"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_oil:
                return_items_intent.putExtra(MORE_ITEMS, "Oil"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            case R.id.button_Chocolate:
                return_items_intent.putExtra(MORE_ITEMS, "Chocolate"); setResult(RESULT_OK, return_items_intent); finish();
                break;
            default:
                Toast.makeText(SecondActivity.this, "There was an error", Toast.LENGTH_LONG).show();
                break;
        }

    }
}
