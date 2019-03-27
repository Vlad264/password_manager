package ru.nsu.bashev.modules.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ru.nsu.bashev.R;

public class ExampleFragment extends Fragment implements IExampleView {

    private IExamplePresenter presenter;
    private Button pushButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);

        pushButton = view.findViewById(R.id.pushButton);
        pushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonPush();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void showToast(boolean flag) {
        if (flag) {
            Toast.makeText(getContext(), "Орел", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Решка", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setPresenter(IExamplePresenter presenter) {
        this.presenter = presenter;
    }
}
