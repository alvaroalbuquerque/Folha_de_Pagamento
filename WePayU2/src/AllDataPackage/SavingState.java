package AllDataPackage;

import Model.Employee;

import java.util.ArrayList;

public class SavingState {
    private ArrayList<AllData> states;
    private int currentState;

    public SavingState(AllData initialAllData) {
        states = new ArrayList<>();
        states.add(new AllData());
        currentState = 0;
    }

    public ArrayList<AllData> getStates() {
        return states;
    }

    public void setStates(ArrayList<AllData> states) {
        this.states = states;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public boolean prevState(AllData currentAllData){
        if(currentState > 0) {
            currentAllData.setEmployees((ArrayList<Employee>)states.get(currentState-1).getEmployees().clone());
            currentAllData.setSyndicateEmployee((ArrayList<Employee>)states.get(currentState-1).getSyndicateEmployee().clone());
            currentState--;
            return true;
        }else{
            return false;
        }
    }

    public boolean nextState(AllData currentAllData){
        if(currentState < this.states.size()-1){
            currentAllData.setEmployees((ArrayList<Employee>)states.get(currentState+1).getEmployees().clone());
            currentAllData.setSyndicateEmployee((ArrayList<Employee>)states.get(currentState+1).getSyndicateEmployee().clone());
            currentState++;
            return true;
        }else{
            return false;
        }
    }
    private void removingStates(int currentStatePlusOne){
        if(states.listIterator(currentStatePlusOne).hasNext()){
            removingStates(currentStatePlusOne+1);
            states.remove(currentStatePlusOne);
            this.currentState = currentStatePlusOne;
        }
    }
    public void addState(AllData currentAllData){
        if(currentState < (states.size()-1)) this.removingStates(currentState+1);

        states.add(new AllData((ArrayList<Employee>)currentAllData.getEmployees().clone(),
                (ArrayList<Employee>)currentAllData.getSyndicateEmployee().clone()));
        currentState += 1;
    }
    public AllData getCurrentAllDataState(){
        return states.get(currentState);
    }
}
