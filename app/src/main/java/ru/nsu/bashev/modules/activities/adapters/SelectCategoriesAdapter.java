package ru.nsu.bashev.modules.activities.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Category;

public class SelectCategoriesAdapter extends RecyclerView.Adapter<SelectCategoriesAdapter.CategoryHolder> {

    private List<Category> categories;
    private List<Category> selectedCategories;

    public SelectCategoriesAdapter(List<Category> categories, List<Category> selectedCategories) {
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
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryHolder extends RecyclerView.ViewHolder {

        public RadioButton selectButton;
        public TextView nameTextView;

        public CategoryHolder(View itemView) {
            super(itemView);
            selectButton = itemView.findViewById(R.id.categorySelectRadioButton);
            nameTextView = itemView.findViewById(R.id.categoryNameTextView);
            itemView.findViewById(R.id.categoryRemoveImageButton).setVisibility(View.GONE);
        }
    }
}
