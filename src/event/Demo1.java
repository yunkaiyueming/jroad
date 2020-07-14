package event;

/*
 *
 * @ClassName: ListViewDemo
 * @Description: 事件源模拟类,采用的是观察者模式
 * @author Mr.Simple
 * @date Apr 5, 2013 2:18:34 PM
 *
 */

import reflect.Demo3;

import java.util.*;


//测试使用 事件监听器
//Demo1事件源
public class Demo1 {
    // item文本文字
    private String mItemName = "";
    // 监听器哈希集合,可以注册多个监听器
    private Set<EventListener> mClickListeners = null;

    /**
     * 构造函数
     */
    public Demo1() {
        //  监听器列表
        mClickListeners = new HashSet<EventListener>();
        mItemName = "Defualt Item Name";
    }

    /**
     * 构造函数
     *
     * @param itemString
     */
    public Demo1(String itemString) {
        mItemName = itemString;
        mClickListeners = new HashSet<EventListener>();
    }

    /**
     * @param listener
     * @return void
     * @throws
     * @Title: AddItemClickListener
     * @Description: 添加监听器
     */
    public void AddItemClickListener(EventListener listener) {
        // 添加到监听器列表
        this.mClickListeners.add(listener);
    }

    /**
     * @return void
     * @throws
     * @Title: ItemClick
     * @Description: 模拟点击事件, 触发事件则通知所有监听器
     */
    public void ButtonClick() {
        // 事件触发逻辑 通知所有监听者
        Notifies();
    }

    /**
     * @return void
     * @throws
     * @Title: Notifies
     * @Description: 通知所有监听者
     */
    private void Notifies() {
        Iterator<EventListener> iterator = mClickListeners.iterator();
        while (iterator.hasNext()) {
            EventListener tmp =  iterator.next();
            if(tmp.getClass().equals(ButtonClickListenerInner.class)){
                // 获取当前的对象
                ButtonClickListenerInner listener = (ButtonClickListenerInner) tmp;
                // 事件触发,事件的构造函数参数为事件源this
                listener.ButtonClicked(new ButtonClickEvent(this));
            }
        }
    }


    //触发移动事件
    public void ButtonMove(){
        Iterator<EventListener> iterator = mClickListeners.iterator();
        while (iterator.hasNext()) {
            EventListener tmp =  iterator.next();
            //System.out.println(tmp.getClass());
            //System.out.println(ButtonMoveListenerInner.class);
            if(tmp.getClass().equals(ButtonMoveListenerInner.class)){
                // 获取当前的对象
                ButtonMoveListenerInner listener = (ButtonMoveListenerInner) tmp;
                // 事件触发,事件的构造函数参数为事件源this
                listener.ButtonMove(new ButtonClickEvent(this));
            }
        }
    }

    /**
     * @return String
     * @throws
     * @Title: getItemString
     * @Description: 返回该项的名字
     */
    public String getItemString() {
        return mItemName;
    }


    /**
     * @param args
     * @return void
     * @throws
     * @Title: main
     * @Description: main方法
     */
    public static void main(String[] args) {
        Demo1 buttonDemo = new Demo1("Hello, I am a ButtonDemo");

        buttonDemo.AddItemClickListener(new ButtonMoveListenerInner());
        buttonDemo.ButtonMove();

        buttonDemo.AddItemClickListener(new ButtonClickListenerInner());        // 添加监听器
        buttonDemo.ButtonClick();        // 事件触发

    }
}


/**
 * @Title: ValueChangeEvent.java
 * @Package
 * @Description:
 * @author Mr.Simple bboyfeiyu@gmail.com
 * @date Apr 5, 2013 2:10:39 PM
 * @version V1.0
 */


/**
 * 事件类,包含了事件源
 * @ClassName: ValueChangeEvent
 * @Description:
 * @author Mr.Simple
 * @date Apr 5, 2013 2:12:37 PM
 *
 */
class ButtonClickEvent extends EventObject {

    /**
     * 字段：
     */
    private static final long serialVersionUID = 1L;
    // 事件源
    private Object mSourceObject = null;
    private String mTag = "";

    /**
     * 构造函数
     * @param sObject
     */
    public ButtonClickEvent(Object sObject){
        super(sObject);
        mSourceObject = sObject;
    }

    /**
     * 构造函数
     * @param sObject
     * @param tag
     */
    public ButtonClickEvent(Object sObject, String  tag){
        super(sObject);
        mSourceObject = sObject;
        mTag = tag;
    }

    /**
     * 获取事件源
     * (non-Javadoc)
     * @see java.util.EventObject#getSource()
     */
    public Object getSource() {
        return mSourceObject;
    }

    /**
     *
     * @Title: setSource
     * @Description: 设置事件源
     * @param obj
     * @return void
     * @throws
     */
    public void setSource(Object obj) {
        mSourceObject = obj;
    }

    /**
     *
     * @Title: getTag
     * @Description: 获得tag
     * @return
     * @return String
     * @throws
     */
    public String getTag(){
        return mTag;
    }

    /**
     *
     * @Title: setTag
     * @Description: 设置tag
     * @param tag
     * @return void
     * @throws
     */
    public void setTag(String tag) {
        mTag = tag;
    }

}


/**
 *
 * @ClassName: ButtonClickListenerInner
 * @Description: 内部类的写法
 * @author Mr.Simple
 * @date Apr 5, 2013 2:41:02 PM
 *
 */
 class ButtonClickListenerInner implements EventListener{
    /**
     *
     * @Title: ItemClicked
     * @Description: 点击事件
     * @param event
     * @return void
     * @throws
     */
    public void ButtonClicked(ButtonClickEvent event) {
        // 获取事件源
        Demo1 source = (Demo1)event.getSource();
        System.out.println("ButtonClickListenerInner监听器触发，捕获你点击的是 : " + source.getItemString()) ;
    }
}

class ButtonMoveListenerInner implements EventListener{
    public void ButtonMove(ButtonClickEvent event) {
        // 获取事件源
        Demo1 source = (Demo1)event.getSource();
        System.out.println("ButtonMoveListenerInner监听器触发，捕获 你移动到的是 : " + source.getItemString()) ;
    }
}