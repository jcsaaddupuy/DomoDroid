package com.jcsd.domodroid.adapters;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcsd.domodroid.R;
import com.jcsd.domodroid.devices.Command;
import com.jcsd.domodroid.devices.Device;
import com.jcsd.domodroid.helper.DeviceHelper;
import com.jcsd.domodroid.helper.DomoHelper;

public class DeviceListAdapter extends ArrayAdapter<Device> {

	private int resource;
	private LayoutInflater inflater;
	private Context context;

	public DeviceListAdapter(Context context, int resourceId,
			List<Device> objects) {

		super(context, resourceId, objects);
		resource = resourceId;
		inflater = LayoutInflater.from(context);
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		DeviceListViewCache viewCache;

		if (convertView == null) {
			/* create a new view of my layout and inflate it in the row */
			convertView = (View) inflater.inflate(resource, null);
			viewCache = new DeviceListViewCache(convertView);
			convertView.setTag(viewCache);
		} else {
			convertView = (View) convertView;
			viewCache = (DeviceListViewCache) convertView.getTag();
		}

		/* Extract the city's object to show */
		final Device device = getItem(position);

		/* Take the TextView from layout and set the city's name */
		TextView txtName = viewCache.getTextNameDevice(resource);
		txtName.setText(device.name);

		/* Take the TextView from layout and set the city's wiki link */
		TextView txtWiki = viewCache.getTextRefDevice(resource);
		txtWiki.setText(device.ref);

		/* Take the ImageView from layout and set the city's image */

		ImageView imageCity = viewCache.getImageView(resource);
		String uri = "drawable/" + device.refIcon;
		int imageResource = context.getResources().getIdentifier(uri, null,
				context.getPackageName());
		Drawable image = context.getResources().getDrawable(imageResource);
		imageCity.setImageDrawable(image);

		LinearLayout commandsView = (LinearLayout) convertView
				.findViewById(R.id.commandsLayout);

		commandsView.removeAllViews();
		for (Command command : device.AvailablesCommands) {
			ImageButton imgCmdView = new ImageButton(context);
			String uriCommand = "drawable/" + command.refIcon;
			int cmrResource = context.getResources().getIdentifier(uriCommand,
					null, context.getPackageName());
			Drawable imageCmd = context.getResources().getDrawable(cmrResource);
			imgCmdView.setFocusable(true);
			imgCmdView.setImageDrawable(imageCmd);
			//imgCmdView.setScaleX((float) 0.75);
			//imgCmdView.setScaleY((float) 0.75);
			final Command cmd = command;
			imgCmdView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					DomoHelper.execute(context, device, cmd);

				}
			});
			commandsView.addView(imgCmdView);
		}

		return convertView;
	}
}
