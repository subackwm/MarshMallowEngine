package dev.engine.rn.math;

import java.util.ArrayList;

import dev.engine.rn.object.MSObject;
import dev.engine.rn.transform.MSTrans;

public class MSMath {

	public static float GetDistance(MSTrans position, MSTrans position2) {
		return (float) Math.abs(Math.sqrt(((position.GetX() - position2.GetX()) * (position.GetX() - position2.GetX())
				+ (position.GetY() - position2.GetY()) * (position.GetY() - position2.GetY()))));
	}

	public static float GetAngle(MSTrans position, MSTrans position2) {
		return (float) Math.atan2(position2.GetY() - position.GetY(), position2.GetX() - position.GetX());
	}

	public static float GetXv(float moveSpeed, MSTrans position, MSTrans position2) {
		return (float) Math.cos(GetAngle(position, position2)) * moveSpeed;
	}

	public static float GetYv(float moveSpeed, MSTrans position, MSTrans position2) {
		return (float) Math.sin(GetAngle(position, position2)) * moveSpeed;
	}

	public static MSObject GetShortestDistance(MSTrans pos, ArrayList<MSObject> list) {
		boolean _firstTry = true;
		float _shortDist = 0, _nowDist;
		int _shortIndex = -1;

		for (int i = 0; i < list.size(); i++) {
			_nowDist = GetDistance(list.get(i).position, pos);
			if (_firstTry) {
				_firstTry = false;
				_shortDist = _nowDist;
				_shortIndex = i;
			} else if (_shortDist > _nowDist) {
				_shortDist = _nowDist;
				_shortIndex = i;
			}
		}

		if (_shortIndex == -1)
			return null;
		else
			return list.get(_shortIndex);
	}

}
