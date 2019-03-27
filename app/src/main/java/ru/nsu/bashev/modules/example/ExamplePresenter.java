package ru.nsu.bashev.modules.example;

import ru.nsu.bashev.common.useCaseEngine.IUseCaseCallback;
import ru.nsu.bashev.common.useCaseEngine.UseCaseHandler;
import ru.nsu.bashev.modules.useCases.HandlePush;

public class ExamplePresenter implements IExamplePresenter {

    private IExampleView view;
    private UseCaseHandler handler;
    private HandlePush handlePush;

    public ExamplePresenter(IExampleView view, UseCaseHandler handler, HandlePush handlePush) {
        this.view = view;
        this.handler = handler;
        this.handlePush = handlePush;
    }

    @Override
    public void start() {
        //Nothing on start
    }

    @Override
    public void onButtonPush() {
        HandlePush.RequestValues request = new HandlePush.RequestValues();
        handler.execute(handlePush, request, new IUseCaseCallback<HandlePush.ResponseValues>() {
            @Override
            public void onSuccess(HandlePush.ResponseValues response) {
                boolean flag = response.isFlag();
                view.showToast(flag);
            }

            @Override
            public void onError() {

            }
        });
    }
}
