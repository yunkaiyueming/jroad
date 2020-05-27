package network;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
 
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
 
@ServerEndpoint(value = "/ws/chat/{nickName}")

public class WebsocketServerx {
	public static void main(String[] args){
		WebsocketServerx ws = new WebsocketServerx();
	}
	
    /**
     * 连接对象集合
     */
    private static final Set<WebsocketServerx> connections = new CopyOnWriteArraySet<WebsocketServerx>();
 
    private String nickName;
 
    /**
     * WebSocket Session
     */
    private Session session;
 
    public WebsocketServerx() {
    }
 
    /**
     * 打开连接
     * 
     * @param session
     * @param nickName
     */
    @OnOpen
    public void onOpen(Session session,
            @PathParam(value = "nickName") String nickName) {
 
        this.session = session;
        this.nickName = nickName;
 
        connections.add(this);
        String message = String.format("System> %s %s", this.nickName,
                " has joined.");
        WebsocketServerx.broadCast(message);
    }
 
    /**
     * 关闭连接
     */
    @OnClose
    public void onClose() {
        connections.remove(this);
        String message = String.format("System> %s, %s", this.nickName,
                " has disconnection.");
        WebsocketServerx.broadCast(message);
    }
 
    /**
     * 接收信息
     * 
     * @param message
     * @param nickName
     */
    @OnMessage
    public void onMessage(String message,
            @PathParam(value = "nickName") String nickName) {
    	WebsocketServerx.broadCast(nickName + ">" + message);
    }
 
    /**
     * 错误信息响应
     * 
     * @param throwable
     */
    @OnError
    public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }
 
    /**
     * 发送或广播信息
     * 
     * @param message
     */
    private static void broadCast(String message) {
        for (WebsocketServerx chat : connections) {
            try {
                synchronized (chat) {
                    chat.session.getBasicRemote().sendText(message);
                }
            } catch (IOException e) {
                connections.remove(chat);
                try {
                    chat.session.close();
                } catch (IOException e1) {
                }
                WebsocketServerx.broadCast(String.format("System> %s %s", chat.nickName,
                        " has bean disconnection."));
            }
        }
    }
}