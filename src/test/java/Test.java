import io.github.splotycode.mosaik.util.prettyprint.PrettyPrint;
import io.github.splotycode.spellchecker.SpellChecker;
import io.github.splotycode.spellchecker.english.EnglishLanguage;

public class Test {

    public static void main(String[] args) {
        System.out.println(new PrettyPrint(new SpellChecker().getProblems(new EnglishLanguage(), "hello my my name is david and i have a apple and an bread and a")).prettyPrintType());
    }

}
