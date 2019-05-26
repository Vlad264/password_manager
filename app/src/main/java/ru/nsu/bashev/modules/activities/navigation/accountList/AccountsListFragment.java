package ru.nsu.bashev.modules.activities.navigation.accountList;

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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.activities.adapters.AccountViewAdapter;
import ru.nsu.bashev.modules.activities.createAccount.CreateAccountActivity;

public class AccountsListFragment extends Fragment implements IAccountsListView {

    private IAccountsListPresenter presenter;

    private Spinner searchType;
    private EditText searchEditText;
    private Button searchButton;
    private RecyclerView accountsRecyclerView;
    private FloatingActionButton accountAddFloatingActionButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accounts_list, container, false);

        searchType = view.findViewById(R.id.searchType);
        searchEditText = view.findViewById(R.id.searchEditText);
        accountsRecyclerView = view.findViewById(R.id.accountsRecyclerView);
        searchButton = view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });


        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        accountsRecyclerView.setLayoutManager(manager);
        accountsRecyclerView.setAdapter(new AccountViewAdapter(getContext(), presenter, new LinkedList<Account>()));

        accountAddFloatingActionButton = view.findViewById(R.id.accountAddFloatingActionButton);
        accountAddFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CreateAccountActivity.class);
                startActivity(intent);
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
    public void setPresenter(IAccountsListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showAccounts(List<Account> accounts) {
        accountsRecyclerView.setAdapter(new AccountViewAdapter(getContext(), presenter, accounts));
    }

    @Override
    public void showNothing() {
        Toast.makeText(getContext(), "Nothing found", Toast.LENGTH_SHORT).show();
    }

    private void search() {
        if (searchEditText.getText().toString().isEmpty()) {
            return;
        }
        switch ((int) searchType.getSelectedItemId()) {
            case 0:
                presenter.searchByTitle(searchEditText.getText().toString());
                break;

            case 1:
                presenter.searchByEmail(searchEditText.getText().toString());
                break;

            case 2:
                presenter.searchByLogin(searchEditText.getText().toString());
                break;
        }
        searchEditText.setText("");
    }
}
