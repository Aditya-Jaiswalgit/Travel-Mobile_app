package com.easytrip.android.Activity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.Glide;
import com.easytrip.android.Adapter.PicListAdapter;
import com.easytrip.android.Model.ItemModel;
import com.easytrip.android.R;
import com.easytrip.android.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private ItemModel object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom);
            return insets;
        });



        getIntentExtra();
        setVariable();
    }


    private void setVariable() {
        if (object == null) {
            finish();
            return;
        }

        binding.titleTxtDetail.setText(object.getTitle());
        binding.addressTxtDetail.setText(object.getAddress());
        binding.priceTxtDetail.setText("$" + object.getPrice());
        binding.distanceTxtDetail.setText(object.getDistance());
        binding.backBtn.setOnClickListener(v -> finish());
        binding.durationTxtDetail.setText(object.getDuration());
        binding.discriptionTxtDetail.setText(object.getDescription());
        binding.bednum.setText(String.valueOf(object.getBed()));
        binding.ratingTxt.setText(object.getScore() + " Rating");
        binding.ratingBar.setRating((float) object.getScore());





        if (object.getPic() != null && !object.getPic().isEmpty()) {
            Glide.with(this)
                    .load(object.getPic().get(0))
                    .into(binding.picDetail);


            if (binding.picList != null) {
                binding.picList.setAdapter(new PicListAdapter(object.getPic(), binding.picDetail));
                binding.picList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            }
        }
    }



    private void getIntentExtra() {
        try {
            object = (ItemModel) getIntent().getParcelableExtra("object");
            if (object == null) {
                finish();
            }
        } catch (Exception e) {
            finish();
        }
    }
}