package ru.nsu.bashev.modules.activities.editAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class EditAccountActivity extends SingleFragmentActivity {

    private IEditAccountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UseCaseHandler handler = UseCaseHandler.getInstance();
        HandlePush handlePush = new HandlePush();

        IEditAccountView view = (IEditAccountView) fragment;
        presenter = new EditAccountPresenter(view, handler, handlePush);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new EditAccountFragment();
    }
}
