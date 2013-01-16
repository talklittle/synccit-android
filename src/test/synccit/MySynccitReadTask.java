package test.synccit;

import java.util.HashSet;

import com.synccit.android.SynccitReadTask;
import com.synccit.android.SynccitResponse;

public class MySynccitReadTask extends SynccitReadTask {

	// CHANGE THIS!
	private static final String MY_DEV_NAME = "synccit_android_test";
	
	private MainActivity mActivity;
	
	public MySynccitReadTask(MainActivity activity) {
		super(MY_DEV_NAME);
		mActivity = activity;
	}

	@Override
	protected void onVisited(HashSet<String> visitedThreadIds) {
		mActivity.setVisited(visitedThreadIds);
	}

	@Override
	protected void onPostExecute(SynccitResponse result) {
		super.onPostExecute(result);
		mActivity.refresh();
	}

	@Override
	protected String getUsername() {
		return "synccit_android_test";
	}

	@Override
	protected String getAuth() {
		return "mm8kc3";
	}

	@Override
	protected String getUserAgent() {
		return "synccit_android_test";
	}

}
