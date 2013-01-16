package com.synccit.android;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import org.json.JSONObject;

public abstract class SynccitReadTask extends SynccitTask {
	
	private static final String READ_MODE = "read";
	
	public SynccitReadTask(String devName) {
		super(devName);
	}

	@Override
	protected String getMode() {
		return READ_MODE;
	}

	@Override
	protected SynccitResponse onInput(InputStream in) throws Exception {
		HashSet<String> visitedLinkIds = new HashSet<String>();
		
		// read the entire stream into a String
		Scanner s = new Scanner(in);
		String json = s.useDelimiter("\\A").next();
		
		JSONObject node = new JSONObject(json);
		if (node.has("error")) {
			return new SynccitResponse("error", node.get("error").toString());
		}
		
		@SuppressWarnings("rawtypes")
		Iterator keys = node.keys();
		
		while (keys.hasNext()) {
			String key = keys.next().toString();
			JSONObject linkNode = (JSONObject) node.get(key);
			visitedLinkIds.add(linkNode.get("id").toString());
		}
		
		onVisited(visitedLinkIds);
		
		return null;
	}
	
	protected abstract void onVisited(HashSet<String> visitedThreadIds);

}
