package ru.nsu.bashev.modules.activities.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Category;

public class SelectCategoriesAdapter extends RecyclerView.Adapter<SelectCategoriesAdapter.CategoryHolder> {

    private List<Category> categories;

    public SelectCategoriesAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category, viewGroup, false);
        return new CategoryHolder(view);

    }

    @Override
    public void onBindViewHolder(final CategoryHolder categoryHolder, int i) {
        final int index = i;
        categoryHolder.id = categories.get(i).getId();
        categoryHolder.nameTextView.setText(categories.get(i).getName());
        categoryHolder.selectButton.setChecked(categories.get(i).isSelected());
        categoryHolder.selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categories.get(index).setSelected(categoryHolder.selectButton.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public List<Category> getSelectedCategories() {
        List<Category> result = new LinkedList<>();
        for (Category c : categories) {
            if (c.isSelected()) {
                result.add(c);
            }
        }
        return result;
    }

    public static final class CategoryHolder extends RecyclerView.ViewHolder {

        public long id;
        public CheckBox selectButton;
        public TextView nameTextView;

        public CategoryHolder(View itemView) {
            super(itemView);
            selectButton = itemView.findViewById(R.id.categorySelectCheckBox);
            nameTextView = itemView.findViewById(R.id.categoryNameTextView);
            itemView.findViewById(R.id.categoryRemoveImageButton).setVisibility(View.GONE);
        }
    }
}
