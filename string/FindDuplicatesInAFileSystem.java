package LeetCode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicatesInAFileSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            String[] curr = s.split(" ");
            for (int i = 1; i < curr.length; i++) {
                String content = curr[i].split("\\(")[1];
                String path = curr[0] + "/" + curr[i].split("\\(")[0];
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(path);
            }
        }

        List<List<String>> arr = new ArrayList<>();
        for (List<String> value : map.values()) {
            if (value.size() > 1)
                arr.add(value);
        }
        return arr;
    }

    public static void main(String[] args) {
        FindDuplicatesInAFileSystem findDuplicatesInAFileSystem = new FindDuplicatesInAFileSystem();
        System.out.println(findDuplicatesInAFileSystem.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));
    }
}
