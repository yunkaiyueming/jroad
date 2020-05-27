package network;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.DatatypeConverter;

import org.json.JSONObject;


public class WebsocketServer{
	public HashMap<String,Socket> Conns;
	public int ServerPort = 12347;
	
	
    public void handShake(OutputStream out ,String data) throws NoSuchAlgorithmException, IOException{
	    Matcher match = Pattern.compile("Sec-WebSocket-Key: (.*)").matcher(data);
	    match.find();
	    byte[] response = ("HTTP/1.1 101 Switching Protocols\r\n"
	            + "Connection: Upgrade\r\n"
	            + "Upgrade: websocket\r\n"
	            + "Sec-WebSocket-Accept: "
	            + DatatypeConverter
	            .printBase64Binary(
	                    MessageDigest
	                    .getInstance("SHA-1")
	                    .digest((match.group(1) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11")
	                            .getBytes("UTF-8")))
	            + "\r\n\r\n")
	            .getBytes("UTF-8");

	    out.write(response, 0, response.length);
	}
    
    
    public void handleMsg(Socket conn,String data) throws IOException{
    	JSONObject js = new JSONObject(data);
    	System.out.println(js);
    	int type = js.getInt("type");
    	switch(type){
    		case 1:
    			this.handleAddUser(conn,data);
    			break;
    		case 2:
    			this.handleBroadcast(data);
    			break;
    		case 3:
    			this.handleLeave(data);
    			break;
    		case 4:
    			this.handleToOneUser(data);
    			break;
    	}
    }
    
    public void handleAddUser(Socket conn,String data) throws IOException{
    	JSONObject req = new JSONObject(data);
    	String name = req.getString("name");
    	String msg = req.getString("msg");
    			
		JSONObject resp = new JSONObject();
    	resp.put("resp_code", 1);
    	resp.put("action", 1);
    	//resp.put("users", );
    	resp.put("name", name);
    	resp.put("msg", msg);
    	this.sendMsg(conn, resp.toString().getBytes());
    }
    
    public void handleBroadcast(String data) throws IOException{
    	for (Entry<String, Socket> conn : this.Conns.entrySet()){
    		this.sendMsg(conn.getValue(),data.getBytes("UTF-8"));
    	}
    }
    
    public void handleLeave(String data){
    	
    }
    
    public void handleToOneUser(String data){
    	
    }
    
    public void sendMsg(Socket conn,byte[] msg) throws IOException{
    	System.out.println("发送消息："+msg);
    	conn.getOutputStream().write(msg,0, msg.length);
    }
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException{
    	WebsocketServer ws = new WebsocketServer();
    	ws.Conns =  new HashMap<String,Socket>();
    	
        ServerSocket server = new ServerSocket(ws.ServerPort);
        System.out.println("Server has started on 127.0.0.1:"+ws.ServerPort+"===>Waiting for a connection...");
        
        Socket conn= server.accept();
        System.out.println(conn.toString()+"====>connected");
    	ws.Conns.put(conn.toString(), conn);
    	
    	int Num=1;
    	
        while(true){
        	System.out.println("1");
        	InputStream in = conn.getInputStream();
        	
        	if(Num==1){
        		System.out.println("first 1");
        		String data = new Scanner(in,"UTF-8").useDelimiter("\\r\\n\\r\\n").next();
        		
            	Matcher get = Pattern.compile("^GET").matcher(data);
            	System.out.println("receive==>"+data);
            	if (get.find()) {
            		System.out.println("2");
            		OutputStream out = conn.getOutputStream();
            		ws.handShake(out,data);
            		System.out.println(conn.toString()+" handshake ok");
            	}
        	}else{
        		System.out.println("tttt");
        	
        		byte[] buf = new byte[1024];
                //读到字节（读取输入流数据到缓存）
                int len = in.read(buf, 0, 1024);
                System.out.println(len);
                //读到字节数组（定义一个容纳数据大小合适缓存区）
                byte[] res = new byte[len];
                //将buf内中数据拷贝到res中
                System.arraycopy(buf, 0, res, 0, len);
                //打印res缓存内容
                ws.printRes(res);
                //String data = new String(res);
                
    			//待编解码数据todo
        		System.out.println("3");
        		System.out.println("msg receive==>");
        		ws.printRes(res);
        		//ws.handleMsg(conn,data);
        	}
            	
        	Num+=1;
        	System.out.println("4");
        }
    }
    
    public void printRes(byte[] array) {
    	Charset charset = Charset.forName("UTF-8"); 
        ByteArrayInputStream  byteIn = new ByteArrayInputStream(array);
        InputStreamReader reader = new InputStreamReader(byteIn, charset.newDecoder());
        int b = 0;
        String res = "";
        try {
            while((b = reader.read()) > 0){
                res += (char)b;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }
    
}