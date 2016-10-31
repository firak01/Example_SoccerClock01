package com.linkesoft.soccerclock;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.ViewGroup.LayoutParams;

/**
 * Normale Launch-Aktivität, zeigt das Spiel genau wie der Bildschirmschoner an.
 * 
 * @author Andreas Linke
 *
 */
public class MainActivity extends Activity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Arena arena = new Arena(this);
		arena.setLayoutParams(new 
	            ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		setContentView(arena);
	}


}
