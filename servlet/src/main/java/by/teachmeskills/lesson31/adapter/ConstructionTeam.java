package by.teachmeskills.lesson31.adapter;

public class ConstructionTeam {
    public Workers getWorkers() {
        return new Workers(10);
    }
}
