package ru.nsu.bashev.modules.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.nsu.bashev.R;

public class ExampleFragment extends Fragment implements IExampleView {

    private IExamplePresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_edit, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //presenter.start();
    }

    @Override
    public void setPresenter(IExamplePresenter presenter) {
        this.presenter = presenter;
    }
}
