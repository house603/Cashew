package com.house603.cashew.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.roxwin.widgetcontact.AppApplication;
import com.roxwin.widgetcontact.database.dao.DAOFactory;
import com.roxwin.widgetcontact.feature.main.view.MainActivity;
import com.roxwin.widgetcontact.model.ContactModel;

public abstract class BaseFragment extends Fragment {

	protected MainActivity mActivity;


	protected ContactModel mContactModel;

	protected AppApplication mApplication;

	protected DAOFactory mSqliteDAO;


	protected FragmentManager mFragmentManager;

	protected ImageLoader mImageLoader = ImageLoader.getInstance();

	protected Handler mHandler;

	public DisplayImageOptions mOptions;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mActivity = (MainActivity) getActivity();



		mApplication = (AppApplication) getActivity().getApplication();

		mSqliteDAO = DAOFactory.getDAOFactory(getActivity()
				.getApplicationContext(), DAOFactory.SQLITE_DATABASE);

		mFragmentManager = getFragmentManager();

		mHandler = new Handler();

//		mOptions = new DisplayImageOptions.Builder()
//				.showImageOnLoading(R.drawable.ic_stub)
//				.showImageForEmptyUri(R.drawable.noimage)
//				.showImageOnFail(R.drawable.noimage).cacheInMemory(true)
//				.cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565).build();
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}


	/**
	 * 
	 * @param title
	 */
	protected void setTitle(String title) {
		// MainActivity mainActivity = (MainActivity) getActivity();
		// mainActivity.setTitleText(title);
	}

	/**
	 * Init all model when onCreate activity here
	 */
	protected abstract void initModels();

	/**
	 * Init all views when onCreate activity here
	 */
	protected abstract void initViews(View view);

	/**
	 * Remove previous show dialog fragment by tag
	 * 
	 * @param tag
	 *            tag of dialog fragment
	 */
	protected void removePreviousDialog(String tag) {
		// DialogFragment.show() will take care of adding the fragment
		// in a transaction. We also want to remove any currently showing
		// dialog, so make our own transaction and take care of that here.
		FragmentTransaction ft = mFragmentManager.beginTransaction();
		Fragment prev = mFragmentManager.findFragmentByTag(tag);
		if (prev != null) {
			ft.remove(prev);
		}
		ft.commit();
	}

	// /**
	// * show alert message
	// *
	// * @param message
	// */
	// public void showAlertDialog(Context context, String message) {
	// // clear all state previous
	// removePreviousDialog("alert_dialog");
	// mAlertDialog = null;
	// // create dialog
	// mAlertDialog = AlertDialogFragment.newInstance(
	// getString(R.string.app_name), message,
	// getString(android.R.string.ok), getString(android.R.string.ok));
	// mAlertDialog.showOnlyOneButton(true);
	// // show dialog
	// mAlertDialog.show(mFragmentManager, "alert_dialog");
	// }

	// /**
	// * show alert
	// *
	// * @param context
	// * @param title
	// * @param message
	// * @param leftText
	// * @param rightText
	// * @param listener
	// */
	// public void showAlertDialog(Context context, String title, String
	// message,
	// String leftText, String rightText, AlertListener listener) {
	// // clear all state previous
	// removePreviousDialog("alert_dialog");
	// mAlertDialog = null;
	// // create dialog
	// mAlertDialog = AlertDialogFragment.newInstance(context, title, message,
	// leftText, rightText, listener);
	// // show dialog
	// mAlertDialog.show(mFragmentManager, "alert_dialog");
	// }

	/**
	 * Finish current fragment
	 */
	public void finishFragment() {
		try {
			mFragmentManager.popBackStack();
		} catch (Exception e) {
		//	LogUtils.e(e.getMessage());
		}
	}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
//		super.onCreateOptionsMenu(menu, inflater);
	}
}
