package ru.nsu.bashev.modules.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.nsu.bashev.R;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.base.SingleFragmentActivity;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class ExampleActivity extends SingleFragmentActivity {

    private IExamplePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        UseCaseHandler handler = UseCaseHandler.getInstance();
        HandlePush handlePush = new HandlePush();

        IExampleView view = (IExampleView) fragment;
        presenter = new ExamplePresenter(view, handler, handlePush);
        view.setPresenter(presenter);

    }

    @Override
    protected Fragment createFragment() {
        return new ExampleFragment();
    }
}
