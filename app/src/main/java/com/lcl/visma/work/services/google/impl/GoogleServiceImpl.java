package com.lcl.visma.work.services.google.impl;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.lcl.visma.work.services.google.GoogleService;

/**
 * interface with methods to call google services
 */
public class GoogleServiceImpl implements GoogleService {

    private GoogleSignInClient mGoogleSignInClient;

    @Override
    public GoogleSignInAccount authenticate(final Context cntx) {

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

    @Override
    public void logOut() {
        mGoogleSignInClient.signOut();
    }

    @Override
    public String getSignedInName(final Context cntx) {
        GoogleSignInAccount user = GoogleSignIn.getLastSignedInAccount(cntx);
        if (user != null){
            String name = user.getDisplayName();
            if(name == null || name.isEmpty()){
                // change to return eMail cause rest of displayName or GivenName were empty
                name = user.getEmail();
            }
            return name;
        }
        return "";
    }
}
