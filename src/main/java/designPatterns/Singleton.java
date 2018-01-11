package designPatterns;

/**
 *
 * lys
 *
 * 2018年1月11日  上午11:07:53
 *
 */
public enum Singleton {
    INSTANCE;
    private A a;
    Singleton(){
	a = new A();
	System.out.println("枚举私有的构造方法");
    }
    
    public A getInstance(){
	return a;
    }
    
}

/**
 * 需要单例的类
 *
 * lys
 *
 * 2018年1月11日  上午11:10:05
 *
 */
class A{
    public static void main(String[] args) {
	Singleton.INSTANCE.getInstance();
	Singleton.INSTANCE.getInstance();
	Singleton.INSTANCE.getInstance();
    }
}


