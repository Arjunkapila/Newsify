package com.app.newsifyapp.ui.auth;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.app.newsifyapp.R;
import com.app.newsifyapp.databinding.FragmentSplashBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class SplashFragment extends Fragment {

    private FragmentSplashBinding binding;
    private FirebaseAuth auth;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        auth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = auth.getCurrentUser();

        new Handler().postDelayed(() -> {
            if(currentUser != null){
                NavHostFragment.findNavController(SplashFragment.this).navigate(R.id.action_splashFragment_to_dashboardFragment);
            }
            else{
                NavHostFragment.findNavController(SplashFragment.this).navigate(R.id.action_splashFragment_to_loginFragment);
            }
        },2000);

    }

}
