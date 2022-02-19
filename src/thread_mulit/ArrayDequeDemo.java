import java.util.ArrayDeque;

//ArrayDeque的使用
public class ArrayDequeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayDeque<Integer> aDeque = new ArrayDeque<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if ((i & 1) == 0) {
                //System.out.println(arr[i]);
                //如果i是偶数从队头加入，否则从队尾加入
                aDeque.addFirst(arr[i]); //加入队首
            } else
                aDeque.addLast(arr[i]);

        }
        //队列中元素的位置如下：
        //7
        //5
        //3
        //1
        //2
        //4
        //6
        //8

        while (!aDeque.isEmpty()) {
            int v = aDeque.pop();//依次从对首取出
            System.out.println(v);
        }

//        while(!aDeque.isEmpty()) {
//            int v = aDeque.pollLast();
//            System.out.println(v);
//        }

//        while(!aDeque.isEmpty())
//        {
//            aDeque.pollFirst();
//            aDeque.pollLast();//此处不严谨但是由于arr的元素恰好是偶数个，本例中也不会出现问题。
//        }
    }

}


