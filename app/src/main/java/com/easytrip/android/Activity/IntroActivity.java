package com.easytrip.android.Activity;

import android.content.Intent;
import android.os.Bundle;


import com.easytrip.android.R;
import com.easytrip.android.databinding.ActivityIntroBinding;

public class IntroActivity extends ProfileActivity {
    ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.introBtn.setOnClickListener(v -> {
            startActivity(new Intent(IntroActivity.this, MainActivity.class));
            finish();
        });
    }
}