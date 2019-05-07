package ru.nsu.bashev.modules.activities.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Account;
import ru.nsu.bashev.modules.activities.navigation.NavigationActivity;
import ru.nsu.bashev.modules.activities.navigation.accountList.IAccountsListPresenter;
import ru.nsu.bashev.modules.activities.viewAccount.ViewAccountActivity;

public class AccountViewAdapter extends RecyclerView.Adapter<AccountViewAdapter.AccountHolder> {

    private Context context;
    private IAccountsListPresenter presenter;
    private List<Account> accounts;

    public AccountViewAdapter(Context context, IAccountsListPresenter presenter, List<Account> accounts) {
        this.context = context;
        this.presenter = presenter;
        this.accounts = accounts;
    }

    @Override
    public AccountHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_account, viewGroup, false);
        return new AccountHolder(view);
    }

    @Override
    public void onBindViewHolder(final AccountHolder accountHolder, int i) {
        accountHolder.id = accounts.get(i).getId();
        accountHolder.title.setText(accounts.get(i).getName());
        accountHolder.password.setText(accounts.get(i).getPassword().getPassword());
        accountHolder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.removeAccount(accountHolder.id);
            }
        });
        accountHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewAccountActivity.class);
                intent.putExtra("ID", accountHolder.id);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public static final class AccountHolder extends RecyclerView.ViewHolder {

        public long id;
        public TextView title;
        public TextView password;
        public ImageButton removeButton;

        public AccountHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.accountTitleTextView);
            password = itemView.findViewById(R.id.accountPasswordValueTextView);
            removeButton = itemView.findViewById(R.id.accountRemoveImageButton);
        }
    }
}
