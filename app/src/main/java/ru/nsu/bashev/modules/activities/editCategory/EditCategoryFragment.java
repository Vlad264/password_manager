package ru.nsu.bashev.modules.activities.editCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Category;

public class EditCategoryFragment extends Fragment implements IEditCategoryView {

    private IEditCategoryPresenter presenter;

    private EditText nameEditText;
    private Button cancelButton;
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_edit, container, false);

        nameEditText = view.findViewById(R.id.nameValueEditText);
        cancelButton = view.findViewById(R.id.categoryCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        saveButton = view.findViewById(R.id.categorySaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveCategory(new Category(nameEditText.getText().toString()));
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setPresenter(IEditCategoryPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void close() {
        getActivity().finish();
    }

    @Override
    public void error() {
        Toast.makeText(getContext(), "Name must be fill", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInfo(Category category) {
        nameEditText.setText(category.getName());
    }
}
