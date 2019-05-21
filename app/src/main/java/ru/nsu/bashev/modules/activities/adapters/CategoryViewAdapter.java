package ru.nsu.bashev.modules.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.activities.editCategory.EditCategoryActivity;
import ru.nsu.bashev.modules.activities.navigation.categoriesList.ICategoriesListPresenter;
import ru.nsu.bashev.modules.activities.viewAccount.ViewAccountActivity;

public class CategoryViewAdapter extends RecyclerView.Adapter<CategoryViewAdapter.CategoryHolder> {

    private Context context;
    private List<Category> categories;
    private ICategoriesListPresenter presenter;

    public CategoryViewAdapter(Context context, List<Category> categories, ICategoriesListPresenter presenter) {
        this.context = context;
        this.categories = categories;
        this.presenter = presenter;
    }

    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_category, viewGroup, false);
        return new CategoryHolder(view);

    }

    @Override
    public void onBindViewHolder(final CategoryHolder categoryHolder, int i) {
        categoryHolder.id = categories.get(i).getId();
        categoryHolder.nameTextView.setText(categories.get(i).getName());
        categoryHolder.selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        categoryHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.removeCategory(categoryHolder.id);
            }
        });

        categoryHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditCategoryActivity.class);
                intent.putExtra("ID", categoryHolder.id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryHolder extends RecyclerView.ViewHolder {

        public long id;
        public CheckBox selectButton;
        public TextView nameTextView;
        public ImageButton removeButton;

        public CategoryHolder(View itemView) {
            super(itemView);
            selectButton = itemView.findViewById(R.id.categorySelectCheckBox);
            nameTextView = itemView.findViewById(R.id.categoryNameTextView);
            removeButton = itemView.findViewById(R.id.categoryRemoveImageButton);
        }
    }
}
