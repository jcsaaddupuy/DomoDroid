package com.jcsd.domodroid.config;

public class DomoSettings {

	public static String host;
	public static int port;

	public static String path;
	public static String scheme;

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		DomoSettings.host = host;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		DomoSettings.port = port;
	}

	public static String getPath() {
		return path;
	}

	public static void setPath(String path) {
		DomoSettings.path = path;
	}

	public static String getScheme() {
		return scheme;
	}

	public static void setScheme(String scheme) {
		DomoSettings.scheme = scheme;
	}

}
