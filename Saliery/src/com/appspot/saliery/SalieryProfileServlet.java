package com.appspot.saliery;

import com.google.wave.api.ProfileServlet;

@SuppressWarnings("serial")
public class SalieryProfileServlet extends ProfileServlet {

	public static final String URL = "http://saliery-wave.appspot.com";

	@Override
	public String getRobotName() {
		return "Saliery";
	}

	@Override
	public String getRobotProfilePageUrl() {
		return URL;
	}

	@Override
	public String getRobotAvatarUrl() {
		return getRobotProfilePageUrl() + "/images/avatar.png";
	}

}
