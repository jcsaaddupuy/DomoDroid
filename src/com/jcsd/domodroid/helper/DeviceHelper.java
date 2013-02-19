package com.jcsd.domodroid.helper;

import java.util.LinkedHashMap;

import com.jcsd.domodroid.devices.Command;
import com.jcsd.domodroid.devices.Device;

public class DeviceHelper {

	public static LinkedHashMap<String, Device> DEVICES = new LinkedHashMap<String, Device>();
	public static LinkedHashMap<String, Command> COMMANDS = new LinkedHashMap<String, Command>();

	public static void init() {
		initStatic();
	}

	private static void initStatic() {
		Command on = new Command("On", "on", "on");
		Command off = new Command("Off", "off", "off");
		Command reboot = new Command("Reboot", "reboot", "reboot");

		Command mpd_play = new Command("Play", "play", "play");
		Command mpd_stop = new Command("Stop", "stop", "stop");
		Command mpd_pause = new Command("Pause", "pause", "pause");

		COMMANDS.put(on.ref, on);
		COMMANDS.put(off.ref, off);
		COMMANDS.put(reboot.ref, reboot);

		Device lamp = new Device("Lamp", "lamp", "bulb");
		Device screen = new Device("Screen", "screen", "tv");
		Device fan = new Device("Fan", "fan", "fan");
		Device box = new Device("Box", "box", "router");

		Device mpd = new Device("MPD", "mpd", "music");

		Device all = new Device("All", "all", "home");

		lamp.AvailablesCommands.add(on);
		lamp.AvailablesCommands.add(off);

		screen.AvailablesCommands.add(on);
		screen.AvailablesCommands.add(off);

		fan.AvailablesCommands.add(on);
		fan.AvailablesCommands.add(off);

		box.AvailablesCommands.add(reboot);

		// all.AvailablesCommands.add(on);
		all.AvailablesCommands.add(off);

		mpd.AvailablesCommands.add(mpd_play);
		mpd.AvailablesCommands.add(mpd_pause);
		mpd.AvailablesCommands.add(mpd_stop);

		DEVICES.put(lamp.ref, lamp);
		DEVICES.put(screen.ref, screen);
		DEVICES.put(fan.ref, fan);
		DEVICES.put(box.ref, box);
		DEVICES.put(mpd.ref, mpd);
		DEVICES.put(all.ref, all);
	}

	private static void initJson() {
	}
}
