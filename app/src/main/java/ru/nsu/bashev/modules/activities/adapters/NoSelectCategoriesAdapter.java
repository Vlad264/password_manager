package ru.nsu.bashev.modules.activities.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Category;

public class NoSelectCategoriesAdapter extends RecyclerView.Adapter<NoSelectCategoriesAdapter.CategoryHolder> {

    private List<Category> categories;

    public NoSelectCategoriesAdapter(List<Category> categories) {
        this.categories = categories;
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
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;

        public CategoryHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.categoryNameTextView);
            itemView.findViewById(R.id.categoryRemoveImageButton).setVisibility(View.GONE);
            itemView.findViewById(R.id.categorySelectCheckBox).setVisibility(View.GONE);
        }
    }
}
