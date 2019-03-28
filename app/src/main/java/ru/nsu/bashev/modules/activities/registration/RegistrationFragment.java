package ru.nsu.bashev.modules.activities.registration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ru.nsu.bashev.R;

public class RegistrationFragment extends Fragment implements IRegistrationView {

    private IRegistrationPresenter presenter;
    private EditText passwordEditText;
    private Button enterButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        passwordEditText = view.findViewById(R.id.enterPasswordEditText);
        enterButton = view.findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add handler
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
    public void setPresenter(IRegistrationPresenter presenter) {
        this.presenter = presenter;
    }
}
