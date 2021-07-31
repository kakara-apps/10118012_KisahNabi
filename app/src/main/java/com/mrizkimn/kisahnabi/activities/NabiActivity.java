package com.mrizkimn.kisahnabi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.mrizkimn.kisahnabi.R;

public class NabiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nabi);

        //hide the default action bar
        getSupportActionBar().hide();

        //receive data
        String name = getIntent().getExtras().getString("prophet_name");
        String description = getIntent().getExtras().getString("prophet_description");
        String age = getIntent().getExtras().getString("prophet_age");
        String life = getIntent().getExtras().getString("prophet_life");
        String birth = getIntent().getExtras().getString("prophet_birth");
        String img_url = getIntent().getExtras().getString("prophet_img");

        //ini views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.na_prophet_name);
        TextView tv_birth = findViewById(R.id.na_prophet_birth);
        TextView tv_age = findViewById(R.id.na_prophet_age);
        TextView tv_life = findViewById(R.id.na_prophet_life);
        TextView tv_description = findViewById(R.id.na_description);
        ImageView img = findViewById(R.id.na_thumbnail);

        // set to each view

        tv_name.setText(name);
        tv_birth.setText(birth);
        tv_description.setText(description);
        tv_age.setText(age);
        tv_life.setText(life);
        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        //set image using glide
        Glide.with(this).load(img_url).apply(requestOptions).into(img);
    }
}