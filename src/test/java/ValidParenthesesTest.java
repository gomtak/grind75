import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    String input = "";
    List<Character> stringList = new ArrayList<>();
    @BeforeEach
    void setUp() {
        input = "({})";
    }

    @Test
    void question(){
        assertThat(solution(input)).isTrue();
    }

    boolean solution(String s){
        // 인풋값 체크
        if(s.length()%2 != 0) return false;

        for (char c : s.toCharArray()){
            // 클로져 검증
            if(checkCloser(c)){
                // 스택에 쌓인 짝 검증.
                if(checkPair(c)) continue;
                return false;
            }else {
                stringList.add(c);
            }
        }
        // 스택 역활 리스트에 빈값이 남아있는지 체크.
        if(stringList.size() != 0) return false;

        return true;
    }

    private boolean checkPair(char c) {
        if(stringList.size() == 0) return false;
        switch (c) {
            case ')':
                if(stringList.get(stringList.size() - 1) == '(') {
                    stringList.remove(stringList.size() - 1);
                    return true;
                }
                return false;
            case '}':
                if(stringList.get(stringList.size() - 1) == '{') {
                    stringList.remove(stringList.size() - 1);
                    return true;
                }
                return false;
            case ']':
                if(stringList.get(stringList.size() - 1) == '[') {
                    stringList.remove(stringList.size() - 1);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    boolean checkCloser(char close){
        switch (close) {
            case ')':
            case '}':
            case ']':
                return true;
            default:
                return false;
        }
    }
}