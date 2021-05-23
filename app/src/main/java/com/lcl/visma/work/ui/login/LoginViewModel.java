package com.lcl.visma.work.ui.login;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.lcl.visma.work.R;
import com.lcl.visma.work.services.google.GoogleService;
import com.lcl.visma.work.services.google.GoogleServiceFactory;
import com.lcl.visma.work.ui.BaseFragment;
import com.lcl.visma.work.ui.BaseViewModel;

import javax.inject.Inject;

public class LoginViewModel extends BaseViewModel {
    protected Context cntx;
    protected void initViewModel(final BaseFragment fragment) {
        this.cntx = fragment.getContext();
        gglSrv = fragment.getGoogleService();
    }

    public String getText() {
        return cntx.getString(R.string.login_greetings);
    }

    /**
     * method to authenticate on google
     */
    public GoogleSignInAccount athenticate() {
        gglSrv = GoogleServiceFactory.getInstance();
        return gglSrv.authenticate(cntx);
    }

    /**
     * return a client signed in on google
     *
     * @return GoogleSignInClient
     */
    public GoogleSignInClient getGoogleSignInClient() {
        gglSrv = GoogleServiceFactory.getInstance();
        return gglSrv.getGoogleSignInClient();
    }

}