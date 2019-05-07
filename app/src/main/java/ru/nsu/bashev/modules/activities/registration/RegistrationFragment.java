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
    private EditText nameEditText;
    private EditText passwordEditText;
    private Button saveButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        nameEditText = view.findViewById(R.id.registerNameEditText);
        passwordEditText = view.findViewById(R.id.registerPasswordEditText);
        saveButton = view.findViewById(R.id.registerSaveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void success() {

    }

    @Override
    public void error() {

    }
}
