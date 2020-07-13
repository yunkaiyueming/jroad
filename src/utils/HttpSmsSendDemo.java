package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

import com.google.gson.JsonObject;

/**
 * 短信下发demo
 *
 * @author syste
 *
 */
public class HttpSmsSendDemo {

    public static void main(String[] args) {
        try {
            //HttpSmsSendDemo hss = new HttpSmsSendDemo();
            sendSmsHttp();
            // reportStatusQuery();
            // balanceQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 商户余额查询
     *
     * @throws IOException
     */
    public static void balanceQuery() throws IOException {
        JsonObject requestJsonObject = new JsonObject();
        requestJsonObject.addProperty("publicKey", "1231-xxd3"); // 公钥

        String secretKey = "e096-d796-4d21-a32b-cxxc"; // 私钥

        String requestBody = requestJsonObject.toString();

        URL obj = new URL("http://brtxsms.boruiworld.com:10220/api/1.0/queryMerchantBalance");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        // Set http headers
        con.setRequestProperty("ContentMD5", MD5(requestBody + secretKey));
        con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        con.setRequestProperty("Content-Length", "" + requestBody.getBytes("UTF-8").length);

        // Send post request
        con.setDoOutput(true);
        con.getOutputStream().write(requestBody.getBytes("UTF-8"));
        con.getOutputStream().close();

        System.out.println("Post parameters : " + requestBody);
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine = null;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        }
    }

    /**
     * 状态报告查询
     *
     * @throws IOException
     */
    public static void reportStatusQuery() throws IOException {
        JsonObject requestJsonObject = new JsonObject();
        requestJsonObject.addProperty("publicKey", "1231-xxd3"); // 公钥
        requestJsonObject.addProperty("orderId", "20200703152430-xxeceb1-96"); // 类型
        requestJsonObject.addProperty("phoneNumber", "18680365193"); // 下发号码

        String secretKey = "e096-d796-4d21-a32b-cd3c"; // 私钥

        String requestBody = requestJsonObject.toString();

        URL obj = new URL("http://brtxsms.boruiworld.com:10220/api/1.0/querySmsStatus");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        // Set http headers
        con.setRequestProperty("ContentMD5", MD5(requestBody + secretKey));
        con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        con.setRequestProperty("Content-Length", "" + requestBody.getBytes("UTF-8").length);

        // Send post request
        con.setDoOutput(true);
        con.getOutputStream().write(requestBody.getBytes("UTF-8"));
        con.getOutputStream().close();

        System.out.println("Post parameters : " + requestBody);
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine = null;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        }
    }

    /**
     * 短信下发demo
     *
     * @throws IOException
     */
    public static void sendSmsHttp() throws IOException {
        // 构建参数
        JsonObject requestJsonObject = new JsonObject();
        requestJsonObject.addProperty("publicKey", "2ff8-bc95"); // 公钥
        requestJsonObject.addProperty("smsType", "测试"); // 类型
        requestJsonObject.addProperty("phoneNumbers", "15300158981"); // 下发号码
        requestJsonObject.addProperty("smsContent", "【顺丰】审核验证码测试123456, 请在5分钟内使用");// 下发文案
        requestJsonObject.addProperty("extCode", "1000"); // 扩展码
        String secretKey = "e096-d796-4d21-a32b-cxxc"; // 私钥


        System.out.println("aaaas");
        String requestBody = requestJsonObject.toString();
        //URL obj = new URL("http://brtxsms.boruiworld.com:10110/api/1.0/sendSmsByContent");
        //URL obj = new URL("https://brtxsms.boruiworld.com/api/1.0/sendSmsByContent");
        URL obj = new URL("http://192.168.31.2:10010/api/1.0/sendSmsByContent");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        // Set http headers
        con.setRequestProperty("ContentMD5", MD5(requestBody + secretKey));
        con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        con.setRequestProperty("Content-Length", "" + requestBody.getBytes("UTF-8").length);

        // Send post request
        con.setDoOutput(true);
        con.getOutputStream().write(requestBody.getBytes("UTF-8"));
        con.getOutputStream().close();

        System.out.println("Post parameters : " + requestBody);
        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine = null;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        }
    }

    /**
     * MD5 加密方法
     *
     * @param str
     * @return
     */
    public static String MD5(String str) {
        MessageDigest md5 = null;
        String resultStr = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bytes.length << 1);
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Character.forDigit((bytes[i] >> 4) & 0xf, 16));
                sb.append(Character.forDigit(bytes[i] & 0xf, 16));
            }
            resultStr = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultStr;
    }
}