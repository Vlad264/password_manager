package ru.nsu.bashev.modules.activities.editAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.model.Category;
import ru.nsu.bashev.model.Email;
import ru.nsu.bashev.model.Login;
import ru.nsu.bashev.model.Password;
import ru.nsu.bashev.modules.activities.adapters.NoSelectCategoriesAdapter;

public class EditAccountFragment extends Fragment implements IEditAccountView {

    private IEditAccountPresenter presenter;
    private NoSelectCategoriesAdapter adapter;

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
                getActivity().finish();
            }
        });
        saveButton = view.findViewById(R.id.accountSaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.saveAccount(new Account(nameEditText.getText().toString(),
                        descriptionEditText.getText().toString(),
                        new Password(passwordEditText.getText().toString()),
                        emailEditText.getText().toString().isEmpty() ? null : new Email(emailEditText.getText().toString()),
                        loginEditText.getText().toString().isEmpty() ? null : new Login(loginEditText.getText().toString()),
                        new LinkedList<Category>()));
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
    public void setPresenter(IEditAccountPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void success() {
        getActivity().finish();
    }

    @Override
    public void error() {
        Toast.makeText(getContext(), "Field must be fill", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInfo(Account account) {
        nameEditText.setText(account.getName());
        if (account.hasLogin()) {
            loginEditText.setText(account.getLogin().getLogin());
        }
        if (account.hasEmail()) {
            emailEditText.setText(account.getEmail().getEmail());
        }
        passwordEditText.setText(account.getPassword().getPassword());
        descriptionEditText.setText(account.getDescription());
    }
}
