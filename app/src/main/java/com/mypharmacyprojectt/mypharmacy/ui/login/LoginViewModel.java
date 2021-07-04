package com.mypharmacyprojectt.mypharmacy.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mypharmacyprojectt.mypharmacy.data.repository.LoginRepository;
import com.mypharmacyprojectt.mypharmacy.data.Result;
import com.mypharmacyprojectt.mypharmacy.data.model.LoggedInUser;
import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.retrofit.LoginApi;
import com.mypharmacyprojectt.mypharmacy.retrofit.RetrofitClient;

import java.io.IOException;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password) {
        LoginApi loginApi = RetrofitClient.getClient().create(LoginApi.class);
        loginApi.loginRequest(username, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoggedInUser>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull LoggedInUser loggedInUser) {
                        if (loggedInUser.getData() != null) {
                            loginRepository.setLoggedInUser(loggedInUser);
                            setLoginResult(new Result.Success<>(loggedInUser));
                        } else {
                            setLoginResult(new Result.Error(new IOException("Error logging in due to incorrect user")));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        setLoginResult(new Result.Error(new IOException("Error logging in", e)));
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {}
                });
    }

    public void setLoginResult(Result<LoggedInUser> result) {
        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data)));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }
}