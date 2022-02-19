package T;

interface People {
    public void Show();
}

class Student implements People {
    public void Show() {
        System.out.println("study");
    }
}

class Teacher implements People {
    public void Show() {
        System.out.println("teach");
    }
}


public class TaiDemo2 {
    public static void run(People p) {//接口People
        p.Show();
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Teacher t1 = new Teacher();

        run(s1);    //实现类的对象 赋值 给 接口对象，自动调用接口对象对应的方法
        run(t1);
    }
}
