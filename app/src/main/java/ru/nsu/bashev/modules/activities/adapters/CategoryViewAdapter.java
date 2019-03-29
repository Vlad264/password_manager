package ru.nsu.bashev.modules.activities.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Category;

public class CategoryViewAdapter extends RecyclerView.Adapter<CategoryViewAdapter.CategoryHolder> {

    private List<Category> categories;
    private List<Category> selectedCategories;

    public CategoryViewAdapter(List<Category> categories, List<Category> selectedCategories) {
        this.categories = categories;
        this.selectedCategories = selectedCategories;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category, viewGroup, false);
        return new CategoryHolder(view);

    }

    @Override
    public void onBindViewHolder(CategoryHolder categoryHolder, int i) {
        categoryHolder.nameTextView.setText(categories.get(i).getName());
        categoryHolder.selectButton.setChecked(selectedCategories.contains(categories.get(i)));
        categoryHolder.selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handle
            }
        });
        categoryHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryHolder extends RecyclerView.ViewHolder {

        public RadioButton selectButton;
        public TextView nameTextView;
        public ImageButton removeButton;

        public CategoryHolder(View itemView) {
            super(itemView);
            selectButton = itemView.findViewById(R.id.categorySelectRadioButton);
            nameTextView = itemView.findViewById(R.id.categoryNameTextView);
            removeButton = itemView.findViewById(R.id.categoryRemoveImageButton);
        }
    }
}
