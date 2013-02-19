package com.jcsd.domodroid.devices;

import java.util.ArrayList;

public class Device {

	public String name;
	public String ref;
	public String refIcon;

	public ArrayList<Command> AvailablesCommands = new ArrayList<Command>();

	public Device(String name, String ref) {
		this(name, ref, ref);
	}

	public Device(String name, String ref, String icon) {
		this.name = name;
		this.ref = ref;
		this.refIcon = icon;
	}
}
