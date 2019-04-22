package ru.nsu.bashev.modules.activities.createAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;
import ru.nsu.bashev.modules.database.account.AccountDBHandler;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class CreateAccountActivity extends SingleFragmentActivity {

    private ICreateAccountPresenter presenter;
    private IAccountDBHandler accountDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UseCaseHandler handler = UseCaseHandler.getInstance();
        accountDBHandler = new AccountDBHandler(this);

        ICreateAccountView view = (ICreateAccountView) fragment;
        presenter = new CreateAccountPresenter(view, handler, accountDBHandler);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new CreateAccountFragment();
    }
}
