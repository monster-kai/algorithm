package sort;

/**
 *  LSD 低位优先的字符串排序
 * @author Ryan
 * @data 2020/02/13 - 周四
 */

public class LSD_string_sort {
    /**
     * @param a 字符串数组
     * @param w 根据前w个字符排序
     */
    public static void sort(String[] a, int w){
        int N = a.length;
        int R = 256;                    //扩展的ASCII码 在1~255之间 基数为256 0000000 表示空字符null
        String[] aux = new String[N];

        for(int d=w-1; d>=0; d--){
            int[] count = new int[R+1];
            for(int i=0; i<N; i++) { count[a[i].charAt(d)+1]++; }             //统计w位置字符

            for(int r=0; r<R; r++) { count[r+1] += count[r]; }                //频率转化成索引

            for(int i=0; i<N; i++) { aux[count[a[i].charAt(d)]++] = a[i]; }   //将字符按照字符表顺序放置

            for(int i=0; i<N; i++) { a[i] = aux[i]; }                         //会写到原来的字符串数组

        }
    }

    public static void main(String[] args) {
        String[] a = {"acs","soe","fda"};
        sort(a, 1);
        for (String s : a) {
            System.out.println(s);
        }

    }



}
