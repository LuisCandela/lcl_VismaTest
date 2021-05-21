package com.lcl.visma.test.ui.login;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.lcl.visma.test.R;
import com.lcl.visma.test.services.GoogleService;
import com.lcl.visma.test.services.impl.GoogleServiceImpl;
import com.lcl.visma.test.ui.BaseViewModel;

public class LoginViewModel extends BaseViewModel {

    private Context cntx;

    // TODO: see dependencies injection
    private GoogleService gglSrv;

    public String getText() {
        return cntx.getString(R.string.login_greetings);
    }

    /**
     * method to authenticate on google
     */
    public GoogleSignInAccount athenticate() {
        // TODO: see dependencies injection Hilt
        gglSrv = new GoogleServiceImpl(cntx);
        return gglSrv.authenticate();
    }

    /**
     * return a client signed in on google
     *
     * @return GoogleSignInClient
     */
    public GoogleSignInClient getGoogleSignInClient() {
        return gglSrv.getGoogleSignInClient();
    }

    protected void setContext(final Context cntx) {
        this.cntx = cntx;
    }
}