package com.linkesoft.soccerclock;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.*;
import android.service.dreams.DreamService;
import android.view.*;
import android.view.ViewGroup.LayoutParams;

/**
 * Bildschirmschoner (Daydream) Service. Lädt die {@link Arena}.
 * 
 * @author Andreas Linke
 *
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1) // DreamService erst ab 4.2
public class SoccerDreamService extends DreamService {
	
	private Arena arena;

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		boolean dimmed=prefs.getBoolean("dimmed",false);
		setScreenBright(!dimmed);
		// optional kein Status-Bar oben
		//setFullscreen(true);
	}
	@Override
	public void onDreamingStarted() {
		super.onDreamingStarted();
		// erzeuge ViewGroup für Animation
		arena = new Arena(this);
		arena.setLayoutParams(new 
	            ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		setContentView(arena);
	}
	
	@Override
	public void onDreamingStopped() {
		arena.timeAnimator.cancel(); // stoppe Animationen
		super.onDreamingStopped();
	}

}
