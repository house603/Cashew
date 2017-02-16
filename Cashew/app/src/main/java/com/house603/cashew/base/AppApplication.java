package com.house603.cashew.base;

import android.app.Application;

import com.house603.cashew.di.component.ApplicationComponent;
import com.house603.cashew.di.module.ApplicationModule;

/**
 * Created by Admin on 2/16/2017.
 */

public class AppApplication  extends Application {
    private static AppApplication application;
    private ApplicationComponent mComponent;
    @Inject
    public ContactDAO mContactDao;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        initApplication();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        // initImageLoader();
    }


    private void initApplication() {
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mComponent.inject(this);
    }


    public static AppApplication get() {
        return application;
    }

//    private void initImageLoader() {
//        WebView webView = new WebView(this);
//        webView.setWebChromeClient(new WebChromeClient());
//        String userAgent = webView.getSettings().getUserAgentString();
//
//        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        Point pointSize = new Point();
//        display.getSize(pointSize);
//
//        int width = pointSize.x * 3 / 4;
//        int height = pointSize.y * 3 / 4;
//        ImageLoaderConfiguration config =
//                new ImageLoaderConfiguration.Builder(getApplicationContext()).threadPriority(Thread.NORM_PRIORITY
//                        - 2)
//                        .threadPoolSize(3)
//                        .imageDownloader(new AuthImageDownloader(this, 5000, 20000, userAgent))
//                        .denyCacheImageMultipleSizesInMemory()
//                        .memoryCacheSizePercentage(10)
//                        .diskCacheSize(50 * 1024 * 1024)
//                        .diskCacheFileNameGenerator(new Md5FileNameGenerator())
//                        .diskCacheExtraOptions(width, height, null)
//                        .tasksProcessingOrder(QueueProcessingType.LIFO)
//                        .build();
//        ImageLoader.getInstance().init(config);
//        RequestManager.init(this);
//        ImageCacheManager.init(this);
//    } {
}
