package com.jcsd.domodroid.helper;

import com.jcsd.domodroid.config.DomoSettings;
import com.jcsd.domodroid.devices.Command;
import com.jcsd.domodroid.devices.Device;

public class CommandHelper {

	public static String getUrl(Device device, Command command) {

		return getUrl(device.ref, command.ref);
	}

	public static String getUrl(String deviceref, String commandref) {
		return String.format("%s://%s:%s/%s/%s/%s", DomoSettings.scheme,
				DomoSettings.host, DomoSettings.port, DomoSettings.path,
				deviceref, commandref);
	}
}
