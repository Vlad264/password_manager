package ru.nsu.bashev.modules.activities.navigation.categoriesList;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.modules.activities.adapters.CategoryViewAdapter;
import ru.nsu.bashev.modules.activities.createAccount.CreateAccountActivity;
import ru.nsu.bashev.modules.activities.createCategory.CreateCategoryActivity;

public class CategoriesListFragment extends Fragment implements ICategoriesListView {

    private ICategoriesListPresenter presenter;
    private CategoryViewAdapter adapter;

    private Button searchByCategoryButton;
    private RecyclerView categoriesRecyclerView;
    private FloatingActionButton categoryAddFloatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories_list, container, false);

        categoriesRecyclerView = view.findViewById(R.id.categoriesRecyclerView);
        searchByCategoryButton = view.findViewById(R.id.searchByCategoryButton);
        searchByCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.searchByCategories(adapter.getSelectedCategories());
            }
        });
        categoryAddFloatingActionButton = view.findViewById(R.id.categoryAddFloatingActionButton);
        categoryAddFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreateCategoryActivity.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        categoriesRecyclerView.setLayoutManager(manager);
        adapter = new CategoryViewAdapter(getContext(), new LinkedList<Category>(), presenter);
        categoriesRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setPresenter(ICategoriesListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showCategories(List<Category> categories) {
        adapter = new CategoryViewAdapter(getContext(), categories, presenter);
        categoriesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showNothing() {
        Toast.makeText(getContext(), "Nothing found", Toast.LENGTH_SHORT).show();
    }
}
