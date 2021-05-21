package com.lcl.visma.test.services;

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
    GoogleSignInAccount authenticate();

    /**
     * return a client signed in on google
     *
     * @return GoogleSignInClient
     */
    GoogleSignInClient getGoogleSignInClient();
}
