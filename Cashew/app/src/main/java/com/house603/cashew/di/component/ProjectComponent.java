package com.house603.cashew.di.component;


import com.roxwin.widgetcontact.feature.callKeyboard.view.CallKeyboardDailActivity;
import com.roxwin.widgetcontact.feature.circleMenu.view.MenuCircleWidgetActivity;
import com.roxwin.widgetcontact.feature.contactProfileDisplay.view.ContactProfileActivity;
import com.roxwin.widgetcontact.feature.createContact.view.CreateContactActivity;
import com.roxwin.widgetcontact.feature.facebook.view.FacebookFriendListActivity;
import com.roxwin.widgetcontact.feature.feedBack.feedBackTopic.view.FeedBackTopicActivity;
import com.roxwin.widgetcontact.feature.feedBack.view.FeedBackActivity;
import com.roxwin.widgetcontact.feature.main.view.MainActivity;
import com.roxwin.widgetcontact.feature.note.view.NoteActivity;
import com.roxwin.widgetcontact.feature.reminder.view.ReminderListContactActivity;
import com.roxwin.widgetcontact.feature.reminderEditScreen.view.ReminderEditScreenActivity;
import com.roxwin.widgetcontact.feature.reminderList.view.AllReminderListActivity;
import com.roxwin.widgetcontact.feature.showContactFrom.view.ShowContactFromActivity;
import com.roxwin.widgetcontact.feature.widget.service.appConfig.view.AppWidgetConfigActivity;
import com.roxwin.widgetcontact.feature.widgetPreview.view.WidgetPreviewActivity;
import com.roxwin.widgetcontact.feature.widgetSettings.view.WidgetSettingsActivity;
import com.roxwin.widgetcontact.internal.di.PerActivity;
import com.roxwin.widgetcontact.internal.di.module.ProjectModule;

import dagger.Component;

/**
 * Created by Enny on 29/11/2016.
 */
@PerActivity
@Component(modules = ProjectModule.class)
public interface ProjectComponent {
    void inject(WidgetSettingsActivity activity);
    void inject(AppWidgetConfigActivity activity);
    void inject(ShowContactFromActivity activity);
    void inject(MenuCircleWidgetActivity activity);
    void inject(WidgetPreviewActivity activity);
    void inject(FacebookFriendListActivity activity);
    void inject(FeedBackActivity activity);
    void inject(FeedBackTopicActivity activity);
    void inject(MainActivity activity);
    void inject(ContactProfileActivity activity);
    void inject(NoteActivity activity);
    void inject(CallKeyboardDailActivity activity);
    void inject(CreateContactActivity activity);
    void inject(ReminderListContactActivity activity);
    void inject(ReminderEditScreenActivity activity);
    void inject(AllReminderListActivity activity);
}
