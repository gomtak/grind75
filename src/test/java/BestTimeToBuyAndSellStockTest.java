import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {
    int[] prices;
    @BeforeEach
    void setUp() {
        prices = new int[] {7,1,5,3,6,4};
    }
    @Test
    void main(){
        System.out.println(solution());
    }
    int solution(){
        int min = Integer.MAX_VALUE;
        int result = 0;
        int gap = 0;

        for(int i : prices){
            if(i < min){
                min = i;
            }
            gap = i - min;
            if(result < gap){
                result = gap;
            }
        }
        return result;
    }

    int solution_timeLimit2(){
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(result < prices[j]-prices[i]) result = prices[j]-prices[i];
            }
        }
        return result;
    }
    int solution_timeLimit(){
        ArrayList resultArr = new ArrayList<>();
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if(prices[j]-prices[i] > 0) resultArr.add(prices[j]-prices[i]);
            }
        }
        int result = resultArr.stream().mapToInt(x-> (int) x).max().orElse(0);
        return result;
    }
}