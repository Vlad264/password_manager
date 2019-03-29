package ru.nsu.bashev.modules.activities.viewAccount;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;

public class ViewAccountActivity extends SingleFragmentActivity {

    private IViewAccountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UseCaseHandler handler = UseCaseHandler.getInstance();

        IViewAccountView view = (IViewAccountView) fragment;
        presenter = new ViewAccountPresenter(view, handler);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new ViewAccountFragment();
    }
}
