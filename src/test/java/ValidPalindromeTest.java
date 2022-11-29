import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

class ValidPalindromeTest {
    String s = "";
    @BeforeEach
    void setUp() {
        s = "0P";
    }
    @Test
    void run(){
        assertThat(solution(this.s)).isFalse();
    }
    boolean solution(String s){
        s = convertString(s);
        return newCheckChar(s);
    }
    boolean newCheckChar(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    boolean checkChar(String s) {
        if(s.length() == 1) return true;
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    String convertString(String preString){
        return preString.toLowerCase().replaceAll("[^a-z0-9]", "");
    }
}