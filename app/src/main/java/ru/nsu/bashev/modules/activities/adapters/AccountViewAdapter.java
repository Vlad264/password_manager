package ru.nsu.bashev.modules.activities.adapters;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        final Account account = accounts.get(i);
        accountHolder.id = account.getId();
        accountHolder.title.setText(account.getName());
        if (account.hasEmail()) {
            accountHolder.emailValue.setText(account.getEmail().getEmail());
        } else {
            accountHolder.emailPlane.setVisibility(View.GONE);
            accountHolder.emailValue.setVisibility(View.GONE);
        }
        if (account.hasLogin()) {
            accountHolder.loginValue.setText(account.getLogin().getLogin());
        } else {
            accountHolder.loginPlane.setVisibility(View.GONE);
            accountHolder.loginValue.setVisibility(View.GONE);
        }
        String password = "";
        for (int j = 0; j < account.getPassword().getPassword().length(); j++) {
            password += "*";
        }
        accountHolder.password.setText(password);
        accountHolder.copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clipData = ClipData.newPlainText("Password", account.getPassword().getPassword());
                manager.setPrimaryClip(clipData);
                Toast.makeText(context, "Password save to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
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
        public TextView loginPlane;
        public TextView loginValue;
        public TextView emailPlane;
        public TextView emailValue;
        public TextView password;
        public ImageButton copyButton;
        public ImageButton removeButton;

        public AccountHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.accountTitleTextView);
            loginPlane = itemView.findViewById(R.id.accountLoginTextView);
            loginValue = itemView.findViewById(R.id.accountLoginValueTextView);
            emailPlane = itemView.findViewById(R.id.accountEmailTextView);
            emailValue = itemView.findViewById(R.id.accountEmailValueTextView);
            password = itemView.findViewById(R.id.accountPasswordValueTextView);
            copyButton = itemView.findViewById(R.id.accountPasswordCopyImageButton);
            removeButton = itemView.findViewById(R.id.accountRemoveImageButton);
        }
    }
}
