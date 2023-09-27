package Family_Tree.commands;

import Family_Tree.UI.ConsoleUI;
public class SaveFinish implements Commands{
    ConsoleUI consoleUI;

    public SaveFinish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().saveFamilyTree();
        System.exit(0);
    }

    @Override
    public String description() {
        return "завершение программы и сохранение FamilyTree";
    }
}