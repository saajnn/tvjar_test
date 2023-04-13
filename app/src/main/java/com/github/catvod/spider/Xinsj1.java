package com.github.catvod.spider;

import org.json.JSONArray;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import com.github.catvod.utils.okhttp.OkHttpUtil;

import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;

public class Xinsj1 extends Spider {

    private static String KJ = "https://www.6080dy3.com/";

    private JSONObject yq;
    private JSONObject SN;

    private Pattern N = Pattern.compile("/vodtype/(\\d+).html");
    private Pattern i = Pattern.compile("/vodshow/(\\S+).html");
    private final Pattern t0 = Pattern.compile("(?<=url\":\\s\").*?(?=\")");
    private Pattern tF = Pattern.compile("/video/(\\d+).html");
    private Pattern zH = Pattern.compile("/vplay/(\\d+)-(\\d+)-(\\d+).html");

    public void init(Context context) {
        super.init(context);
        try {
            this.yq = new JSONObject(
                    "{\"lgzx1\":{\"show\":\"蓝光专享1\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx2.idcdr.com/m3u81/?url=\"},\"lgzx\":{\"show\":\"蓝光专享2\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx2.idcdr.com/m3u81/?url=\"},\"6080_\":{\"show\":\"蓝光专享\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx2.idcdr.com/m3u81/?url=\"},\"ffm3u8\":{\"show\":\"极速-01\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx1.idcdr.com/player/?url=\"},\"lg1\":{\"show\":\"蓝光专线⑥\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx1.idcdr.com/m3u8/?url=\"},\"1080zyk\":{\"show\":\"极速播放\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx1.idcdr.com/player/?url=\"},\"lg\":{\"show\":\"蓝光专线⑤\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx1.idcdr.com/m3u8/?url=\"},\"qq\":{\"show\":\"TX节点\",\"des\":\"\",\"ps\":\"1\",\"parse\":\"https://jx1.idcdr.com/player/?url=\"},\"sohu\":{\"show\":\"搜狐\",\"des\":\"\",\"ps\":\"1\",\"parse\":\"https://jx1.idcdr.com/111/444/?url=\"},\"youku\":{\"show\":\"YK节点\",\"des\":\"\",\"ps\":\"1\",\"parse\":\"https://jx1.idcdr.com/player/?url=\"},\"bilibili\":{\"show\":\"bilibili\",\"des\":\"\",\"ps\":\"1\",\"parse\":\"https://jx1.idcdr.com/111/444/?url=\"},\"qiyi\":{\"show\":\"QY节点\",\"des\":\"\",\"ps\":\"1\",\"parse\":\"https://jx1.idcdr.com/player/?url=\"},\"BYGA\":{\"show\":\"蓝光专线①\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx1.idcdr.com/m3u8/?url=\"},\"xigua\":{\"show\":\"西瓜视频\",\"des\":\"\",\"ps\":\"1\",\"parse\":\"https://jx1.idcdr.com/111/444/?url=\"},\"lzm3u8\":{\"show\":\"在线观看\",\"des\":\"\",\"ps\":\"0\",\"parse\":\"https://jx1.idcdr.com/player/?url=\"}}");
            // this.SN = new
            // JSONObject(\"{\"1\":[{\"key\":0,\"name\":\"分类\",\"value\":[{\"n\":\"全部\",\"v\":\"4\"},{\"n\":\"动作片\",\"v\":\"6\"},{\"n\":\"喜剧\",\"v\":\"7\"},{\"n\":\"爱情\",\"v\":\"8\"},{\"n\":\"科幻\",\"v\":\"9\"},{\"n\":\"恐怖\",\"v\":\"10\"},{\"n\":\"剧情\",\"v\":\"11\"},{\"n\":\"战争\",\"v\":\"12\"},{\"n\":\"动画\",\"v\":\"23\"}]},{\"key\":3,\"name\":\"剧情\",\"value\":[{\"n\":\"全部\",\"v\":\"\"},{\"n":\"警匪\",\"v\":\"警匪\"},{\"n\":\"犯罪\",\"v\":\"犯罪\"},{\"n\":\"动画\",\"v\":\"动画\"},{\"n\":\"奇幻\",\"v\":\"奇幻\"},{\"n\":\"武侠\",\"v\":\"武侠\"},{\"n\":\"冒险\",\"v\":\"冒险\"},{\"n\":\"枪战\",\"v\":\"枪战\"},{\"n\":\"恐怖\",\"v\":\"恐怖\"},{\"n\":\"悬疑\",\"v\":\"悬疑\"},{\"n\":\"惊悚\",\"v\":\"惊悚\"},{\"n\":\"经典\",\"v\":\"经典\"},{\"n\":\"青春\",\"v\":\"青春\"},{\"n\":\"文艺\",\"v\":\"文艺\"},{\"n\":\"微电影\",\"v\":\"微电影\"},{\"n\":\"古装\",\"v\":\"古装\"},{\"n\":\"历史\",\"v\":\"历史\"},{\"n\":\"运动\",\"v\":\"运动\"},{\"n\":\"农村\",\"v\":\"农村\"},{\"n\":\"儿童\",\"v\":\"儿童\"},{\"n\":\"网络电影\",\"v\":\"网络电影\"}]},{\"key\":1,\"name\":\"地区\",\"value\":[{\"n\":\"全部\",\"v\":\"\"},{\"n\":\"中国大陆\",\"v\":\"中国大陆\"},{\"n\":\"中国香港\",\"v\":\"中国香港\"},{\"n\":\"中国台湾\",\"v\":\"中国台湾\"},{\"n\":"韩国","v":"韩国"},{"n":"日本","v":"日本"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"新加坡","v":"新加坡"},{"n":"马来西亚","v":"马来西亚"},{"n":"印度","v":"印度"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"德国","v":"德国"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"},{"n":"其他","v":"其他"}]},{"key":11,"name":"年份","value":[{"n":"全部","v":""},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"}]},{"key":4,"name":"语言","value":[{"n":"全部","v":""},{"n":"国语","v":"国语"},{"n":"英语","v":"英语"},{"n":"粤语","v":"粤语"},{"n":"闽南语","v":"闽南语"},{"n":"韩语","v":"韩语"},{"n":"日语","v":"日语"},{"n":"其它","v":"其它"}]},{"key":5,"name":"字母","value":[{"n":"全部","v":""},{"n":"A","v":"A"},{"n":"B","v":"B"},{"n":"C","v":"C"},{"n":"D","v":"D"},{"n":"E","v":"E"},{"n":"F","v":"F"},{"n":"G","v":"G"},{"n":"H","v":"H"},{"n":"I","v":"I"},{"n":"J","v":"J"},{"n":"K","v":"K"},{"n":"L","v":"L"},{"n":"M","v":"M"},{"n":"N","v":"N"},{"n":"O","v":"O"},{"n":"P","v":"P"},{"n":"Q","v":"Q"},{"n":"R","v":"R"},{"n":"S","v":"S"},{"n":"T","v":"T"},{"n":"U","v":"U"},{"n":"V","v":"V"},{"n":"W","v":"W"},{"n":"X","v":"X"},{"n":"Y","v":"Y"},{"n":"Z","v":"Z"},{"n":"0-9","v":"0-9"}]},{"key":2,"name":"排序","value":[{"n":"时间","v":"time"},{"n":"人气","v":"hits"},{"n":"评分","v":"score"}]}],"2":[{"key":0,"name":"类型","value":[{"n":"全部","v":"2"},{"n":"港台剧","v":""},{"n":"国产剧","v":"13"},{"n":"港台剧","v":"14"},{"n":"日韩剧","v":"15"},{"n":"欧美剧","v":"16"},{"n":"纪录片","v":"21"},{"n":"泰国剧","v":"24"}]},{"key":3,"name":"剧情","value":[{"n":"全部","v":""},{"n":"古装","v":"古装"},{"n":"战争","v":"战争"},{"n":"青春偶像","v":"青春偶像"},{"n":"喜剧","v":"喜剧"},{"n":"家庭","v":"家庭"},{"n":"犯罪","v":"犯罪"},{"n":"动作","v":"动作"},{"n":"奇幻","v":"奇幻"},{"n":"剧情","v":"剧情"},{"n":"历史","v":"历史"},{"n":"经典","v":"经典"},{"n":"乡村","v":"乡村"},{"n":"情景","v":"情景"},{"n":"商战","v":"商战"},{"n":"网剧","v":"网剧"},{"n":"其他","v":"其他"}]},{"key":1,"name":"地区","value":[{"n":"全部","v":""},{"n":"中国大陆","v":"中国大陆"},{"n":"中国香港","v":"中国香港"},{"n":"中国台湾","v":"中国台湾"},{"n":"韩国","v":"韩国"},{"n":"日本","v":"日本"},{"n":"美国","v":"美国"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"德国","v":"德国"},{"n":"泰国","v":"泰国"},{"n":"新加坡","v":"新加坡"},{"n":"马来西亚","v":"马来西亚"},{"n":"印度","v":"印度"},{"n":"法国","v":"法国"},{"n":"英国","v":"英国"},{"n":"德国","v":"德国"},{"n":"意大利","v":"意大利"},{"n":"西班牙","v":"西班牙"},{"n":"加拿大","v":"加拿大"},{"n":"其他","v":"其他"}]},{"key":11,"name":"年份","value":[{"n":"全部","v":""},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"},{"n":"2009","v":"2009"},{"n":"2008","v":"2008"},{"n":"2007","v":"2007"},{"n":"2006","v":"2006"},{"n":"2005","v":"2005"},{"n":"2004","v":"2004"}]},{"key":4,"name":"语言","value":[{"n":"全部","v":""},{"n":"国语","v":"国语"},{"n":"英语","v":"英语"},{"n":"粤语","v":"粤语"},{"n":"闽南语","v":"闽南语"},{"n":"韩语","v":"韩语"},{"n":"日语","v":"日语"},{"n":"其它","v":"其它"}]},{"key":5,"name":"字母","value":[{"n":"全部","v":""},{"n":"A","v":"A"},{"n":"B","v":"B"},{"n":"C","v":"C"},{"n":"D","v":"D"},{"n":"E","v":"E"},{"n":"F","v":"F"},{"n":"G","v":"G"},{"n":"H","v":"H"},{"n":"I","v":"I"},{"n":"J","v":"J"},{"n":"K","v":"K"},{"n":"L","v":"L"},{"n":"M","v":"M"},{"n":"N","v":"N"},{"n":"O","v":"O"},{"n":"P","v":"P"},{"n":"Q","v":"Q"},{"n":"R","v":"R"},{"n":"S","v":"S"},{"n":"T","v":"T"},{"n":"U","v":"U"},{"n":"V","v":"V"},{"n":"W","v":"W"},{"n":"X","v":"X"},{"n":"Y","v":"Y"},{"n":"Z","v":"Z"},{"n":"0-9","v":"0-9"}]},{"key":2,"name":"排序","value":[{"n":"时间","v":"time"},{"n":"人气","v":"hits"},{"n":"评分","v":"score"}]}],"4":[{"key":3,"name":"剧情","value":[{"n":"全部","v":""},{"n":"情感","v":"情感"},{"n":"科幻","v":"科幻"},{"n":"热血","v":"热血"},{"n":"推理","v":"推理"},{"n":"搞笑","v":"搞笑"},{"n":"冒险","v":"冒险"},{"n":"萝莉","v":"萝莉"},{"n":"校园","v":"校园"},{"n":"动作","v":"动作"},{"n":"机战","v":"机战"},{"n":"运动","v":"运动"},{"n":"战争","v":"战争"},{"n":"少年","v":"少年"},{"n":"少女","v":"少女"},{"n":"社会","v":"社会"},{"n":"原创","v":"原创"},{"n":"亲子","v":"亲子"},{"n":"益智","v":"益智"},{"n":"其他","v":"其他"}]},{"key":1,"name":"地区","value":[{"n":"全部","v":""},{"n":"中国","v":"中国"},{"n":"日本","v":"日本"},{"n":"欧美","v":"欧美"},{"n":"其他","v":"其他"}]},{"key":11,"name":"年份","value":[{"n":"全部","v":""},{"n":"2022","v":"2022"},{"n":"2021","v":"2021"},{"n":"2020","v":"2020"},{"n":"2019","v":"2019"},{"n":"2018","v":"2018"},{"n":"2017","v":"2017"},{"n":"2016","v":"2016"},{"n":"2015","v":"2015"},{"n":"2014","v":"2014"},{"n":"2013","v":"2013"},{"n":"2012","v":"2012"},{"n":"2011","v":"2011"},{"n":"2010","v":"2010"},{"n":"2009","v":"2009"},{"n":"2008","v":"2008"},{"n":"2007","v":"2007"},{"n":"2006","v":"2006"},{"n":"2005","v":"2005"},{"n":"2004","v":"2004"},{"n":"2003","v":"2003"},{"n":"2002","v":"2002"},{"n":"2001","v":"2001"},{"n":"2000","v":"2000"}]},{"key":2,"name":"排序","value":[{"n":"时间","v":"time"},{"n":"人气","v":"hits"},{"n":"评分","v":"score"}]}]}");
            this.SN = new JSONObject("{}");
        } catch (Exception e) {
            SpiderDebug.log(e);
        }
    }

