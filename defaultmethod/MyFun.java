package defaultmethod;

public interface MyFun {
    default String getName(){
        String name = "wangyang";
        return name;
    }

    public static void sayHello(){
        System.out.println("SayHello!");
    }
}
