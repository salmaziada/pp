package net.selsela.carRental.injection.component;

import android.app.Application;
import android.content.Context;

import net.selsela.carRental.data.DataManager;
import net.selsela.carRental.data.SyncService;
import net.selsela.carRental.data.local.PreferencesHelper;
import net.selsela.carRental.data.local.UserSession;
import net.selsela.carRental.data.remote.SelselaService;
import net.selsela.carRental.injection.ApplicationContext;
import net.selsela.carRental.injection.module.ApplicationModule;
import net.selsela.carRental.util.RxEventBus;
import net.selsela.carRental.util.language.LanguageUtils;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(SyncService syncService);

    @ApplicationContext
    Context context();

    Application application();

    SelselaService ribotsService();

    PreferencesHelper preferencesHelper();

    DataManager dataManager();

    RxEventBus eventBus();

    UserSession userSession();

    LanguageUtils languageUtils();

}
