import java.util.*;

// 재귀
class Solution {

    HashMap<String, List<String>> digitMap = new HashMap<>() {{
        put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }};

    List<String> answer = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return answer;
        }

        create(digits, "");
        return answer;
    }

    public void create(String digits, String combination) {
        if (digits == null || digits.isEmpty()) {
            answer.add(combination);
            return;
        }

        List<String> charList = digitMap.get(String.valueOf(digits.charAt(0)));
        for (String ch : charList) {
            combination += ch;
            create(digits.substring(1, digits.length()), combination);
            combination = combination.substring(0, combination.length() - 1);
        }
    }
}


// Best answer in discussion
public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    if(digits.isEmpty()) return ans;
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length();i++){
        int x = Character.getNumericValue(digits.charAt(i));
        while(ans.peek().length()==i){
            String t = ans.remove();
            for(char s : mapping[x].toCharArray())
                ans.add(t+s);
        }
    }
    return ans;
}

public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    if(digits.isEmpty()) return ans;
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    while(ans.peek().length()!=digits.length()){
        String remove = ans.remove();
        String map = mapping[digits.charAt(remove.length())-'0'];
        for(char c: map.toCharArray()){
            ans.addLast(remove+c);
        }
    }
    return ans;
}