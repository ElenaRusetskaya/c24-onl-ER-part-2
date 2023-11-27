package by.teachmeskills.lesson31.adapter;

public class ConstructionTeamClassAdapter extends ConstructionTeam implements WorkersAdapter {
    @Override
    public Workers get10Workers() {
        return getWorkers();
    }
    @Override
    public Workers get5Workers() {
        Workers workers= getWorkers();
        return requiredNumberEmployees(workers,4);
    }
    @Override
    public Workers get3Workers() {
        Workers workers= getWorkers();
        return requiredNumberEmployees(workers,2);
    }
    private Workers requiredNumberEmployees(Workers workers, int i) {
        return new Workers(workers.getWorkers()/i);
    }
}
