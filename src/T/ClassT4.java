package T;

class Infos<T>{
    private T var ;        // 定义泛型变量
    public void setVar(T var){
        this.var = var ;
    }
    public T getVar(){
        return this.var ;
    }
    @Override
    public String toString(){    // 直接打印
        return this.var.toString() ;
    }
}

public class ClassT4{
    public static void main(String args[]){
        Infos<String> i1 = new Infos<String>() ;        // 声明String的泛型对象
        Infos<Object> i2 = new Infos<Object>() ;        // 声明Object的泛型对象
        i1.setVar("hello") ;
        i2.setVar(new Object()) ;
        fun(i1) ;
        fun(i2) ;
    }

    //下限
    public static void fun(Infos<? super String> temp){    // 只能接收String或Object类型的泛型，String类的父类只有Object类
        System.out.print(temp + ", ") ;
    }
}