package com.easytrip.android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.easytrip.android.Model.CategoryModel;
import com.easytrip.android.databinding.ViewholdCategoryBinding;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {
    private final List<CategoryModel> items;
    private Context context;

    public CategoryAdapter(List<CategoryModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhold_category,parent,false);
//        return new Viewholder(itemView); this code in old version of ui design
        context = parent.getContext();
        ViewholdCategoryBinding binding = ViewholdCategoryBinding.inflate(LayoutInflater.from(context),parent,false);
        return new Viewholder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        CategoryModel item = items.get(position);
        holder.binding.title.setText(item.getName());
        Glide.with(context)
                .load(item.getImagePath())
                .into(holder.binding.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private final ViewholdCategoryBinding binding;
        public Viewholder(ViewholdCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
