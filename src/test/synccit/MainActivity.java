package test.synccit;

import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.synccit.android.R;

public class MainActivity extends Activity {
	
	private Set<String> visitedIds;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new Handler().postDelayed(new Runnable() {
			@Override public void run() {
				new MySynccitReadTask(MainActivity.this).execute("16noez", "16nodo");
			}
		}, 3000);
	}
	
	void setVisited(Set<String> visitedIds) {
		this.visitedIds = visitedIds;
	}
	
	void refresh() {
		if (visitedIds != null) {
			((TextView) findViewById(R.id.visited1)).setText(visitedIds.contains("16noez") ? "visited!" : "not visited");
			((TextView) findViewById(R.id.visited2)).setText(visitedIds.contains("16nodo") ? "visited!" : "not visited");
		}
	}

}
