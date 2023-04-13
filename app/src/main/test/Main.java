import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        ReplaceFile("./Xinsj.java", "vXTd");
    }

    public static String vXTd(String str) {
        String KEY = "HQqRxI";
        String hexString = "0123456789ABCDEF";
        int i;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(str.length() / 2);
        for (i = 0; i < str.length(); i += 2) {
            baos.write((hexString.indexOf(str.charAt(i)) << 4) | hexString.indexOf(str.charAt(i + 1)));
        }
        byte[] b = baos.toByteArray();
        int len = b.length;
        int keyLen = KEY.length();
        for (i = 0; i < len; i++) {
            b[i] = (byte) (b[i] ^ KEY.charAt(i % keyLen));
        }
        return new String(b);

    }

    public static String Replace(String str, String func) {
        if (func.equals("vXTd")) {
            String pattern_vxt = "vXT\\.d\\(\"(.*?)\"\\)";
            Pattern r = Pattern.compile(pattern_vxt);
            Matcher m = r.matcher(str);
            if (m.find()) {
                String jm = vXTd(m.group(1));

                str = str.replace(m.group(0), "\"" + jm + "\"");
                System.out.println(str);
            }

            // String res = vXTd(str);
            return str;
        }
        return "";
    }

    public static void ReplaceFile(String FilePath, String func) {

        try {
            File bakName = new File(FilePath + ".bak");
            if (bakName.exists()) {
                bakName.delete();
            }
            File oldName = new File(FilePath);
            oldName.renameTo(bakName);
            File newFile = new File(FilePath);
            FileOutputStream fos = null;
            newFile.createNewFile();
            fos = new FileOutputStream(newFile);// 首次写入获取
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");// 指定以UTF-8格式写入文件

            BufferedReader iln = new BufferedReader(new FileReader(FilePath + ".bak"));
            String str;
            while ((str = iln.readLine()) != null) {
                osw.write(Replace(str, func) + "\r\n");
            }
            iln.close();
            osw.close();
        } catch (IOException e) {
        }
    }

}
