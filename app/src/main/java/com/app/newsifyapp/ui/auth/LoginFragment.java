package com.app.newsifyapp.ui.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Patterns;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.navigation.fragment.NavHostFragment;

import com.app.newsifyapp.R;
import com.app.newsifyapp.databinding.FragmentLoginBinding;
import com.app.newsifyapp.utils.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.regex.Pattern;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private final String TAG = "LoginFragment";
    private FragmentLoginBinding binding;

    private FirebaseAuth auth;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auth = FirebaseAuth.getInstance();

        binding.tvDontAccount.setOnClickListener(this);
        binding.tvLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvDontAccount:
                NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_registerFragment);
                break;

            case R.id.tvLogin:
                if (!isFieldEmpty()) {

                    if (isValidEmailId(binding.etEmail.getText().toString())) {

                        if (Constants.isInternetConnected(getContext())) {

                            auth.signInWithEmailAndPassword(binding.etEmail.getText().toString().trim(),
                                    binding.etPassword.getText().toString().trim())
                                    .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_dashboardFragment);
                                            } else {
                                                Toast.makeText(getContext(), "Invalid Email and Password", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull @NotNull Exception e) {
                                    Toast.makeText(getContext(), "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        else{
                            Toast.makeText(getContext(), "Unable to connect to the internet", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        binding.etEmail.setError("Invalid Email");
                    }
                }
                break;
        }

    }

    private boolean isFieldEmpty() {
        boolean isEmpty = false;

        if (binding.etEmail.getText().toString().trim().isEmpty()) {
            binding.etEmail.setError("Field can't be left blanked");
            isEmpty = true;
        }
        if (binding.etPassword.getText().toString().trim().isEmpty()) {
            binding.etPassword.setError("Field can't be left blanked");
            isEmpty = true;
        }

        return isEmpty;

    }

    private boolean isValidEmailId(String email) {

        return Pattern.compile(
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        ).matcher(email).matches();

    }
}
