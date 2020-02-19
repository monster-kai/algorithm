package math;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Ryan
 * @data 2020/02/16 - 周日
 * 5343. 多次求和构造目标数组  学习优先级队列
 */
public class L5343 {
    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            pq.add(target[i]);
            sum += target[i];
        }

        while(sum!=target.length){
            int curr = pq.poll();
            int rest = sum-curr;
            int pre = curr - rest;
            if(pre>=curr || pre<1)   return false;
            sum = curr;
            pq.add(pre);
            curr = pq.poll();
        }
        return true;

    }

}
