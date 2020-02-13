package test;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

/**
 * @author Ryan
 * @data 2020/02/13 - 周四
 */
public class RandomDistribution {
    private static Random random;  //伪随机序列生成器
    private static long seed;      //随机种子

    static {                       //随机初始化
        seed = System.currentTimeMillis();
        random = new Random(seed); //Random(long seed)      使用单个 long 种子创建一个新的随机数生成器。
    }

    private RandomDistribution() { }

    /**
     * @param s the seed
     */
    public static void setSeed(long s){
        seed  = s;
        random = new Random(seed);
    }

    /**
     * @return the Seed
     */
    public static long getSeed() {return seed;}
    /**
     * Uniform Distribution generator
     * @return a random real number uniformly in [0,1)
     */
    public static double uniform(){ return random.nextDouble(); }
    @Deprecated
    public static double random() { return uniform(); }

    /**离散整数随机分布
     * @param n the range of random Integer (0,...,n-1)
     * @return int
     */
    public static int uniform_discreteInt(int n){
        if(n<=0) throw new IllegalArgumentException("argument must be positive: " + n);
        return random.nextInt();
    }

    public static long uniform(long n){
        if(n<=0L) throw new IllegalArgumentException("argument must be positive: " + n);
        long r = random.nextLong();     //获取一个随机数
        long m = n-1;
        if((n & m) == 0L){              //如果n是2的幂次方
            return r & m;
        }
        long u = r >> 1;
        while (u + m - (r = u % n) < 0L){
            u = random.nextLong() >>> 1;
        }
        return r;
    }


}
