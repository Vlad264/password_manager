package ru.nsu.bashev.modules.activities.viewAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.nsu.bashev.R;
import ru.nsu.bashev.modules.activities.adapters.SelectCategoriesAdapter;
import ru.nsu.bashev.modules.activities.editAccount.IEditAccountPresenter;
import ru.nsu.bashev.modules.activities.editAccount.IEditAccountView;

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
        loginTextView = view.findViewById(R.id.loginValueTextView);
        emailPanel = view.findViewById(R.id.emailTextView);
        emailTextView = view.findViewById(R.id.emailValueTextView);
        passwordTextView = view.findViewById(R.id.passwordValueTextView);
        descriptionTextView = view.findViewById(R.id.descriptionValueTextView);
        categoriesRecyclerView = view.findViewById(R.id.categoriesRecyclerView);
        cancelButton = view.findViewById(R.id.accountCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
            }
        });
        editButton = view.findViewById(R.id.accountEditButton);
        editButton.setOnClickListener(new View.OnClickListener() {
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
    public void setPresenter(IViewAccountPresenter presenter) {
        this.presenter = presenter;
    }
}
