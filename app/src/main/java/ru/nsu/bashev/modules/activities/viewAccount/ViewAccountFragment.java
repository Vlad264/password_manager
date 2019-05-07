package ru.nsu.bashev.modules.activities.viewAccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.activities.adapters.SelectCategoriesAdapter;
import ru.nsu.bashev.modules.activities.editAccount.EditAccountActivity;
import ru.nsu.bashev.modules.activities.editAccount.IEditAccountPresenter;
import ru.nsu.bashev.modules.activities.editAccount.IEditAccountView;
import ru.nsu.bashev.modules.activities.navigation.NavigationActivity;

public class ViewAccountFragment extends Fragment implements IViewAccountView {

    private IViewAccountPresenter presenter;
    private SelectCategoriesAdapter adapter;

    private TextView nameTextView;
    private TextView loginPanel;
    private TextView loginTextView;
    private TextView emailPanel;
    private TextView emailTextView;
    private TextView passwordTextView;
    private TextView descriptionTextView;
    private RecyclerView categoriesRecyclerView;
    private Button cancelButton;
    private Button editButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_view, container, false);

        nameTextView = view.findViewById(R.id.nameValueTextView);
        loginPanel = view.findViewById(R.id.loginTextView);
        loginPanel.setVisibility(View.GONE);
        loginTextView = view.findViewById(R.id.loginValueTextView);
        loginTextView.setVisibility(View.GONE);
        emailPanel = view.findViewById(R.id.emailTextView);
        emailPanel.setVisibility(View.GONE);
        emailTextView = view.findViewById(R.id.emailValueTextView);
        emailTextView.setVisibility(View.GONE);
        passwordTextView = view.findViewById(R.id.passwordValueTextView);
        descriptionTextView = view.findViewById(R.id.descriptionValueTextView);
        categoriesRecyclerView = view.findViewById(R.id.categoriesRecyclerView);
        cancelButton = view.findViewById(R.id.accountCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                close();
            }
        });
        editButton = view.findViewById(R.id.accountEditButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditAccountActivity.class);
                intent.putExtra("ID", presenter.getId());
                startActivity(intent);
                close();
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
    public void setPresenter(IViewAccountPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showInfo(Account account) {
        nameTextView.setText(account.getName());
        if (account.hasLogin()) {
            loginPanel.setVisibility(View.VISIBLE);
            loginTextView.setVisibility(View.VISIBLE);
            loginTextView.setText(account.getLogin().getLogin());
        }
        if (account.hasEmail()) {
            emailPanel.setVisibility(View.VISIBLE);
            emailTextView.setVisibility(View.VISIBLE);
            emailTextView.setText(account.getLogin().getLogin());
        }
        passwordTextView.setText(account.getPassword().getPassword());
        descriptionTextView.setText(account.getDescription());
    }

    @Override
    public void close() {
        getActivity().finish();
    }

    @Override
    public void error() {
        Toast.makeText(getContext(), "Some problem", Toast.LENGTH_SHORT).show();
        close();
    }
}
