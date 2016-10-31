package com.linkesoft.soccerclock;

import android.os.Bundle;
import android.preference.*;

/**
 * Einstellmöglichkeiten für die Fußballuhr
 * 
 * @author Andreas Linke
 *
 */
public class DreamSettingsActivity extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new PrefsFragment()).commit();
	}

	public static class PrefsFragment extends PreferenceFragment {
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.prefs);
		}
	}
}
