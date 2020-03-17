package net.selsela.carRental.injection.component;

import dagger.Component;
import net.selsela.carRental.injection.PerActivity;
import net.selsela.carRental.injection.module.ActivityModule;
import net.selsela.carRental.ui.about_us.About_Us_Activity;
import net.selsela.carRental.ui.account.ProfileActivity;
import net.selsela.carRental.ui.archives_orders.Archives_ordersActivity;
import net.selsela.carRental.ui.auoth.ForgetPasswordActivity;
import net.selsela.carRental.ui.auoth.LoginActivity;
import net.selsela.carRental.ui.auoth.RegisterActivity;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.ui.base.BaseFragment;
import net.selsela.carRental.ui.car_details.Car_detailsActivity;
import net.selsela.carRental.ui.contact_us.ContactUsActivity;

import net.selsela.carRental.ui.explore.ExploreFragment;
import net.selsela.carRental.ui.intro.IntroActivity;
import net.selsela.carRental.ui.main.HomeFragment;
import net.selsela.carRental.ui.main.MainActivity;
import net.selsela.carRental.ui.main.SplachActivity;
import net.selsela.carRental.ui.notifications.NotificationsActivity;
import net.selsela.carRental.ui.order.OrderActivity;
import net.selsela.carRental.ui.order.PersonalInfoActivity;
import net.selsela.carRental.ui.order.SuccessOrderActivity;
import net.selsela.carRental.ui.settings.SettingsFragment;


/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {


    void inject(BaseActivity baseActivity);

    void inject(IntroActivity introActivity);


    void inject(OrderActivity orderActivity);
    void inject(Archives_ordersActivity archives_ordersActivity);


    void inject(SuccessOrderActivity successOrderActivity);


    void inject(BaseFragment baseFragment);
    void inject(SettingsFragment settingsFragment);


    void inject(Car_detailsActivity car_detailsActivity);

    void inject(PersonalInfoActivity personalInfoActivity);




    void inject(ExploreFragment exploreFragment);

    void inject(LoginActivity loginActivity);


    void inject(ForgetPasswordActivity forgetPasswordActivity);


    void inject(NotificationsActivity notificationsActivity);

    void inject(SplachActivity splachActivity);

    void inject(MainActivity mainActivity);

    void inject(About_Us_Activity about_us_activity);
    void inject(ProfileActivity profileActivity);
    void inject(HomeFragment homeFragment);
    void inject(ContactUsActivity contactUsActivity);
    void inject(RegisterActivity registerActivity);

















}
