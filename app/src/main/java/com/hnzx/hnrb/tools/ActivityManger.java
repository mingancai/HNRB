package com.hnzx.hnrb.tools;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

public class ActivityManger {

	public static List<Activity> activityList = new LinkedList<Activity>();

	public static void addActivity(Activity activity) {
		if (!activityList.contains(activity)) {
			activityList.add(activity);
		}
	}

	public static void finishAllActivity() {
		for (Activity activity : activityList) {
			activity.finish();
		}
	}

	/**
	 * 结束指定的Activity
	 */
	public static void finishSingleActivity(Activity activity) {
		if (activity != null) {
			if (activityList.contains(activity)) {
				activityList.remove(activity);
			}
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity 在遍历一个列表的时候不能执行删除操作，所有我们先记住要删除的对象，遍历之后才去删除。
	 */
	public static void finishSingleActivityByClass(Class<?> cls) {
		Activity tempActivity = null;
		for (Activity activity : activityList) {
			if (activity.getClass().equals(cls)) {
				tempActivity = activity;
			}
		}

		finishSingleActivity(tempActivity);
	}
}