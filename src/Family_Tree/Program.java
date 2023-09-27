package Family_Tree;

import Family_Tree.presenter.Presenter;
import Family_Tree.UI.ConsoleUI;

public class Program {


    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        Tree<Human> familyTree = new Tree<>(fileHandler);
        Presenter presenter = new Presenter(familyTree);
        ConsoleUI consoleUI = new ConsoleUI(familyTree, fileHandler, presenter);
        consoleUI.start();

    }
}