package ru.nsu.bashev.modules.activities.navigation.accountList;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.nsu.bashev.R;
import ru.nsu.bashev.modules.activities.adapters.AccountViewAdapter;

public class AccountsListFragment extends Fragment implements IAccountsListView {

    private IAccountsListPresenter presenter;
    private AccountViewAdapter adapter;

    private EditText searchByTitleEditText;
    private EditText searchByLoginEditText;
    private EditText searchByEmailEditText;
    private Button searchByTitleButton;
    private Button searchByLoginButton;
    private Button searchByEmailButton;
    private RecyclerView accountsRecyclerView;
    private FloatingActionButton accountAddFloatingActionButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accounts_list, container, false);

        searchByTitleEditText = view.findViewById(R.id.searchByTitleEditText);
        searchByLoginEditText = view.findViewById(R.id.searchByLoginEditText);
        searchByEmailEditText = view.findViewById(R.id.searchByEmailTitleEditText);
        accountsRecyclerView = view.findViewById(R.id.accountsRecyclerView);
        searchByTitleButton = view.findViewById(R.id.searchByTitleButton);
        searchByTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
            }
        });
        searchByLoginButton = view.findViewById(R.id.searchByLoginButton);
        searchByLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
            }
        });
        searchByEmailButton = view.findViewById(R.id.searchByEmailTitleButton);
        searchByEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
            }
        });
        accountAddFloatingActionButton = view.findViewById(R.id.accountAddFloatingActionButton);
        accountAddFloatingActionButton.setOnClickListener(new View.OnClickListener() {
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
    public void setPresenter(IAccountsListPresenter presenter) {
        this.presenter = presenter;
    }
}
