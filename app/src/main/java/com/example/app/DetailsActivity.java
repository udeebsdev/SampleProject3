package com.example.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by udeebsdev on 2/14/14.
 */
public class DetailsActivity extends Activity {
    Contact currentContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);

        TextView textview = (TextView)this.findViewById(R.id.detailName);
        this.currentContact = (Contact) getIntent().getSerializableExtra("contact");
        textview.setText(currentContact.name);

    }

    public void  editClicked(View view){
        View rootView = view;

        if(rootView == null){
            rootView = getLayoutInflater().inflate(R.layout.details_layout,null);
        }

        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("contact", currentContact);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if(resultCode == RESULT_OK){
                this.currentContact = (Contact) data.getSerializableExtra("contact");
                TextView textview = (TextView)this.findViewById(R.id.detailName);
                textview.setText(currentContact.name);

                setResult(RESULT_OK, data);
            }
        }
    }

    public void backButtonClicked(View view)
    {
        getIntent().putExtra("contact", this.currentContact);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}
