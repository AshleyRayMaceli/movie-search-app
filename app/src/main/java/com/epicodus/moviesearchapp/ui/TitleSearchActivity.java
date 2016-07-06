package com.epicodus.moviesearchapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.moviesearchapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TitleSearchActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.titleEntryEditText) EditText mTitleEntryEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_search);
        ButterKnife.bind(this);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSearchButton) {
            String title = mTitleEntryEditText.getText().toString();
            Intent intent = new Intent(TitleSearchActivity.this, TitleResultsActivity.class);
            intent.putExtra("title", title);
            startActivity(intent);
        }
    }
}
