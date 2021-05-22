package com.lcl.visma.work.services.google;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

/**
 * interface with methods to call google services
 */
public interface GoogleService {

    /**
     * method to authenticate on google
     *
     * @return GoogleSignInAccount
     */
    GoogleSignInAccount authenticate(Context cntx);

    /**
     * return a client signed in on google
     *
     * @return GoogleSignInClient
     */
    GoogleSignInClient getGoogleSignInClient();

    /**
     * method to logOut on google.
     * @return boolean true if sigout was correct
     */
    void logOut();
}
