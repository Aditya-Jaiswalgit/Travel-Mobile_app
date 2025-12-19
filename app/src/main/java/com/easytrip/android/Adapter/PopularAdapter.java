package com.easytrip.android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.easytrip.android.Activity.DetailActivity;
import com.easytrip.android.Model.ItemModel;
import com.easytrip.android.R;
import com.easytrip.android.databinding.ViewholderPopularBinding;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    ArrayList<ItemModel> items;
    Context context;
    ViewholderPopularBinding binding;

    public PopularAdapter(ArrayList<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderPopularBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new Viewholder(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        ItemModel item = items.get(position);
        if (item == null) {
            return;
        }

        holder.heartImage.setTag(false);

        Intent LikeIntent = new Intent(context, DetailActivity.class);


        holder.heartImage.setOnClickListener(v -> {
            boolean isLiked = (boolean) holder.heartImage.getTag();
            if (isLiked) {
                holder.heartImage.setImageResource(R.drawable.fav_icon);
                Toast.makeText(context, "Item Unliked", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Item Liked", Toast.LENGTH_SHORT).show();
                holder.heartImage.setImageResource(R.drawable.heart_fill_icon);
            }

            holder.heartImage.setTag(!isLiked);
        });


        binding.titleTxt.setText(item.getTitle());
        binding.priceTxt.setText("$"+item.getPrice());
        binding.addressTxt.setText(item.getAddress());
        binding.scoreTxt.setText(""+item.getScore());

        if (item.getPic() != null && !item.getPic().isEmpty()) {
            String firstImageUrl = item.getPic().get(0);
            Glide.with(context)
                    .load(firstImageUrl)
                    .into(binding.picPopular);
        }

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", item);
            context.startActivity(intent);
        });
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {

        ImageView heartImage;

        public Viewholder(ViewholderPopularBinding binding) {
            super(binding.getRoot());
            heartImage = binding.favBtn;
        }
    }
}
