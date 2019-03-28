package ru.nsu.bashev.modules.activities.enter;

import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.example.IExamplePresenter;
import ru.nsu.bashev.modules.example.IExampleView;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class EnterPresenter implements IEnterPresenter {

    private IEnterView view;
    private UseCaseHandler handler;
    private HandlePush handlePush;

    public EnterPresenter(IEnterView view, UseCaseHandler handler, HandlePush handlePush) {
        this.view = view;
        this.handler = handler;
        this.handlePush = handlePush;
    }

    @Override
    public void start() {
        //Nothing on start
    }
}
