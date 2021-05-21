package com.lcl.visma.test.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.lcl.visma.test.R;
import com.lcl.visma.test.databinding.LoginFragmentBinding;

import org.jetbrains.annotations.NotNull;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;
    // generated when changed from constraintLsyout to Layout on login_fragmnet
    private LoginFragmentBinding loginFragmentBinding;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        loginFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.login_fragment, container, false);
        return loginFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        // pass the private variable to the xml view
        loginFragmentBinding.setLoginViewModel(mViewModel);
    }

}