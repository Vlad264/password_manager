package ru.nsu.bashev.modules.activities.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class AccountViewAdapter extends RecyclerView.Adapter<AccountViewAdapter.AccountHolder> {

    @Override
    public AccountHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(AccountHolder accountHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static final class AccountHolder extends RecyclerView.ViewHolder {

        public AccountHolder(View itemView) {
            super(itemView);
        }
    }
}
