/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hnzx.hnrb.tools;

import android.util.Log;

import java.util.Locale;

/**
 * 基本打印日志类
 */
public class LogUtil {

    public static String TAG = "HNRB";

    public static boolean DEBUG = Log.isLoggable(TAG, Log.VERBOSE);

    public static void setTag(String tag) {
        d("Changing log tag to %s", tag);
        TAG = tag;
        DEBUG = Log.isLoggable(TAG, Log.VERBOSE);
    }

    public static void v(String format, Object... args) {
        if (DEBUG) {
            Log.v(TAG, buildMessage(format, args));
        }
    }

    public static void v(String message) {
        if (DEBUG) {
            Log.v(TAG, buildMessage(message));
        }
    }

    public static void d(String format, Object... args) {
        Log.d(TAG, buildMessage(format, args));
    }

    public static void d(String message) {
        Log.d(TAG, buildMessage(message));
    }

    public static void e(String format, Object... args) {
        Log.e(TAG, buildMessage(format, args));
    }

    public static void e(String message) {
        Log.e(TAG, buildMessage(message));
    }


    public static void e(Throwable tr, String format, Object... args) {
        Log.e(TAG, buildMessage(format, args), tr);
    }

    public static void e(Throwable tr, String message) {
        Log.e(TAG, buildMessage(message), tr);
    }

    public static void wtf(String format, Object... args) {
        Log.wtf(TAG, buildMessage(format, args));
    }

    public static void wtf(String message) {
        Log.wtf(TAG, buildMessage(message));
    }

    public static void wtf(Throwable tr, String format, Object... args) {
        Log.wtf(TAG, buildMessage(format, args), tr);
    }

    public static void wtf(Throwable tr, String message) {
        Log.wtf(TAG, buildMessage(message), tr);
    }

    private static String buildMessage(String format, Object... args) {

        String msg = (args == null) ? format : String.format(Locale.US, format, args);

        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();

        int codeLineNumber = 0;

        String caller = "<HNRB-unknown>";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtil.class)) {
                String callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                callingClass = callingClass.substring(callingClass.lastIndexOf('$') + 1);

                caller = callingClass + "." + trace[i].getMethodName();
                break;
            }
        }
         /*return String.format(Locale.US, "[%d] %s: %s",
                Thread.currentThread().getId(), caller, message);*/
        return String.format(Locale.US, "%s[%d]: %s", caller, codeLineNumber, msg);
    }

    private static String buildMessage(String message) {

        StackTraceElement[] trace = new Throwable().fillInStackTrace().getStackTrace();

        String caller = "<HNRB-unknown>";

        int codeLineNumber = 0;

        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtil.class)) {
                String callingClass = trace[i].getClassName();
                codeLineNumber = trace[i].getLineNumber();
                callingClass = callingClass.substring(callingClass.lastIndexOf('.') + 1);
                callingClass = callingClass.substring(callingClass.lastIndexOf('$') + 1);
                caller = callingClass + "." + trace[i].getMethodName();
                break;
            }
        }
        /*return String.format(Locale.US, "[%d] %s: %s",
                Thread.currentThread().getId(), caller, message);*/
        return String.format(Locale.US, "%s[%d]: %s", caller, codeLineNumber, message);
    }
}
