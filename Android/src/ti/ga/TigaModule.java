/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.ga;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger.LogLevel;


@Kroll.module(name="Tiga", id="ti.ga")
public class TigaModule extends KrollModule
{

	public static final String MODULE_FULL_NAME = "ti.ga";
	private final GoogleAnalytics _ga;
	private int _dispatchInterval = 30;
	
	public TigaModule()
	{
		super();
		_ga = GoogleAnalytics.getInstance(TiApplication.getInstance().getApplicationContext());		
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		//Log.d(LCAT, "inside onAppCreate");
	}

	// Methods
	@Kroll.method
	public void setTrackUncaughtExceptions()
	{
		Log.d(MODULE_FULL_NAME,"setTrackUncaughtExceptions is only available on iOS");
	}
	
	@Kroll.method
	public void setDebug(boolean value) {
		if(value){
			_ga.getLogger().setLogLevel(LogLevel.VERBOSE);
		}else{
			_ga.getLogger().setLogLevel(LogLevel.ERROR);
		}
	}

	@Kroll.method
	public void dispatch() {
		_ga.dispatchLocalHits();
	}
	
	// Properties
	@Kroll.getProperty
	public long getDispatchInterval()
	{		
		return _dispatchInterval;
	}

	@Kroll.method @Kroll.setProperty
	public void setDispatchInterval(int value) {
		_dispatchInterval = value;
		_ga.setLocalDispatchPeriod(value);
	}

	@Kroll.method
	public boolean getOptOut()
	{
		return _ga.getAppOptOut();
	}

	@Kroll.method @Kroll.setProperty
	public void setOptOut(boolean value) {
		_ga.setAppOptOut(value);
	}

}
