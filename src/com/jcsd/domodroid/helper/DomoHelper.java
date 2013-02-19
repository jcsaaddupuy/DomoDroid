package com.jcsd.domodroid.helper;

import android.content.Context;
import android.widget.Toast;

import com.jcsd.domodroid.devices.Command;
import com.jcsd.domodroid.devices.Device;
import com.jcsd.domodroid.helper.HttpBackgroundHelper.HttpBackgroundHelperHandler;

public class DomoHelper {

	public static void execute(final Context context, Device dev, Command cmd) {

		String rqt = CommandHelper.getUrl(dev, cmd);
		new HttpBackgroundHelper(new HttpBackgroundHelperHandler() {

			@Override
			public void onSuccess(String result) {
				Toast toast = Toast.makeText(context,
						result == null ? "Response null" : result,
						Toast.LENGTH_SHORT);
				toast.show();

			}

			@Override
			public void onException(Exception e) {
				Toast toast = Toast.makeText(context, "Error",
						Toast.LENGTH_SHORT);
				toast.show();

			}
		}).execute(rqt);
	}
}
