package xzx.sword2offer.problem.简单;

import java.util.HashMap;
import java.util.Map;

public class 寻找数组重复数字 {


    static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int number=0;
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                number=nums[i];
                break;
            }
            else
            {
                map.put(nums[i],i);
            }
        }


        return number;
    }

//    public static void main(String[] args) {
//        int[]nums={2,3,1,0,2,5,3};
//        int a=寻找数组重复数字(nums);
//        System.out.println(a);
//    }
}
