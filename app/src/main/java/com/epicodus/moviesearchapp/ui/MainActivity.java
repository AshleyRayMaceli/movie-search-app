package com.epicodus.moviesearchapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.epicodus.moviesearchapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.titleSearchButton) Button mTitleSearchButton;
    @Bind(R.id.ratingSearchButton) Button mRatingSearchButton;
    @Bind(R.id.releaseSearchButton) Button mReleaseSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mTitleSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mTitleSearchButton) {
            Intent intent = new Intent(MainActivity.this, TitleSearchActivity.class);
            startActivity(intent);
        }
    }
}

