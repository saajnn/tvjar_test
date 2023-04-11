package com.github.catvod.spider;

import android.content.Context;
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

    public void init(Context context) {
        super.init(context);
    }

    private static final String siteUrl = "http://ht.grelighting.cn/api.php";

    private HashMap<String, String> getHeaders(String url, String data) {
        HashMap<String, String> headers = new HashMap<>();
        if (data != null) {
            String token = "";
            try {
                token = Base64.encodeToString(b(fakeDevice.getBytes("UTF-8"), tokenKey == null ? "XPINGGUO" : tokenKey),
                        2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int currentTimeMillis = (int) (System.currentTimeMillis() / ((long) 1000));
            String hash = md5(fakeDevice + data + currentTimeMillis).substring(8, 12);
            headers.put("token", token);
            headers.put("hash", hash);
            headers.put("timestamp", currentTimeMillis + "");
            if (tokenKey == null) {
                headers.put("version", "ANDROID cn.grelighting.xpg1.1.5");
            }
        }
        headers.put("User-Agent", "okhttp/4.9.1");
        return headers;
    }

    private String fakeDevice = null;
    private String tokenKey = null;

    public String homeContent(boolean filter) {
        try {

            fakeDevice = fakeDid();
            String url = siteUrl + "/v2.user/tokenlogin";
            HashMap<String, String> m = getHeaders(url, "ANDROID cn.grelighting.xpg1.1.5");
            for (String key : m.keySet()) {
                System.out.println(key);
                System.out.println(m.get(key));

            }

            JSONObject result = new JSONObject();
            JSONArray classes = new JSONArray();

            JSONObject test0 = new JSONObject();
            test0.put("type_id", "0");
            classes.put(test0);




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
            i10 = ((a[i9] & 255) + i10) % 333;
            byte b = a[i9];
            a[i9] = a[i10];
            a[i10] = b;
            bArr2[i11] = (byte) (a[((a[i9] & 255) + (a[i10] & 255)) % 333] ^ bArr[i11]);
        }
        return bArr2;
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

    String fakeDid() {
        String i = "";
        String f = "";
        String e = "Readmi/alioth/alioth:11/RKQ1.200826.002/V12.5.19.0.RKHCNXM:user/release-keys";
        String d = "unknown";
        return (((((((((("" + i) + "||") + f) + "||") + randomMACAddress()) + "||") + randomString(16)) + "||") + d)
                + "||") + e;
    }
}
