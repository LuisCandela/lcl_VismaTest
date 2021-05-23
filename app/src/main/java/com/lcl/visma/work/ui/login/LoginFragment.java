package com.lcl.visma.work.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.lcl.visma.work.R;
import com.lcl.visma.work.databinding.LoginFragmentBinding;
import com.lcl.visma.work.ui.BaseFragment;
import com.lcl.visma.work.ui.weather.WeatherActivity;

import org.jetbrains.annotations.NotNull;


public class LoginFragment extends BaseFragment implements View.OnClickListener {

    private LoginViewModel mViewModel;
    // identifier when sending-return to google intent
    private final int RC_SIGN_IN = 1;
    // generated when changed from constraintLayout to Layout on login_fragmnet
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

        final View view = loginFragmentBinding.getRoot();
        initComponents(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        // set the context app to use of services
        mViewModel.initViewModel(this);
        // pass the private variable to the xml view
        loginFragmentBinding.setLoginViewModel(mViewModel);

        initView();
    }

    /**
     * method to get all the components from the view and initialize them.
     *
     * @param view View
     */
    private void initComponents(final View view) {

        view.findViewById(R.id.login_fragment_sigin_btn).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_fragment_sigin_btn) {
            mViewModel.athenticate();

            Intent signInIntent = mViewModel.getGoogleSignInClient().getSignInIntent();
            // TODO: see how to change to registerForActivityResult(ActivityResultContract, ActivityResultCallback)
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            handleSignInResult(GoogleSignIn.getSignedInAccountFromIntent(data));
        }
    }

    /**
     * execute action depending on login result
     *
     * @param completedTask Task<GoogleSignInAccount>
     */
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, redirect to weather
            goToWeather();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Toast.makeText(getContext(), getString(R.string.login_error) + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    /**
     * methods thrown when the view is already created
     */
    private void initView() {
        boolean userLogged = mViewModel.athenticate() != null;
        // if user already logged
        if (userLogged) {
            goToWeather();
        }
    }

    /**
     * navigation to weather activity
     */
    private void goToWeather() {
        // TODO: change navigation to https://developer.android.com/guide/navigation/navigation-navigate ¿change to common method on baseViewModel?
        Intent intent = new Intent(getActivity(), WeatherActivity.class);
        startActivity(intent);
    }
}