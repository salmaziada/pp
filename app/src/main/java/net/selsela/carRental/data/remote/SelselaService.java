package net.selsela.carRental.data.remote;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import io.reactivex.Observable;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import net.selsela.carRental.data.local.PreferencesHelper;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.about.AboutData;
import net.selsela.carRental.data.model.client_proplem.Datum;
import net.selsela.carRental.data.model.client_proplem.ProblemData;
import net.selsela.carRental.data.model.client_proplem.oneProblemData;
import net.selsela.carRental.data.model.config.ConfigData;
import net.selsela.carRental.data.model.countries.CountryData;
import net.selsela.carRental.data.model.home.HomeData;
import net.selsela.carRental.data.model.invoice.InvoiceData;
import net.selsela.carRental.data.model.myflats.FlatData;
import net.selsela.carRental.data.model.myflats.FlatDetailsData;
import net.selsela.carRental.data.model.notification.NotoficationData;
import net.selsela.carRental.data.model.user.LoginData;
import net.selsela.carRental.data.model.user.UserBody;
import net.selsela.carRental.util.RxErrorHandlingCallAdapterFactory;
import net.selsela.carRental.util.language.LanguageUtils;

public interface SelselaService {

    String ENDPOINT = "http://selsela.info/appState/public/api/";
    String IMAGE_URL = "http://selsela.info/appState/public/uploads/";

    @POST("login")
    Observable<BaseResponse<LoginData>> login(@Body UserBody userBody);

    @POST("Logout")
    Observable<BaseResponse<LoginData>> Logout(@Body UserBody userBody);

    @POST("update_device_key")
    Observable<BaseResponse<LoginData>> update_device_key( @Query("device_key") String device_key, @Query("id") int id, @Query("type") int type);

    @POST("register")
    Observable<BaseResponse<LoginData>> register(@Body UserBody userBody);

    @POST("forget_password")
    Observable<BaseResponse> forget_password(@Body UserBody userBody);


    @POST("contactUs")
    Observable<BaseResponse> contact_us(@Body UserBody body);

    @POST(" update_profile")

    Observable<BaseResponse<LoginData>>  update_profile (@Body UserBody body);

    @POST("change_password")
    Observable<BaseResponse<LoginData>> changePassword(@Body UserBody userBody);


    @POST("client/joinToFlat")
    Observable<BaseResponse<FlatData>> join_flate(@Body UserBody userBody);

    @POST("client/confirmPayment")
    Observable<BaseResponse<InvoiceData>>confirmPayment(@Body MultipartBody userBody);


    @POST("company/confirmProblem")
    Observable<BaseResponse<ProblemData>> confirmProblem(@Body UserBody userBody);
    @POST(" company/addProblemCost")
    Observable<BaseResponse<ProblemData>> add_problem_cost(@Body UserBody userBody);
    @POST("delete_notification")
    Observable<BaseResponse> deleteNotification(@Body UserBody userBody);


    ///////////////////// //get

    @GET("get_config")
    Observable<BaseResponse<ConfigData>> get_config(@Query("type") int type );

    @GET("get_countries")
    Observable<BaseResponse<CountryData>> get_countries();


    @GET(" client/allMyFlats")
    Observable<BaseResponse<FlatData>> getallFlats(@Query("client_id") int client_id,@Query("token") String token);

    @GET(" client/accounting")
    Observable<BaseResponse<InvoiceData>> getInvoices(@Query("client_id") int client_id, @Query("token") String token);

    @GET("company/home")
    Observable<BaseResponse<HomeData>> get_home(@Query("company_id") int company_id,@Query("token") String token);

    @GET("viewFlat")
    Observable<BaseResponse<FlatDetailsData>> getDetailsFalte(@Query("client_id") int client_id, @Query("flat_id") int flat_id);

    @GET("about")
    Observable<BaseResponse<AboutData>> get_about_page();

    @GET("company/problems")
    Observable<BaseResponse<ProblemData>> getReports(@Query("company_id") int client_id,@Query("token") String token);

    @GET("viewProblem")
    Observable<BaseResponse<oneProblemData>> viewProblem(@Query("problem_id") int problem_id);

    @GET("notifications")
    Observable<BaseResponse<NotoficationData>> getNotofication(@Query("id") int id, @Query("token") String token ,@Query("type") int type);

    @GET("company/flatProblems")
    Observable<BaseResponse<Datum>> flatProblems(@Query("company_id") int company_id, @Query("token") String token , @Query("flat_id") int flat_id);

    /******** Helper class that sets up a new services *******/

    class Creator {

        public static SelselaService newRibotsService(Context context) {
            final PreferencesHelper sharedPreferences = new PreferencesHelper(context);
            final LanguageUtils mLanguageUtils = new LanguageUtils(context, sharedPreferences);
            Gson gson = new GsonBuilder()
                    //.registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create())
                    .excludeFieldsWithoutExposeAnnotation()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                    .create();

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Accept", "application/json")
                            .addHeader("Content-Type", "application/x-www-form-urlencoded")
                            .addHeader("X-Requested-With", "XMLHttpRequest")
                            //.addHeader("Authorization", "Bearer " + )
                            .addHeader("language", mLanguageUtils.getCurrentLang())
                            .build();
                    return chain.proceed(newRequest);
                }
            }).build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(SelselaService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                    .client(client)
                    .build();
            return retrofit.create(SelselaService.class);
        }
    }
}
