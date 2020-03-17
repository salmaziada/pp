package net.selsela.carRental.data;

import net.selsela.carRental.data.local.PreferencesHelper;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.about.AboutData;
import net.selsela.carRental.data.model.client_proplem.Datum;
import net.selsela.carRental.data.model.client_proplem.ProblemData;
import net.selsela.carRental.data.model.client_proplem.oneProblemData;
import net.selsela.carRental.data.model.config.ConfigData;
import net.selsela.carRental.data.model.countries.Country;
import net.selsela.carRental.data.model.countries.CountryData;
import net.selsela.carRental.data.model.home.HomeData;
import net.selsela.carRental.data.model.notification.NotoficationData;
import net.selsela.carRental.data.model.user.company_data;
import net.selsela.carRental.data.model.user.LoginData;
import net.selsela.carRental.data.model.user.UserBody;
import net.selsela.carRental.data.remote.SelselaService;
import net.selsela.carRental.util.language.LanguageUtils;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import timber.log.Timber;

@Singleton
public class DataManager {

    private final SelselaService mSelselaService;
    private final PreferencesHelper mPreferencesHelper;
    private final LanguageUtils languageUtils;

    @Inject
    public DataManager(SelselaService selselaService, PreferencesHelper preferencesHelper,
                       LanguageUtils languageUtils) {
        mSelselaService = selselaService;
        mPreferencesHelper = preferencesHelper;
        this.languageUtils = languageUtils;
    }

    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }

    public LanguageUtils getLanguageUtils() {
        return languageUtils;
    }

    public company_data getUserSession() {
        return getPreferencesHelper().getCurrentUser();
    }


    int getUserId() {
        return getUserSession() != null ? getUserSession().getId() : 0;
    }

    int getType() {
        return 3;
    }


    String getUserToken() {
        return getUserSession() != null ? getUserSession().getToken() : "";
    }

    //    String getDevice_key() {
