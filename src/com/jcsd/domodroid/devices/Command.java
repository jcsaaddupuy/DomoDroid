package com.jcsd.domodroid.devices;

public class Command {
	public String name;
	public String ref;
	public String refIcon;

	public Command(String name, String ref) {
		this(name, ref, ref);
	}

	public Command(String name, String ref, String icon) {
		this.name = name;
		this.ref = ref;
		this.refIcon = icon;
	}
}
