package chapter04;

import java.util.concurrent.TimeUnit;

/**
 * 4-15
 */
public class Profiler {

    // 第一次 get() 方法调用时会进行初始化（如果 set 方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(System::currentTimeMillis);

    public static void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
