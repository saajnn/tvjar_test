package com.github.catvod.spider;

import android.content.Context;
//import android.content.SharedPreferences;
//import android.os.Build;
//import android.text.TextUtils;
import android.util.Base64;
//
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

    private String fakeDevice = null;

    public String homeContent(boolean filter) {
        try {
            JSONObject result = new JSONObject();
            JSONArray classes = new JSONArray();

            JSONObject test0 = new JSONObject();
            JSONObject test1 = new JSONObject();

            // String d = "N/A";
            // try {
            // d = Build.class.getField("SERIAL").get((Object) null).toString();
            //
            //////////// } catch (Exception unused) {
            // }
            // String e = "";
            // try {
            // e = (String) Class.forName("android.os.SystemProperties")
            // .getDeclaredMethod("get", new Class[] { String.class })
            // .invoke((Object) null, new Object[] { "ro.build.fingerprint" });
            // } catch (Exception unused) {
            // }
            // test0.put("type_id", "0");
            // test0.put("type_name", "测试1:" + d);
            // test1.put("type_id", "1");
            // test1.put("type_name", "测试二:" + e);

            fakeDevice = fakeDid();
            // 测试fake
            String fakeDevice = "||||B94264889291||I4hppZ10YEDPCUQO||unknown||Readmi/alioth/alioth:11/RKQ1.200826.002/V12.5.19.0.RKHCNXM:user/release-keys";
            String tokenKey = null;
            System.out.println("获得fakedevice：\n" + fakeDevice);
            if (tokenKey == null) {
                tokenKey = "XPINGGUO";
            }
            System.out.println("获得tokenKey：\n" + tokenKey);
            System.out.println("获得fakedevice字节数组：\n");
            byte[] zj_fake = fakeDevice.getBytes("UTF-8");
            bl(zj_fake);
            // System.out.println("a函数返回的字节数组");
            // byte[] zj_a = a(tokenKey);
            // bl(zj_a);
            System.out.println("b函数返回的字节数组");
            byte[] zj_b = b(zj_fake, tokenKey);
            bl(zj_b);

            test0.put("type_id", "0");
            String base664 = Base64
                    .encodeToString(b(fakeDevice.getBytes("UTF-8"), tokenKey == null ? "XPINGGUO" : tokenKey), 2);
            test0.put("type_name", "测试1:" + base664);
            // test0.put("type_id", "0");
            // test0.put("type_name", "测试1:" + d);
            // test1.put("type_id", "1");
            // test1.put("type_name", "测试二:" + e);

            classes.put(test0);
            // classes.put(test1);

            result.put("class", classes);
            return result.toString();

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
        }
        return sb.toString();
    }

    byte[] a(String str) {
        byte[] bytes = str.getBytes();
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
        String e = "Readmi/alioth/alioth:11/RKQ1.200826.002/V12.5.19.0.RKHCNXM:user/release-keys";
        String d = "unknown";
        return (((((((((("" + i) + "||") + f) + "||") + randomMACAddress()) + "||") + randomString(16)) + "||") + d)
                + "||") + e;
    }

    String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (Exception e9) {
            e9.printStackTrace();
            return str;
        }
    }

    byte[] b(byte[] bArr, String str) {
        byte[] a = a(str);
        byte[] bArr2 = new byte[bArr.length];
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            i9 = (i9 + 1) % 333;
            //// System.out.println("i9:" + i9);
            i10 = ((a[i9] & 255) + i10) % 333;
            // System.out.println("i10:" + i10);
            byte b = a[i9];
            // System.out.println("a[i9]:" + a[i9]);
            // System.out.println("b:" + b);
            // System.out.println("b和a[19]是否相等");
            // System.out.println("a[i10]:" + a[i10]);
            a[i9] = a[i10];
            // System.out.println("a[i9]:" + a[i9]);
            a[i10] = b;
            // System.out.println("a[i10]:" + a[i10]);
            // System.out.println("cs:" + cs);
            // System.out.println("csb:" + csb);
            // System.out.println("cs和csb是否相等");
            bArr2[i11] = (byte) (a[((a[i9] & 255) + (a[i10] & 255)) % 333] ^ bArr[i11]);
            // System.out.println("a[i11]:" + a[i11]);
        }
        return bArr2;
    }

    void bl(byte[] bt) {
        for (int i = 0; i < bt.length; i++) {
            System.out.print(bt[i]);
            System.out.print(",");
        }
        System.out.println();
    }
}
