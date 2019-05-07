package ru.nsu.bashev.modules.activities.viewAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;
import ru.nsu.bashev.modules.database.account.AccountDBHandler;
import ru.nsu.bashev.modules.database.account.IAccountDBHandler;

public class ViewAccountActivity extends SingleFragmentActivity {

    private IViewAccountPresenter presenter;
    private IAccountDBHandler accountDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long id = getIntent().getLongExtra("ID", 0);

        UseCaseHandler handler = UseCaseHandler.getInstance();
        accountDBHandler = new AccountDBHandler(this);

        IViewAccountView view = (IViewAccountView) fragment;
        presenter = new ViewAccountPresenter(view, handler, accountDBHandler, id);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new ViewAccountFragment();
    }
}