//        return getUserSession() != null ? getUserSession().getDevice_key() : "";
//
//    }
    @android.support.annotation.NonNull
    public Observable<BaseResponse<LoginData>> makeLogin(final UserBody userData) {

        return mSelselaService.login(userData)
                .concatMap(new Function<BaseResponse<LoginData>, ObservableSource<? extends BaseResponse<LoginData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<LoginData>> apply(final BaseResponse<LoginData> loginResponse) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<LoginData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<LoginData>> e) {
                                try {
                                    company_data user = loginResponse.getData().getUserData();
                                      getPreferencesHelper().addUserSession(user);
                                    if (!languageUtils.isArabic())
                                        loginResponse.setResponseMessage(loginResponse.getResponseMessage());
                                    e.onNext(loginResponse);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();


                            }
                        });
                    }
                });
    }

    @android.support.annotation.NonNull
    public Observable<BaseResponse<LoginData>> makeLogout(final UserBody userData) {

        return mSelselaService.Logout(userData)
                .concatMap(new Function<BaseResponse<LoginData>, ObservableSource<? extends BaseResponse<LoginData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<LoginData>> apply(final BaseResponse<LoginData> loginResponse) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<LoginData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<LoginData>> e) {
                                try {

                                    e.onNext(loginResponse);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();


                            }
                        });
                    }
                });
    }

    public Observable<BaseResponse<ConfigData>> getSettingData() {

        return mSelselaService.get_config(getType())
                .concatMap(new Function<BaseResponse<ConfigData>, ObservableSource<? extends BaseResponse<ConfigData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<ConfigData>> apply(final BaseResponse<ConfigData> settingResponse) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<ConfigData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<ConfigData>> e) throws Exception {

                                try {
                                    getPreferencesHelper().addUserSetting(settingResponse.getData());
                                    e.onNext(settingResponse);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                })
                ;
    }

    public Observable<BaseResponse<LoginData>> update_device_keyٍ() {

        return mSelselaService.update_device_key(mPreferencesHelper.getNotifToken(), getUserId(), getType())
                .concatMap(new Function<BaseResponse<LoginData>, ObservableSource<? extends BaseResponse<LoginData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<LoginData>> apply(final BaseResponse<LoginData> loginResponse) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<LoginData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<LoginData>> e) throws Exception {
                                try {
                                    Timber.d("updateDeviceKey %s", loginResponse);
                                    if (!languageUtils.isArabic())
                                        loginResponse.setResponseMessage(loginResponse.getResponseMessage());
                                    e.onNext(loginResponse);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });

    }

    @android.support.annotation.NonNull
    public Observable<BaseResponse<LoginData>> makeRegister(final UserBody userData) {

        return mSelselaService.register(userData)
                .concatMap(new Function<BaseResponse<LoginData>, ObservableSource<? extends BaseResponse<LoginData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<LoginData>> apply(final BaseResponse<LoginData> response) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<LoginData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<LoginData>> e) {
                                company_data user = response.getData().getUserData();
                                getPreferencesHelper().addUserSession(user);

                                try {

                                    e.onNext(response);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });
    }

    public Observable<BaseResponse> forget_password(final UserBody userData) {
        return mSelselaService.forget_password(userData)
                .concatMap(new Function<BaseResponse, ObservableSource<? extends BaseResponse>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse> apply(final BaseResponse response) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse> e) throws Exception {
                                try {
                                    if (response.getStatus()) {
                                        e.onNext(response);
                                    } else e.onNext(null);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });
    }

    public Observable<BaseResponse> postContact(UserBody postBody) {
        return mSelselaService.contact_us(postBody)
                .concatMap(new Function<BaseResponse, ObservableSource<? extends BaseResponse>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse> apply(final BaseResponse response) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse> e) {
                                try {
                                    e.onNext(response);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();

                            }
                        });
                    }
                });
    }

    @android.support.annotation.NonNull
    public Observable<BaseResponse<LoginData>> upate_profile(final UserBody userData) {

        return mSelselaService.update_profile(userData)
                .concatMap(new Function<BaseResponse<LoginData>, ObservableSource<? extends BaseResponse<LoginData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<LoginData>> apply(final BaseResponse<LoginData> loginResponse) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<LoginData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<LoginData>> e) {
                                try {
                                    if (loginResponse.getStatus()) {
                                        company_data responseUSer = loginResponse.getData().getUserData();
                                        getPreferencesHelper().addUserSession(responseUSer);
                                    }

                                    e.onNext(loginResponse);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();


                            }
                        });
                    }
                });
    }


    public Observable<BaseResponse<LoginData>> changePassword(UserBody userBody) {
        return mSelselaService.changePassword(userBody)
                .concatMap(new Function<BaseResponse<LoginData>, ObservableSource<? extends BaseResponse<LoginData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<LoginData>> apply(final BaseResponse<LoginData> response) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<LoginData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<LoginData>> e) {
                                try {
                                    e.onNext(response);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();

                            }
                        });
                    }
                });
    }

    ///////////////////////////////////////////////////



    @android.support.annotation.NonNull
    public Observable<BaseResponse<ProblemData>> confirm_problem(final UserBody userData) {

        return mSelselaService.confirmProblem(userData)
                .concatMap(new Function<BaseResponse<ProblemData>, ObservableSource<? extends BaseResponse<ProblemData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<ProblemData>> apply(final BaseResponse<ProblemData> response) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<ProblemData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<ProblemData>> e) {

                                try {

                                    e.onNext(response);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });
    }

    @android.support.annotation.NonNull
    public Observable<BaseResponse<ProblemData>> add_problem(final UserBody userData) {

        return mSelselaService.add_problem_cost(userData)
                .concatMap(new Function<BaseResponse<ProblemData>, ObservableSource<? extends BaseResponse<ProblemData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<ProblemData>> apply(final BaseResponse<ProblemData> response) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<ProblemData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<ProblemData>> e) {

                                try {

                                    e.onNext(response);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });
    }






    public Observable<List<Country>> getCountry() {
        return mSelselaService.get_countries()
                .concatMap(new Function<BaseResponse<CountryData>, ObservableSource<? extends List<Country>>>() {
                    @Override
                    public ObservableSource<? extends List<Country>> apply(final BaseResponse<CountryData> response) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<List<Country>>() {
                            @Override
                            public void subscribe(ObservableEmitter<List<Country>> e) {
                                try {
                                    if (response.getStatus()) {
                                        e.onNext(response.getData().getCountries());
                                    } else e.onNext(null);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });
    }


    public Observable<BaseResponse<HomeData>> gethome() {
        return mSelselaService.get_home(getUserId(),getUserToken())
                .concatMap(new Function<BaseResponse<HomeData>, ObservableSource<? extends BaseResponse<HomeData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<HomeData>> apply(final BaseResponse<HomeData> response) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<HomeData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<HomeData>> e) throws Exception {
                                try {
                                    if (response.getStatus()) {
                                        e.onNext(response);
                                    } else e.onNext(null);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });

    }









    public Observable<BaseResponse<AboutData>> get_about_page() {
        Observable<BaseResponse<AboutData>> observable = mSelselaService.get_about_page();
        return observable
                .concatMap(new Function<BaseResponse<AboutData>, ObservableSource<? extends BaseResponse<AboutData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<AboutData>> apply(final BaseResponse<AboutData> aboutResponse) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<AboutData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<AboutData>> e) throws Exception {
                                try {
                                    Timber.d("aboutResponse %s", aboutResponse);
                                    e.onNext(aboutResponse);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                })
                ;
    }


    public Observable<BaseResponse<ProblemData>> getReports() {
        return mSelselaService.getReports(getUserId(), getUserToken())
                .concatMap(new Function<BaseResponse<ProblemData>, ObservableSource<? extends BaseResponse<ProblemData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<ProblemData>> apply(final BaseResponse<ProblemData> response) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<ProblemData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<ProblemData>> e) throws Exception {
                                try {
                                    if (response.getStatus()) {
                                        e.onNext(response);
                                    } else e.onNext(null);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });

    }

    public Observable<BaseResponse<oneProblemData>> view_problem(int problem_id) {
        return mSelselaService.viewProblem(problem_id)
                .concatMap(new Function<BaseResponse<oneProblemData>, ObservableSource<? extends BaseResponse<oneProblemData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<oneProblemData>> apply(final BaseResponse<oneProblemData> response) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<oneProblemData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<oneProblemData>> e) throws Exception {
                                try {
                                    if (response.getStatus()) {
                                        e.onNext(response);
                                    } else e.onNext(null);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });

    }

    public Observable<BaseResponse<Datum>> getFlate_problem(int flat_id) {
        return mSelselaService.flatProblems(getUserId(), getUserToken(),flat_id)
                .concatMap(new Function<BaseResponse<Datum>, ObservableSource<? extends BaseResponse<Datum>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<Datum>> apply(final BaseResponse<Datum> response) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<Datum>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<Datum>> e) throws Exception {
                                try {
                                    if (response.getStatus()) {
                                        e.onNext(response);
                                    } else e.onNext(null);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });

    }



    public Observable<BaseResponse<NotoficationData>> getNotification() {
        return mSelselaService.getNotofication(mPreferencesHelper.getCurrentUser().getId(), getUserToken(), 3)
                .concatMap(new Function<BaseResponse<NotoficationData>, ObservableSource<? extends BaseResponse<NotoficationData>>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse<NotoficationData>> apply(final BaseResponse<NotoficationData> response) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse<NotoficationData>>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse<NotoficationData>> e) throws Exception {
                                try {
                                    if (response.getStatus()) {
                                        e.onNext(response);
                                    } else e.onNext(null);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();
                            }
                        });
                    }
                });

    }



    public Observable<BaseResponse> deleteNotification( UserBody userBody) {
        return mSelselaService.deleteNotification(userBody)
                .concatMap(new Function<BaseResponse, ObservableSource<? extends BaseResponse>>() {
                    @Override
                    public ObservableSource<? extends BaseResponse> apply(final BaseResponse response) {
                        return Observable.create(new ObservableOnSubscribe<BaseResponse>() {
                            @Override
                            public void subscribe(ObservableEmitter<BaseResponse> e) {
                                try {
                                    e.onNext(response);
                                } catch (Exception e1) {
                                    e.onError(e1);
                                }
                                e.onComplete();

                            }
                        });
                    }
                });
    }
}