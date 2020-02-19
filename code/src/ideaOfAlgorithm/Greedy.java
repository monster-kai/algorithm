package ideaOfAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan
 * @data 2020/02/16 - 周日
 * @contents 区间调度问题
 */
public class Greedy {
    /**
     * LEET5342. 最多可以参加的会议数目
     * @param events events[0][0]:events[0]的开始时间，events[0][1]:events[0]的结束时间。
     *               每一个会议选规定时间内的一天参加即可，并且每天只能参加一场会议
     * @return 日程表可以参加的最多场次数目
     */
    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> o1[1]!=o2[1]? o1[1]-o2[1] : o1[0]-o2[0]);   //lambda表达式
//        Arrays.sort(events, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[1]!=o2[1]) return o1[1]-o2[1];
//                else return o1[0]-o2[0];
//            }
//        });
        int events_num = events.length;
        int cnt = 0;
        boolean[] calender = new boolean[100002];               //因为题目制定会议安排在1~10000天，如果没有此项约束，可以用HashSet与contains组合判定
        for (int i = 0; i < events_num; i++) {
            int start = events[0][0];
            int end = events[0][1];
            for(int j=start; j<=end; j++){
                if(calender[j]==false) {
                    calender[j]=true;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    /**
     * 问题延伸  类似教室借用问题
     * @param events  会议起始时间到结束必须参加才算完成一次会议
     * @return
     */
    public static int maxEvents2(int[][] events){
        Arrays.sort(events, (o1, o2) -> o1[1]!=o2[1]? o1[1]-o2[1] : o2[0]-o1[0]);   //lambda表达式,结束时间越早，持续时间越短的排在前边
        int r = 0;
        int cnt = 0;
        for(int[] e:events){
            if(e[0]>r) {
                r = e[1];
                cnt++;
            }
        }
        return cnt;
    }





}
