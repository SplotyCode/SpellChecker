import io.github.splotycode.mosaik.util.StringUtil;
import io.github.splotycode.mosaik.util.io.FileUtil;
import io.github.splotycode.mosaik.util.io.IOUtil;
import io.github.splotycode.spellchecker.dictfile.LineSeparator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Transform {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        for (String line : IOUtil.resourceToText("/en/dict.dict").split(LineSeparator.WINDOWS.getSeparatorString())) {
            if (line.startsWith("#")) continue;
            list.add(line);
        }
        System.out.println(list.size());
        for (String line : IOUtil.resourceToText("/res/automatisation/firstnames.txt").split(LineSeparator.UNIX.getSeparatorString())) {
            list.remove(line.toLowerCase());
        }
        //for (String line : IOUtil.resourceToText("/res/automatisation/lastnames.txt").split(LineSeparator.UNIX.getSeparatorString())) {
        //    list.remove(line.toLowerCase());
        //}
        for (String line : IOUtil.resourceToText("/res/automatisation/middlenames.txt").split(LineSeparator.UNIX.getSeparatorString())) {
            list.remove(line.toLowerCase());
        }
        FileUtil.writeToFile(new File("dictnonames.dict"), StringUtil.join(list, "\n"));
    }

}
