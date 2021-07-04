package com.mypharmacyprojectt.mypharmacy.ui.register;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mypharmacyprojectt.mypharmacy.data.model.LoggedInUser;
import com.mypharmacyprojectt.mypharmacy.data.repository.LoginRepository;
import com.mypharmacyprojectt.mypharmacy.retrofit.RegisterApi;
import com.mypharmacyprojectt.mypharmacy.retrofit.RetrofitClient;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RegisterViewModel extends ViewModel {

    private MutableLiveData<RegisterResult> registerResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    public RegisterViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<RegisterResult> getRegisterResult() {
        return registerResult;
    }

    public void registerUser(String firstName, String lastName, String username,
                             String password, int age, String address) {
        Log.d("TGM", "registerUser item is: "
                + firstName + lastName);
        RegisterApi registerApi = RetrofitClient.getClient().create(RegisterApi.class);
        registerApi.registerUserRequest(firstName, lastName, age, address,
                username, password, " ")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoggedInUser>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull LoggedInUser loggedInUser) {
                        if (loggedInUser.getData() != null) {
                            registerResult.setValue(new RegisterResult(true));
                        } else {
                            registerResult.setValue(new RegisterResult(false, "Failed"));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        registerResult.setValue(new RegisterResult(false, "Failed"));
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void registerPharmacist(String firstName, String lastName, String username,
                                   String password) {
        Log.d("TGM", "registerPharmacist item is:");
        RegisterApi registerApi = RetrofitClient.getClient().create(RegisterApi.class);
        registerApi.registerPharmacistRequest(firstName, lastName, username, password)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoggedInUser>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull LoggedInUser loggedInUser) {
                        if (loggedInUser.getData() != null) {
                            registerResult.setValue(new RegisterResult(true));
                        } else {
                            registerResult.setValue(new RegisterResult(false, "Failed"));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        registerResult.setValue(new RegisterResult(false, "Failed"));
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
