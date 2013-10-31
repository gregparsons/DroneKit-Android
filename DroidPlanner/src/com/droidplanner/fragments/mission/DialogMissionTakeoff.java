package com.droidplanner.fragments.mission;

import android.view.View;

import com.droidplanner.R;
import com.droidplanner.drone.variables.mission.waypoints.Takeoff;
import com.droidplanner.helpers.units.Altitude;
import com.droidplanner.widgets.SeekBarWithText.SeekBarWithText;
import com.droidplanner.widgets.SeekBarWithText.SeekBarWithText.OnTextSeekBarChangedListner;

public class DialogMissionTakeoff extends DialogMission implements
		OnTextSeekBarChangedListner {
	private SeekBarWithText altitudeSeekBar;
	private SeekBarWithText angleSeekBar;
	private SeekBarWithText yawSeekBar;
	private Takeoff item;

	@Override
	protected int getResource() {
		return R.layout.dialog_mission_takeoff;
	}

	protected View buildView() {
		super.buildView();
		altitudeSeekBar = (SeekBarWithText) view
				.findViewById(R.id.altitudeView);
		item = (Takeoff) wp;
		altitudeSeekBar.setValue(item.getAltitude().valueInMeters());
		altitudeSeekBar.setOnChangedListner(this);

		angleSeekBar = (SeekBarWithText) view.findViewById(R.id.takeoffPitch);
		angleSeekBar.setValue(item.minPitch);
		angleSeekBar.setOnChangedListner(this);

		yawSeekBar = (SeekBarWithText) view.findViewById(R.id.waypointAngle);
		yawSeekBar.setValue(item.yawAngle);
		yawSeekBar.setOnChangedListner(this);

		return view;
	}

	@Override
	public void onSeekBarChanged() {
		item.setAltitude(new Altitude(altitudeSeekBar.getValue()));
		item.minPitch = angleSeekBar.getValue();
		item.yawAngle = yawSeekBar.getValue();
	}

}