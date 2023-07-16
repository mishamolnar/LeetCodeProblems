package LeetCode.dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillToNumber = new HashMap<>();
        Map<Integer, int[]> skillToTeam = new HashMap<>();
        int target = 0;
        for (int i = 0; i < req_skills.length; i++) {
            skillToNumber.put(req_skills[i], i);
            target |= (1 << i);
        }
        skillToTeam.put(0, new int[0]);
        for (int i = 0; i < people.size(); i++) {
            int personMask = 0;
            for (String skill : people.get(i)) {
                personMask |= (1 << skillToNumber.get(skill));
            }
            Map<Integer, int[]> temp = new HashMap<>(skillToTeam);
            for (Map.Entry<Integer, int[]> entry : skillToTeam.entrySet()) {
                int nextSkill = entry.getKey() | personMask;
                if (!temp.containsKey(nextSkill) || temp.get(nextSkill).length > entry.getValue().length + 1) {
                    int[] prev = skillToTeam.get(entry.getKey());
                    int[] next = new int[prev.length + 1];
                    System.arraycopy(prev, 0, next, 0, prev.length);
                    next[prev.length] = i;
                    temp.put(nextSkill, next);
                }
            }
            skillToTeam.putAll(temp);
        }
        return skillToTeam.get(target);
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SmallestSufficientTeam().smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},
                List.of(List.of("java"), List.of("nodejs"), List.of("nodejs", "reactjs")))));
    }
}
