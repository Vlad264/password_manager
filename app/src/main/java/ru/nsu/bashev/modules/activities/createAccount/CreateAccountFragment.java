package ru.nsu.bashev.modules.activities.createAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.nsu.bashev.R;
import ru.nsu.bashev.modules.activities.adapters.SelectCategoriesAdapter;

public class CreateAccountFragment extends Fragment implements ICreateAccountView {

    private ICreateAccountPresenter presenter;
    private SelectCategoriesAdapter adapter;

    private EditText nameEditText;
    private EditText loginEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText descriptionEditText;
    private RecyclerView selectCategoriesRecyclerView;
    private Button cancelButton;
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_edit, container, false);

        nameEditText = view.findViewById(R.id.nameValueEditText);
        loginEditText = view.findViewById(R.id.loginValueEditText);
        emailEditText = view.findViewById(R.id.emailValueEditText);
        passwordEditText = view.findViewById(R.id.passwordValueEditText);
        descriptionEditText = view.findViewById(R.id.descriptionValueEditText);
        selectCategoriesRecyclerView = view.findViewById(R.id.categoriesSelectRecycleView);
        cancelButton = view.findViewById(R.id.accountCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
            }
        });
        saveButton = view.findViewById(R.id.accountSaveButton);
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
    public void setPresenter(ICreateAccountPresenter presenter) {
        this.presenter = presenter;
    }
}
