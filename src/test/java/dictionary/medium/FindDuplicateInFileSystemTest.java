package dictionary.medium;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class FindDuplicateInFileSystemTest {

    @Test
    @Ignore
    public void findDuplicate() {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};

        final List<List<String>> duplicates = FindDuplicateInFileSystem.findDuplicate(paths);
        String[][] duplicateErr = new String[duplicates.size()][50];
        final String[][] actuals = (String[][]) duplicates.toArray();

        String[][] expected = new String[][] {{"root/a/2.txt", "root/c/d/4.txt", "root/4.txt"}, {"root/a/1.txt", "root/c/3.txt"}};
        final List<String[]> strings = Arrays.asList(expected);
        Assert.assertArrayEquals(expected, actuals);
    }
}