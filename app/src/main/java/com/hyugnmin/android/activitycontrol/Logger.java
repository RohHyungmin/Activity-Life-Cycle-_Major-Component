package com.hyugnmin.android.activitycontrol;

import android.util.Log;

/** 로깅객체
 * Created by besto on 2017-01-26.
 */

public class Logger {
    public final static boolean DEBUG_MODE = true; //BuildConfig.DEBUG; <- 표준

    /**로그 내용을 콘솔에 출력
     *
     * @param string
     * @param className
     */

    public static void print(String string, String className) {
        if(DEBUG_MODE)
            Log.d(className, string);

    }
}
