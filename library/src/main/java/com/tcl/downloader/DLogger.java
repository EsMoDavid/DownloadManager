package com.tcl.downloader;

import android.content.Context;
import android.util.Log;

public class DLogger {

	public final static String TAG = "DLogger";

	static boolean DEBUG = false;

	static Context context;

	static void setup(Context context) {
		DLogger.context = context.getApplicationContext();
	}

	public static void v(Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.v(TAG, log);

			DLogger2File.log2File(TAG, log);
		}

	}

	public static void v(String tag, Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.v(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}

	public static void v(String tag, String format, Object... args) {
		if (DEBUG) {
			String log = String.format(format, args);

			Log.v(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}

	public static void d(Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.d(TAG, log);

			DLogger2File.log2File(TAG, log);
		}
	}

	public static void d(String tag, Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.d(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}

	public static void d(String tag, String format, Object... args) {
		if (DEBUG) {
			String log = String.format(format, args);

			Log.d(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}
	
	public static void i(Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.i(TAG, log);

			DLogger2File.log2File(TAG, log);
		}
	}

	public static void i(String tag, Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.i(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}
	
	public static void i(String tag, String format, Object... args) {
		if (DEBUG) {
			String log = String.format(format, args);

			Log.i(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}

	public static void w(Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.w(TAG, log);

			DLogger2File.log2File(TAG, log);
		}
	}

	public static void w(String tag, Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.w(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}

	public static void w(String tag, String format, Object... args) {
		if (DEBUG) {
			String log = String.format(format, args);

			Log.w(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}

	public static void e(Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.e(TAG, log);

			DLogger2File.log2File(TAG, log);
		}
	}

	public static void e(String tag, Object o) {
		if (DEBUG) {
			String log = toJson(o);

			Log.e(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}
	
	public static void e(String tag, String format, Object... args) {
		if (DEBUG) {
			String log = String.format(format, args);

			Log.e(tag, log);

			DLogger2File.log2File(tag, log);
		}
	}

	// 这个日志会打印，不会因为release版本屏蔽
	public static void sysout(String msg) {
		try {
			Log.v(TAG, msg);

			DLogger2File.log2File(TAG, msg);
		} catch (Throwable e) {
		}
	}

	public static void printExc(Class<?> clazz, Throwable e) {
		try {
			if (DEBUG) {
				e.printStackTrace();

				DLogger2File.log2File(TAG, e);
			}
			else {
				String clazzName = clazz == null ? "Unknow" : clazz.getSimpleName();

				Log.v(TAG, String.format("class[%s], %s", clazzName, e + ""));
			}
		} catch (Throwable ee) {
			ee.printStackTrace();
		}
	}

	public static String toJson(Object msg) {
		if (msg instanceof String)
			return msg.toString();
		
//		String json = JSON.toJSONString(msg);
		String json = msg + "";
		if (json.length() > 500)
			json = json.substring(0, 500);

		return json;
	}

}
