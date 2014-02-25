package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_layout);

        Intent currentIntent = getIntent();
        Contact currentContact = (Contact) currentIntent.getSerializableExtra("contact");

        EditText editText = (EditText) this.findViewById(R.id.editText);
        editText.setText(currentContact.name);


    }

    public void saveClicked(View currView){
        Contact currentContact = (Contact) getIntent().getSerializableExtra("contact");

        EditText editText = (EditText) this.findViewById(R.id.editText);
        currentContact.setName(editText.getText().toString());

        getIntent().putExtra("contact", currentContact);
        setResult(RESULT_OK, getIntent());
        finish();
    }

    public void cancelClicked(View currView){
        Contact currentContact = (Contact) getIntent().getSerializableExtra("contact");
        getIntent().putExtra("contact", currentContact);
        setResult(RESULT_CANCELED, getIntent());
        finish();
    }
}
