package com.appspot.saliery;

import com.google.wave.api.AbstractRobotServlet;
import com.google.wave.api.Blip;
import com.google.wave.api.Event;
import com.google.wave.api.Gadget;
import com.google.wave.api.RobotMessageBundle;
import com.google.wave.api.TextView;

@SuppressWarnings("serial")
public class SalieryServlet extends AbstractRobotServlet {

	private static final String TAG = "@@";

	private static final String SOURCE_PROPERTY = "source";

	@Override
	public void processEvents(RobotMessageBundle bundle) {
		for (Event event : bundle.getBlipSubmittedEvents()) {
			Blip blip = event.getBlip();
			TextView textView = blip.getDocument();
			replace(textView);
		}
	}

	private static void replace(TextView textView) {
		String text = textView.getText();
		textView.delete();
		String[] sections = text.split(TAG);
		boolean guido = false;
		for (String section : sections) {
			if (section.length() == 0) { // The tag itself can be achieved by writing it twice
				textView.append(TAG);
			} else {
				if (guido) { // GUIDO code is replaced with the score gadget created from it
					Gadget scoreGadget = new Gadget(SalieryProfileServlet.URL + "/gadget/score.xml");
					scoreGadget.setField(SOURCE_PROPERTY, section);
					textView.appendElement(scoreGadget);
				} else {
					textView.append(section);
				}
			}
			guido = !guido;
		}
	}

}
