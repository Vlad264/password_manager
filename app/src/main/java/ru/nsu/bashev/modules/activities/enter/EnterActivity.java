package ru.nsu.bashev.modules.activities.enter;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;
import ru.nsu.bashev.modules.database.user.IUserDBHandler;
import ru.nsu.bashev.modules.database.user.UserDBHandler;

public class EnterActivity extends SingleFragmentActivity {

    private IEnterPresenter presenter;
    private IUserDBHandler userDBHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UseCaseHandler handler = UseCaseHandler.getInstance();
        userDBHandler = new UserDBHandler(this);

        IEnterView view = (IEnterView) fragment;
        presenter = new EnterPresenter(view, handler, userDBHandler);
        view.setPresenter(presenter);
    }

    @Override
    protected Fragment createFragment() {
        return new EnterFragment();
    }
}
