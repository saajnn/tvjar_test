package com.github.catvod.spider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.Misc;
import com.github.catvod.utils.okhttp.OKCallBack;
import com.github.catvod.utils.okhttp.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import okhttp3.Call;

public class Test extends Spider {

    private static final String siteUrl = "";

    public void init(Context context) {
        super.init(context);
    }

    public String homeContent(boolean filter) {
        try {
            JSONObject result = new JSONObject();
            JSONArray classes = new JSONArray();

            JSONObject test0 = new JSONObject();
            JSONObject test1 = new JSONObject();

            String d = "N/A";
            try {
                d = Build.class.getField("SERIAL").get((Object) null).toString();

            } catch (Exception unused) {
            }
            String e = "";
            try {
                e = (String) Class.forName("android.os.SystemProperties")
                        .getDeclaredMethod("get", new Class[] { String.class })
                        .invoke((Object) null, new Object[] { "ro.build.fingerprint" });
            } catch (Exception unused) {
            }
            test0.put("type_id", "0");
            test0.put("type_name", d);
            test1.put("type_id", "1");
            test0.put("type_name", e);


        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    public String categoryContent(String tid, String pg, boolean filter, HashMap<String, String> extend) {
        try {

        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    public String detailContent(List<String> ids) {
        try {

        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    public String searchContent(String key, boolean quick) {
        try {

        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    public String playerContent(String flag, String id, List<String> vipFlags) {
        try {

        } catch (Exception e) {
            SpiderDebug.log(e);
        }
        return "";
    }

    String randomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    String randomMACAddress() {
        Random rand = new Random();
        byte[] macAddr = new byte[6];
        rand.nextBytes(macAddr);
        macAddr[0] = (byte) (macAddr[0] & (byte) 254); // zeroing last 2 bytes to make it unicast and locally
                                                       // adminstrated
        StringBuilder sb = new StringBuilder(18);
        for (byte b : macAddr) {
            sb.append(String.format("%02X", b));
            System.out.println(String.format("%02X", b));
        }
        return sb.toString();
    }

    byte[] a(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        byte[] bArr = new byte[333];
        for (int i9 = 0; i9 < 333; i9++) {
            bArr[i9] = (byte) i9;
        }
        if (bytes.length == 0) {
            return null;
        }
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 333; i12++) {
            i11 = (((bytes[i10] & 255) + (bArr[i12] & 255)) + i11) % 333;
            byte b = bArr[i12];
            bArr[i12] = bArr[i11];
            bArr[i11] = b;
            i10 = (i10 + 1) % bytes.length;
        }
        return bArr;
    }

    String fakeDid() {
        String i = "";
        String f = "";
        String d = "N/A";
        try {
        } catch (Exception unused) {
        }
        String e = "";
        try {
            e = (String) Class.forName("android.os.SystemProperties")
                    .getDeclaredMethod("get", new Class[] { String.class })
                    .invoke((Object) null, new Object[] { "ro.build.fingerprint" });
        } catch (Exception unused) {
            return "kkk";
        }
        return (((((((((("" + i) + "||") + f) + "||") + randomMACAddress()) + "||") + randomString(16)) + "||") + d)
                + "||") + e;
    }

}
