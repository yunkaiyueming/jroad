package builtin;

interface Like{
    void lambdas();
}

//函数式接口 ： 仅有1个方法的接口
interface Love{
    void lambdas(int a);
}

//实现类
class ILike implements Like{
    @Override
    public void lambdas(){
        System.out.println("i like");
    }
}

public class LambdaDemo {

    //静态内部类
    static class ILike2 implements Like{
        @Override
        public void lambdas(){
            System.out.println("i like2");
        }
    }

    public static void main1(String[] args){
        new ILike().lambdas();
        new ILike2().lambdas();

        //局部内部类
        class ILike3 implements Like{
            @Override
            public void lambdas(){
                System.out.println("i like3");
            }
        }
        new ILike3().lambdas();

        //匿名内部类
        Like like4  = new ILike(){
            @Override
            public void lambdas(){
                System.out.println("i like4");
            }
        };
        like4.lambdas();

        //6 lambda表达式
        Like like6 = ()->{
            System.out.println("i like5");
        };
        like6.lambdas();
    }

    public static void main(String[] args){
        //匿名内部类
        Love lv1  = new Love(){
            @Override
            public void lambdas(int a){
                System.out.println("ilove a");
            }
        };
        lv1.lambdas(5);

        //6 lambda表达式
        Love lv = (int a)->{
            System.out.println("love "+a);
        };
        lv.lambdas(6);

        //简化2 去掉参数
        Love lv2 = (a)->{
            System.out.println("love "+a);
        };
        lv2.lambdas(5);

        //简化3 去掉括号
        Love lv3 = a->{
            System.out.println("love "+a);
        };
        lv3.lambdas(5);

        //简化4 去掉花括号
        Love lv4 = a->System.out.println("love "+a);
        lv4.lambdas(5);

    }
}
