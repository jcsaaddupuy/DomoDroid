package com.jcsd.domodroid.fragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.jcsd.domodroid.R;
import com.jcsd.domodroid.adapters.DeviceListAdapter;
import com.jcsd.domodroid.devices.Device;
import com.jcsd.domodroid.helper.DeviceHelper;

public class DevicesSectionFragments extends ListFragment {
	/**
	 * The fragment argument representing the section number for this fragment.
	 */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// setContentView(R.layout.devices_fragment_layout);

		/**
		 * ListAdapter will get info from dataArray and put it to the list
		 */
		List<Device> list = new ArrayList<Device>(DeviceHelper.DEVICES.values());

		ListAdapter listAdapter = new DeviceListAdapter(getActivity(),
				R.layout.device_row_layout, list);

		setListAdapter(listAdapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.devices_fragment_layout, container,
				false);
	}
}
