package com.jcsd.domodroid.helper;

import com.jcsd.domodroid.config.DomoSettings;

public class SettingHelper {

	public static void init() {
		DomoSettings.scheme = "http";
		DomoSettings.host = "hal9000";
		DomoSettings.port = 80;
		DomoSettings.path = "domo/devices";
	}
}
