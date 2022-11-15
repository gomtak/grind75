import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

    // problem : https://leetcode.com/problems/two-sum/

    int[] nums;

    int target;
    int[] result = new int[2];

    @BeforeEach
    void setUp() {
        nums = new int[] {2,7,11,15};
        target = 9;
    }
    @Test
    public void findIndex(){
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])){
                result[0] = hashMap.get(target-nums[i]);
                result[1] = i;
                System.out.println(Arrays.toString(result));
            }
            hashMap.put(nums[i],i);
        }
        assertThat(result).isEqualTo(new int[] {0,1});
    }
}