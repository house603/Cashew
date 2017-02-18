package com.house603.cashew.di.component;



import com.house603.cashew.di.PerActivity;
import com.house603.cashew.di.module.ProjectModule;
import com.house603.cashew.feature.main.view.MainActivity;

import dagger.Component;

/**
 * Created by Enny on 29/11/2016.
 */
@PerActivity
@Component(modules = ProjectModule.class)
public interface ProjectComponent {
    void inject(MainActivity activity);

}
