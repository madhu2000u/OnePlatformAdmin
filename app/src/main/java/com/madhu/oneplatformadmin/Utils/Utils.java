package com.madhu.oneplatformadmin.Utils;

import android.util.Log;
import java.text.*;


public class Utils {

    public static String getParsedString(int date, int month, int year){
        String parsed="";
        parsed+=String.valueOf(date);

        switch (month){
            case 1:
                parsed+="-Jan-";
                break;
            case 2:
                parsed+="-Feb-";
                break;
            case 3:
                parsed+="-Mar-";
                break;
            case 4:
                parsed+="-Apr-";
                break;
            case 5:
                parsed+="-May-";
                break;
            case 6:
                parsed+="-Jun-";
                break;
        }
        parsed+=String.valueOf(year);

        return parsed;

    }


}
