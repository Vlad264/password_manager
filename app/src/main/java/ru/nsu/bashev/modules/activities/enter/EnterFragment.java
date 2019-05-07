package ru.nsu.bashev.modules.activities.enter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.nsu.bashev.R;
import ru.nsu.bashev.modules.activities.navigation.NavigationActivity;
import ru.nsu.bashev.modules.activities.registration.RegistrationActivity;
import ru.nsu.bashev.modules.example.IExamplePresenter;
import ru.nsu.bashev.modules.example.IExampleView;

public class EnterFragment extends Fragment implements IEnterView {

    private IEnterPresenter presenter;
    private TextView greeting;
    private EditText passwordEditText;
    private Button enterButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter, container, false);

        greeting = view.findViewById(R.id.greetingTextView);
        passwordEditText = view.findViewById(R.id.enterPasswordEditText);
        enterButton = view.findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.checkPassword(passwordEditText.getText().toString());
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
    public void setPresenter(IEnterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showName(String name) {
        String str = getResources().getString(R.string.greeting) + ", " + name;
        greeting.setText(str);
    }

    @Override
    public void success() {
        Intent intent = new Intent(getContext(), NavigationActivity.class);
        startActivity(intent);
    }

    @Override
    public void incorrectPassword() {
        Toast.makeText(getContext(), "Incorrect password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noRegistration() {
        Intent intent = new Intent(getContext(), RegistrationActivity.class);
        startActivity(intent);
    }
}
