package ideaOfAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

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





}
