package ru.nsu.bashev.modules.activities.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.nsu.bashev.R;
import ru.nsu.bashev.model.Account;

public class AccountViewAdapter extends RecyclerView.Adapter<AccountViewAdapter.AccountHolder> {

    private List<Account> accounts;

    public AccountViewAdapter(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public AccountHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_account, viewGroup, false);
        return new AccountHolder(view);
    }

    @Override
    public void onBindViewHolder(AccountHolder accountHolder, int i) {
        accountHolder.title.setText(accounts.get(i).getName());
        accountHolder.password.setText(accounts.get(i).getPassword().getPassword());
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public static final class AccountHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView password;

        public AccountHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.accountTitleTextView);
            password = itemView.findViewById(R.id.accountPasswordValueTextView);
        }
    }
}
