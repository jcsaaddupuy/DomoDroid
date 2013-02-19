package com.jcsd.domodroid.adapters;
import com.jcsd.domodroid.R;
import com.jcsd.domodroid.R.id;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class DeviceListViewCache {

	private View baseView;
	private TextView textNameDevice;
	private TextView textWikiDevice;
	private ImageView imageDevice;

	public DeviceListViewCache(View baseView) {
		this.baseView = baseView;
	}

	public View getViewBase() {
		return baseView;
	}

	public TextView getTextNameDevice(int resource) {
		if (textNameDevice == null) {
			textNameDevice = (TextView) baseView.findViewById(R.id.deviceName);
		}
		return textNameDevice;
	}

	public TextView getTextRefDevice(int resource) {
		if (textWikiDevice == null) {
			textWikiDevice = (TextView) baseView.findViewById(R.id.deviceRef);
		}
		return textWikiDevice;
	}

	public ImageView getImageView(int resource) {
		if (imageDevice == null) {
			imageDevice = (ImageView) baseView.findViewById(R.id.Imagedevice);
		}
		return imageDevice;
	}
}