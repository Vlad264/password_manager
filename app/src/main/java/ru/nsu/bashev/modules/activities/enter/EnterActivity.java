package ru.nsu.bashev.modules.activities.enter;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;

public class EnterActivity extends SingleFragmentActivity {

    private IEnterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UseCaseHandler handler = UseCaseHandler.getInstance();

        IEnterView view = (IEnterView) fragment;
        presenter = new EnterPresenter(view, handler);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new EnterFragment();
    }
}
