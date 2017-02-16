package com.house603.cashew.di.component;

import com.roxwin.widgetcontact.AppApplication;
import com.roxwin.widgetcontact.base.BaseActionbarActivity;
import com.roxwin.widgetcontact.internal.di.module.ApplicationModule;

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
