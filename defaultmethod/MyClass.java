package defaultmethod;

public class MyClass {
    public static void main(String[] args) {
        //接口中的默认方法，接口中可以直接用
        //1.父类中的同名方法优先于接口 2.实现多个接口中有相同方法，必须显示声明使用哪个方法
        String name = new MyFunImpl().getName();
        System.out.println(name);
        //接口中的静态方法
        MyFun.sayHello();
    }
}
