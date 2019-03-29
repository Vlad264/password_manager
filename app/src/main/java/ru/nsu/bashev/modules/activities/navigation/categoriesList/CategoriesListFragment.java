package ru.nsu.bashev.modules.activities.navigation.categoriesList;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.nsu.bashev.R;
import ru.nsu.bashev.modules.activities.adapters.CategoryViewAdapter;

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
                //TODO add handler
            }
        });
        categoryAddFloatingActionButton = view.findViewById(R.id.categoryAddFloatingActionButton);
        categoryAddFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //presenter.start();
    }

    @Override
    public void setPresenter(ICategoriesListPresenter presenter) {
        this.presenter = presenter;
    }
}
