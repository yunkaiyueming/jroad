package Tai;

class Animal4<T> {
    public T t;

    public Animal4(T t){
        this.t = t;
    }

    public void say(){
        System.out.println(this.t);
    }
}

class TaiDemo4{
    public static void say(Animal4 a){
        a.say();
    }

    //Java泛型这个特性是从JDK 1.5才开始加入的，因此为了兼容之前的版本，Java泛型的实现采取了“伪泛型”的策略，即Java在语法上支持泛型，但是在编译阶段会进行所谓的“类型擦除”（Type Erasure），将所有的泛型表示（尖括号中的内容）都替换为具体的类型（其对应的原生态类型），就像完全没有泛型一样。理解类型擦除对于用好泛型是很有帮助的，尤其是一些看起来“疑难杂症”的问题，弄明白了类型擦除也就迎刃而解了
    public static void main(String[] args){
        Animal4<String> astr = new Animal4<String>("1");//类型 参数化
        Animal4<Integer> aint = new Animal4<Integer>(2);

        say(astr);
        say(aint);
    }
}
