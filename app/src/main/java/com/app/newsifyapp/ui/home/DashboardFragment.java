package com.app.newsifyapp.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.app.newsifyapp.R;
import com.app.newsifyapp.databinding.FragmentDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    private FragmentDashboardBinding binding;
    private final String TAG = "DashboardFragment";
    private boolean isDrawerLocked = false;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer2, new TopStoriesFragment())
                .commit();

        getActivity().getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

                if(isAdded()){
                    Fragment currentBackStackFragment =
                            Objects.requireNonNull(requireActivity()).getSupportFragmentManager().findFragmentById(R.id.fragmentContainer2);

                    if (currentBackStackFragment != null) {

                        if(currentBackStackFragment.isAdded()){
                            if (currentBackStackFragment instanceof DetailsFragment) {
                                isDrawerLocked = true;
                                binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                                binding.headerMain.ivDrawer.setImageResource(R.drawable.ic_baseline_keyboard_backspace_26);
                            } else {
                                isDrawerLocked = false;
                                binding.drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                                binding.headerMain.ivDrawer.setImageResource(R.drawable.ic_baseline_menu_32_white);

                            }
                        }
                    }
                }
            }
        });

        binding.headerMain.ivDrawer.setOnClickListener(this);
        binding.svMenuMain.tvLogout.setOnClickListener(this);
        binding.svMenuMain.tvMostPopular.setOnClickListener(this);
        binding.svMenuMain.tvTopStories.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivDrawer:
                if (!isDrawerLocked) {
                    if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                        binding.drawer.closeDrawer(GravityCompat.START);
                    } else {
                        binding.drawer.openDrawer(GravityCompat.START);
                    }
                } else {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
                break;

            case R.id.tvMostPopular:
                binding.headerMain.tvLogout.setText("Most Popular");
                binding.drawer.closeDrawer(GravityCompat.START);

                binding.svMenuMain.tvLogout.setTextColor(getResources().getColor(R.color.colorDarkGrey2));
                binding.svMenuMain.tvTopStories.setTextColor(getResources().getColor(R.color.colorDarkGrey2));
                binding.svMenuMain.tvMostPopular.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer2, new MostPopularFragment())
                        .commit();

                break;

            case R.id.tvTopStories:
                binding.headerMain.tvLogout.setText("Top stories");

                binding.drawer.closeDrawer(GravityCompat.START);

                binding.svMenuMain.tvLogout.setTextColor(getResources().getColor(R.color.colorDarkGrey2));
                binding.svMenuMain.tvMostPopular.setTextColor(getResources().getColor(R.color.colorDarkGrey2));

                binding.svMenuMain.tvTopStories.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer2, new TopStoriesFragment())
                        .commit();
                break;

            case R.id.tvLogout:
                new AlertDialog.Builder(getContext())
                        .setTitle("Logout!")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseAuth.getInstance().signOut();
                                NavHostFragment.findNavController(DashboardFragment.this).navigate(R.id.action_dashboardFragment_to_loginFragment);

                            }
                        })
                        .setNegativeButton("No", null).show();

                break;
        }

    }

}
