package dictionary.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-duplicate-file-in-system/solution/
 *
 * Input:
 * ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
 * Output:
 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
 */
public class FindDuplicateInFileSystem {

    public static List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> map = new HashMap<>();
        for (String dirInfo : paths) {
            String[] path = dirInfo.split(" ");
            String dir = path[0];
            for (int i = 1; i < path.length; i++) {
                String file = path[i];
                int contentStart = file.indexOf("(");
                String name = file.substring(0, contentStart);
                String content = file.substring(
                    contentStart + 1);

                List<String> files = map.getOrDefault(content, new ArrayList<>());
                files.add(dir + "/" + name);

                map.put(content, files);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getValue());
            }
        }

        return result;
    }

}
