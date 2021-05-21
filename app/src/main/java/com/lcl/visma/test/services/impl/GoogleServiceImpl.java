package com.lcl.visma.test.services.impl;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.lcl.visma.test.services.GoogleService;

/**
 * interface with methods to call google services
 */
public class GoogleServiceImpl implements GoogleService {

    private final Context cntx;
    private GoogleSignInClient mGoogleSignInClient;

    public GoogleServiceImpl(final Context cntx) {
        this.cntx = cntx;
    }

    @Override
    public GoogleSignInAccount authenticate() {

        // Code obtained from https://developers.google.com/identity/sign-in/android/sign-in?hl=en

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(cntx, gso);

        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        return GoogleSignIn.getLastSignedInAccount(cntx);
    }

    @Override
    public GoogleSignInClient getGoogleSignInClient() {
        return mGoogleSignInClient;
    }
}
