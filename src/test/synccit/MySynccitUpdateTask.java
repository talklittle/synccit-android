package test.synccit;

import com.synccit.android.SynccitUpdateTask;

public class MySynccitUpdateTask extends SynccitUpdateTask {

	// CHANGE THIS!
	private static final String MY_DEV_NAME = "synccit_android_test";

	public MySynccitUpdateTask() {
		super(MY_DEV_NAME);
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
