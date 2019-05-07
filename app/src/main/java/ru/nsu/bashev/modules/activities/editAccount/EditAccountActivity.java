package ru.nsu.bashev.modules.activities.editAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;
import ru.nsu.bashev.modules.database.account.AccountDBHandler;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class EditAccountActivity extends SingleFragmentActivity {

    private IEditAccountPresenter presenter;
    private IAccountDBHandler accountDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long id = getIntent().getLongExtra("ID", 0);
        UseCaseHandler handler = UseCaseHandler.getInstance();
        accountDBHandler = new AccountDBHandler(this);

        IEditAccountView view = (IEditAccountView) fragment;
        presenter = new EditAccountPresenter(view, handler, accountDBHandler, id);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new EditAccountFragment();
    }
}
