package com.house603.cashew.di.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;



import com.house603.cashew.AppApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Enny on 29/11/2016.
 */
@Module
public class ApplicationModule {
    private AppApplication mApp;

    public ApplicationModule(AppApplication app) {
        mApp = app;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs() {
        return PreferenceManager.getDefaultSharedPreferences(mApp);
    }

    //    @Provides
//    BoiTinhYeuHelper provideBoiTinhYeuHelper() {
//        return new BoiTinhYeuHelper(mApp);
//    }
//
//    @Provides
//    DanhNgonHelper provideDanhNgonHelper() {
//        return new DanhNgonHelper(mApp);
//    }
//
//
//    @Provides
//    KeTanGaiHelper provideKeTanGaiHelper() {
//        return new KeTanGaiHelper(mApp);
//    }
//
//    @Provides
//    @Singleton
//    DAOFactory provideSqliteDao() {
//        return new SqliteDAOFactory(mApp);
//    }
//
//    @Provides
//    @Singleton
//    ContactDAO provideContactDAO() {
//        return new ContactDAO(mApp, new SqliteDAOFactory(mApp).getConnection());
//    }
//
//    @Provides
//    @Singleton
//    SimContactDAO provideSimContactDAO() {
//        return new SimContactDAO(mApp, new SqliteDAOFactory(mApp).getConnection());
//    }
//
//    @Provides
//    @Singleton
//    ReminderDAO provideReminderDAO() {
//        return new ReminderDAO(mApp, new SqliteDAOFactory(mApp).getConnection());
//    }


}