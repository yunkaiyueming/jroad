package other;

public class FinalDemo {
    final int a = 20;//不可修改

    public static void main(String[] args){
        FinalDemo de = new FinalDemo();
        try{
//            de.a = 20;//不可修改
            int b = 11;
            if(b==10){
                throw new Exception("b不能为10");
            }else{
                //de.funDemo();
                de.funDemo2();
            }

        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            System.out.println("结束前必须会运行我，比如关闭资源");
        }
    }

    public void funDemo() throws Exception{
        throw new Exception("出错了，b没有为10");
    }

    public void funDemo2() throws Exception{
        throw new MyExceptionDemo("出错了，抛出我自己的异常对象");
    }
}
