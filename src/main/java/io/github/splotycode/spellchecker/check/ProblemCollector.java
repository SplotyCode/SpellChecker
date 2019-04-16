package io.github.splotycode.spellchecker.check;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ProblemCollector {

    private ArrayList<Problem> problems = new ArrayList<>();

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

}
