package com.house603.cashew.di.component;




import com.house603.cashew.AppApplication;
import com.house603.cashew.base.BaseActionbarActivity;
import com.house603.cashew.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by Enny on 29/11/2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(AppApplication app);
    void inject(BaseActionbarActivity activity);

//    void inject(LocalDataSource localDataSource);
}