    public void init(Context context, String str) {
        super.init(context, str);
        if (!TextUtils.isEmpty(str)) {
            // KJ = str;
        }
    }

    public String homeContent(boolean filter) {
        String d = "div.module-item-titlebox a";
        JSONObject result = new JSONObject();
        try {
            String str = KJ;
            Document doc = Jsoup.parse(OkHttpUtil.string(str, getHeaders(str)));
            Elements elements = doc.select("ul.nav-menu-items>li.nav-menu-item>a");
            JSONArray classes = new JSONArray();
            // System.out.println(elements);
            for (Element ele : elements) {
                String name = ele.select("span").text();
                // System.out.println(name);
                boolean show = name.equals("电影") ||
                        name.equals("电视剧") ||
                        name.equals("动漫") ||
                        name.equals("综艺");
                if (show) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("type_id", ele.select("a").attr("href"));
                    jsonObject.put("type_name", name);
                    classes.put(jsonObject);
                }
                if (filter) {
                    result.put("filters", this.SN);
                }
                result.put("class", classes);

            }
            return result.toString();
        } catch (Exception e2) {
            SpiderDebug.log(e2);
            return "";
        }
    }

    public String categoryContent(String str, String str2, boolean z, HashMap<String, String> hashMap) {
        HashMap<String, String> hashMap2 = hashMap;
        String d = "div.module-item-cover > div.module-item-pic > a";
        String d2 = "-";
        String str3 = "";
        try {
            String i;
            int parseInt;
            int i2;
            String tF;
            String[] r5 = new String[12];
            int i3 = 0;
            r5[0] = str3;
            int i4 = 1;
            r5[1] = str3;
            r5[2] = str3;
            r5[3] = str3;
            r5[4] = str3;
            r5[5] = str3;
            r5[6] = str3;
            r5[7] = str3;
            r5[8] = str3;
            r5[9] = str3;
            r5[10] = str3;
            r5[11] = str3;
            r5[0] = str;
            r5[8] = str2;
            if (hashMap2 != null && hashMap.size() > 0) {
                for (String i5 : hashMap.keySet()) {
                    r5[Integer.parseInt(i5)] = URLEncoder.encode((String) hashMap2.get(i5));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(KJ);
            stringBuilder.append("vodshow");
            stringBuilder.append(TextUtils.join(d2, r5));
            stringBuilder.append(".html");
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder2 = OkHttpUtil.string(stringBuilder2, getHeaders(stringBuilder2));
            System.out.println(stringBuilder.toString());
            // WU zH = W.zH(stringBuilder2);
            // JSONObject jSONObject = new JSONObject();
            // uT OB = zH.OB("div[id=page]");
            // int size = OB.size();
            // String d3 = "href";
            // if (size == 0) {
            // parseInt = Integer.parseInt(str2);
            // i2 = parseInt;
            // } else {
            // size = 0;
            // while (size < OB.size()) {
            // if (((jC) OB.get(size)).x("a") == null) {
            // size++;
            // } else {
            // i5 = zH.OB("span.page-current").i();
            // tF = zH.OB("div[id=page] a").tF().tF(d3);
            // parseInt = Integer.parseInt(i5);
            // Matcher matcher = this.i.matcher(tF);
            // if (matcher.find()) {
            // int i6 = parseInt;
            // parseInt = Integer.parseInt(matcher.group(1).split(d2)[8]);
            // i2 = i6;
            // } else {
            // i2 = parseInt;
            // parseInt = 0;
            // }
            // }
            // }
            // i2 = -1;
            // parseInt = 0;
            // }
            // JSONArray jSONArray = new JSONArray();
            // if (!stringBuilder2.contains("没有找到您想要的结果哦")) {
            // uT OB2 = zH.OB("div.module-items>div");
            // while (i3 < OB2.size()) {
            // jC jCVar = (jC) OB2.get(i3);
            // tF = jCVar.x(d).tF("title");
            // String tF2 = jCVar.x("div.module-item-cover > div.module-item-pic >
            // img").tF("data-src");
            // jC x = jCVar.x("div.module-item-text");
            // Object s0 = x != null ? x.s0() : str3;
            // Matcher matcher2 = this.tF.matcher(jCVar.x(d).tF(d3));
            // if (matcher2.find()) {
            // String group = matcher2.group(i4);
            // JSONObject jSONObject2 = new JSONObject();
            // jSONObject2.put("vod_id", group);
            // jSONObject2.put("vod_name", tF);
            // jSONObject2.put("vod_pic", tF2);
            // jSONObject2.put("vod_remarks", s0);
            // jSONArray.put(jSONObject2);
            // }
            // i3++;
            // i4 = 1;
            // }
            // }
            // jSONObject.put("page", i2);
            // jSONObject.put("pagecount", parseInt);
            // jSONObject.put("limit", 48);
            // jSONObject.put("total", parseInt <= 1 ? jSONArray.length() : parseInt * 48);
            // jSONObject.put("list", jSONArray);
            // return jSONObject.toString();
            //
            return "";
        } catch (Exception e) {
            SpiderDebug.log(e);
            return str3;
        }
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

    public static HashMap<String, String> Myq(String str, String str2, String str3, String str4) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(str, str2);
        hashMap.put(str3, str4);
        return hashMap;
    }

    protected final HashMap<String, String> getHeaders(String str) {
        str = "method";
        String d = "GET";
        String d2 = "Upgrade-Insecure-Requests";
        String d3 = "1";
        HashMap<String, String> yq = Myq(str, d, d2, d3);
        yq.put("DNT", d3);
        yq.put("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.62 Safari/537.36");
        yq.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        yq.put("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
        return yq;
    }

    // ====================
    void printLog(String key, String value) {
        try {

            String str = key + "=" + value;
            String str1 = "http://localhost:8080/?" + str;
            String res = OkHttpUtil.string(str1, null);
            System.out.println(res);
        } catch (Exception e) {
        }
    }
    // ====================
}
