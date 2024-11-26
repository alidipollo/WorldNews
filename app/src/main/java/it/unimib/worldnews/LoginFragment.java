package it.unimib.worldnews;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import org.apache.commons.validator.routines.EmailValidator;


public class LoginFragment extends Fragment {

    public static final String TAG = LoginActivity.class.getName();
    private TextInputEditText editTextEmail, editTextPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextEmail = view.findViewById(R.id.text_input_email);
        editTextPassword = view.findViewById(R.id.text_input_password);
        Button loginButton = view.findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            if (true){
                if(true){
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_pickCountryActivity);
                } else {
                    editTextPassword.setError("The password must have a least 8 char");
                    Snackbar.make(view.findViewById(android.R.id.content),
                            "Chek your password ", Snackbar.LENGTH_SHORT).show();
                }
            } else {
                editTextEmail.setError("Check your email: ___ @ ___ .com");
                Snackbar.make(view.findViewById(android.R.id.content),
                        "Insert correct email", Snackbar.LENGTH_SHORT).show();

            }
        });
    }

    boolean isPassword (String password){
        return password.length() > 7;
    }

    boolean isEmail (String email){
        return EmailValidator.getInstance().isValid(email);
    }

}