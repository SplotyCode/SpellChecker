package io.github.splotycode.spellchecker.check;

import io.github.splotycode.spellchecker.element.Element;
import io.github.splotycode.spellchecker.token.Token;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ProblemCollector {

    private ArrayList<Problem> problems = new ArrayList<>();

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

    public void addProblem(Element element, String message) {
        problems.add(new Problem(element, message));
    }

    public void addProblem(Token token, String message) {
        problems.add(new Problem(token, message));
    }

    public void addProblem(Token first, Token second, String message) {
        problems.add(new Problem(first, second, message));
    }

    public void addProblem(Element first, Element second, String message) {
        problems.add(new Problem(first, second, message));
    }

}
