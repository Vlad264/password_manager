package ru.nsu.bashev.modules.activities.createAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;

public class CreateAccountActivity extends SingleFragmentActivity {

    private ICreateAccountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UseCaseHandler handler = UseCaseHandler.getInstance();

        ICreateAccountView view = (ICreateAccountView) fragment;
        presenter = new CreateAccountPresenter(view, handler);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new CreateAccountFragment();
    }
}
