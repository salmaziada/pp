package net.selsela.carRental.injection.component;

import dagger.Component;
import net.selsela.carRental.data.SyncService;
import net.selsela.carRental.injection.PerService;
import net.selsela.carRental.injection.module.ServiceModule;
import net.selsela.carRental.util.notification.MyFirebaseMessagingService;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

    void inject(MyFirebaseMessagingService myFirebaseMessagingService);

}