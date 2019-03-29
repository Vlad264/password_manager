package ru.nsu.bashev.modules.activities.createCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.nsu.bashev.R;

public class CreateCategoryFragment extends Fragment implements ICreateCategoryView {

    private ICreateCategoryPresenter presenter;

    private EditText nameEditText;
    private Button cancelButton;
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter, container, false);

        nameEditText = view.findViewById(R.id.nameValueEditText);
        cancelButton = view.findViewById(R.id.categoryCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
            }
        });
        saveButton = view.findViewById(R.id.categorySaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
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
        presenter.start();
    }

    @Override
    public void setPresenter(ICreateCategoryPresenter presenter) {
        this.presenter = presenter;
    }
}
