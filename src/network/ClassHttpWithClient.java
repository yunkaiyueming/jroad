//package network;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class ClassHttpWithClient {
//
//    public static void main(String[] args) {
//    	ClassHttpWithClient.Get();
//    	ClassHttpWithClient.Post();
//    }
//
//    //需要导入httpclient-4.5, httpcore-4.4.3
//    public static void Get(){
//    	CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        //以前的名字叫做GetMethod,现在改名为HttpGet
//        HttpGet httpGet = new HttpGet("http://www.cnblogs.com");
//
//        //返回请求信息
//        System.out.println("Executing request" + httpGet.getRequestLine());
//
//        //创建一个返回信息的对象
//        CloseableHttpResponse response = null;
//        try {
//            response = httpClient.execute(httpGet);
//            try {
//                System.out.println("-------------------");
//                //打印返回状态
//                System.out.println(response.getStatusLine());
//
//                //实体
//                HttpEntity httpEntity = response.getEntity();
//
//                if (httpEntity != null) {
//                    InputStream inputStream = httpEntity.getContent();
//                    System.out.print("get结果："+inputStream.toString());
//                    System.out.print("get结果："+response.toString());
//                    byte[] bytes = new byte[16];
//                    int i =0;
//                    try {
//                    	 while ((i = inputStream.read(bytes))!=-1){
//                             String str = new String(bytes);
//                             System.out.print(str);
//                         }
//
//                    } catch (IOException ex) {
//                        throw ex;
//                    } finally {
//                        inputStream.close();
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//
//                response.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                httpClient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void Post(){
//    	CloseableHttpClient client = HttpClients.createDefault();
//        try {
//            //一定要加上http否则会报 Target host is not specified
//            HttpPost httpPost = new HttpPost("http://www.baidu.com");
//
//            //设置HttpPost的传参数
//            List<NameValuePair> params = new ArrayList<>();
//            params.add(new BasicNameValuePair("post", "java"));
//
//            //由于JDK7出现,HTTP中的很多编码被标识成了过期,使用StandardCharsets里面的预定义的东西
//            httpPost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
//            CloseableHttpResponse response = client.execute(httpPost);
//
//            int statusCode = response.getStatusLine().getStatusCode();
//            System.out.println("statusCode : " + statusCode);
//
//            String responseStr = null;
//            HttpEntity httpEntity = response.getEntity();
//            if (httpEntity != null) {
//                responseStr = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
//            }
//            System.out.println("respStr = " + responseStr);
//            //释放资源
//            EntityUtils.consume(httpEntity);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
