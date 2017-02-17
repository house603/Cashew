package com.house603.cashew.di.module;

import android.app.Activity;


import com.house603.cashew.di.PerActivity;
import com.house603.cashew.feature.main.presenter.presenterImpl.MainPresenterImpl;
import com.house603.cashew.feature.main.presenter.view.MainPresenter;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Enny  on 29/11/2016.
 */
@Module(includes = ApplicationModule.class)
public class ProjectModule {
    private final Activity activity;

    public ProjectModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }

    @Provides
    MainPresenter provideMainPresenter() {
        return new MainPresenterImpl();
    }
//
//    @Provides
//    AppWidgetConfigPresenter provideAppWidgetConfigPresenter(){
//        return new AppConfigPresenterImpl();
//    }
//
//    @Provides
//    ShowContactPresenter provideShowContactPresenter(){
//        return new ShowContactFromPresenterImpl();
//    }
//    @Provides
//    MenuCirclePresenter provideMenuCirclePresenter(){
//        return new MenuCirclePresenterImpl();
//    }
//    @Provides
//    WidgetPreviewPresenter provideWidgetPreviewPresenter(){
//        return new WidgetPreviewPresenterImpl();
//    }
//    @Provides
//    FacebookFreindListPresenter provideFacebookFreindListPresenter(){
//        return new FacebookFreindListPresenterImpl();
//    }
//    @Provides
//    FeedBackPresenter provideFeeedBackPresenter(){
//        return new FeedBackPresenterImpl();
//    }
//
//    @Provides
//    FeedBackTopicPresenter provideFeeedBackTopicPresenter(){
//        return new FeedbackTopicPresenterImp();
//    }
//    @Provides
//    MainActivityPresenter provideMainActivityPresenter(){
//        return new MainActivityPresenterImpl();
//    }
//    @Provides
//    ContactProfilePresenter provideContactProfilePresenter(){
//        return new ContactProfileParesenterImp();
//    }
//
//    @Provides
//    NotePresenter provideNotePresenter(){
//        return new NotePresenterImp();
//    }
//
//    @Provides
//    CallKeyboardDailPresenter provideCallKeyboardDailPresenter(){
//        return new CallKeyboardDailPresenterImpl();
//    }
//    @Provides
//    CreateContactPresenter provideCreateContactPresenter (){
//        return new CreateContactPresenterImpl();
//    }
//    @Provides
//    ReminderContactListPresenter provideReminderContactListPresenter (){
//        return new ReminderContactListPresenterImpl();
//    }
//
//    @Provides
//    ReminderEditScreenPresenter provideReminderEditScreenPresenter(){
//        return new ReminderEditScreenImpl() {
//        };
//    }
//    @Provides
//    AllReminderListPresenter provideAllReminderListPresenter(){
//        return new AllReminderListImpl() {
//        };
//    }




//    @Provides
//    ShowTweetFromPresenter provideShowTweetFromPresenter() {
//        return new ShowTweetFromPresenterImp();
//    }
//    @Provides
//    WidgetPreviewPresenter provideWidgetPreviewPresenter() {
//        return new WidgetPreviewPresenterImp();
//    }
////
//    @Provides
//    OpenWithPresenter provideOpenWithPresenter() {
//        return new OpenWithPresenterImpl();
//    }
//    @Provides
//    FeedBackPresenter provideFeedBackPresenter() {
//        return new FeedBackPresenterImpl();
//    }
//
//    @Provides
//    FeedBackTopicPresenter provideFeedBackTopicPresenter() {
//        return new FeedbackTopicPresenterImp();
//    }
//    @Provides
//    ListKeSachPresenter provideListKeSachPresenter() {
//        return new ListKeSachPresenterImp(new KeSachUseCase(RxRepository.getInstance(
//                RemoteDataSource.getInstance(),
//                LocalDataSource.getInstance(activity))));
//    }
//    @Provides
//    ViewKeSachPresenter provideViewKeSachPresenter() {
//        return new ViewKeSachPresenterImp(new KeSachUseCase(RxRepository.getInstance(
//                RemoteDataSource.getInstance(),
//                LocalDataSource.getInstance(activity))));
//    }
//
//    @Provides
//    ViewImagePresenter provideViewImagePresenter() {
//        return new ViewImagePresenterImp(new ViewImageUseCase(RxRepository.getInstance(
//            RemoteDataSource.getInstance(),
//            LocalDataSource.getInstance(activity))));
//    }
//    @Provides
//    ViewPhotoPresenter provideViewPhtoPresenter() {
//        return new ViewPhotoPresenterImp(new ViewImageUseCase(RxRepository.getInstance(
//            RemoteDataSource.getInstance(),
//            LocalDataSource.getInstance(activity))));
//    }
//
//    @Provides
//    Techniques provideTechniques() {
//        return getTechniques();
//    }
//
//    @NonNull
//    private Techniques getTechniques() {
//        int ran = new Random().nextInt(63);
//        switch (ran) {
//            case 1:
//                return Techniques.DropOut;
//            case 2:
//                return Techniques.Landing;
//
//            case 4:
//                return Techniques.Flash;
//            case 5:
//                return Techniques.Pulse;
//            case 6:
//                return Techniques.RubberBand;
//            case 7:
//                return Techniques.Shake;
//            case 8:
//                return Techniques.Swing;
//            case 9:
//                return Techniques.Wobble;
//            case 10:
//                return Techniques.Bounce;
//            case 11:
//                return Techniques.Tada;
//            case 12:
//                return Techniques.StandUp;
//            case 13:
//                return Techniques.Wave;
//            case 15:
//                return Techniques.RollIn;
//            case 17:
//                return Techniques.BounceIn;
//            case 18:
//                return Techniques.BounceInDown;
//            case 19:
//                return Techniques.BounceInLeft;
//            case 20:
//                return Techniques.BounceInRight;
//            case 21:
//                return Techniques.BounceInUp;
//
//            case 22:
//                return Techniques.FadeIn;
//            case 23:
//                return Techniques.FadeInUp;
//            case 24:
//                return Techniques.FadeInDown;
//            case 25:
//                return Techniques.FadeInLeft;
//            case 26:
//                return Techniques.FadeInRight;
//
//
//            case 32:
//                return Techniques.FlipInX;
//            case 35:
//                return Techniques.RotateIn;
//            case 36:
//                return Techniques.RotateInDownLeft;
//            case 37:
//                return Techniques.RotateInDownRight;
//            case 38:
//                return Techniques.RotateInUpLeft;
//            case 39:
//                return Techniques.RotateInUpRight;
//
//            case 45:
//                return Techniques.SlideInLeft;
//            case 46:
//                return Techniques.SlideInRight;
//            case 47:
//                return Techniques.SlideInUp;
//            case 48:
//                return Techniques.SlideInDown;
//
//
//            case 53:
//                return Techniques.ZoomIn;
//            case 54:
//                return Techniques.ZoomInDown;
//            case 55:
//                return Techniques.ZoomInLeft;
//            case 56:
//                return Techniques.ZoomInRight;
//            case 57:
//                return Techniques.ZoomInUp;
//
//        }
//        return Techniques.Shake;
//    }
}
