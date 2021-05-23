package com.lcl.visma.work.ui.login;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.lcl.visma.work.R;
import com.lcl.visma.work.ui.BaseFragment;
import com.lcl.visma.work.ui.BaseViewModel;

public class LoginViewModel extends BaseViewModel {

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
        return gglSrv.authenticate(cntx);
    }

    /**
     * return a client signed in on google
     *
     * @return GoogleSignInClient
     */
    public GoogleSignInClient getGoogleSignInClient() {
        return gglSrv.getGoogleSignInClient();
    }

}