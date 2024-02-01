package lt.techin.todo.test;

import lt.techin.todo.TodoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoTest extends BaseTest {
    String newTaskText = "isplauti indus";

//1.Prideti "Darbu saraso" elementa:
//    Atidarykite "Darbu saraso" puslapi ir pridekite nauja darbo uzduoti.
//    Patikrinkite, ar prideta darbo uzduotis atsirado sarase.
    @Test
    void addNewTaskElement() {
        TodoPage todoPage = new TodoPage(driver);

        int taskCountBefore = todoPage.isNewElementOnTheList();
        System.out.println("Result: Number of tasks before is: "+taskCountBefore);

        todoPage.addNewElement(newTaskText);

        int taskCountAfter = todoPage.isNewElementOnTheList();
        System.out.println("Result: Number of tasks after is: "+taskCountAfter);

        String actual=todoPage.getLastElementText();

        Assertions.assertEquals(newTaskText, actual);
    }
//    2. Pazymeti "Darbu saraso" elementa kaip "Atlikta":
//    Pazymekite esama darbo uzduoti kaip atlikta.
//    Patikrinkite ar elemento busena pasikeite i "atlikta".
//    Patikrinkite ar kitu elementu busena nepasikeite.

@Test
public void markTaskElementAsCompleted() {
    TodoPage todoPage = new TodoPage(driver);
    todoPage.addNewElement(newTaskText);

    boolean initialElementsState = todoPage.elementsState();

    todoPage.markLastElement();

    boolean isLastElementCompleted = todoPage.isElementCompleted();
    System.out.println("Result: Is the last element marked as completed? " + isLastElementCompleted);

    boolean finalElementsState = todoPage.elementsState();
    System.out.println("Result: Are other elements' states unchanged? " + (initialElementsState == finalElementsState));
}

//    3. Istrinti "Darbu saraso" elementa:
//    Istrinkite konkretu darbo uzduoties elementa is saraso.
//        Isitikinkite, kad istrinto elemento nebera sarase.

    @Test
    public void deleteTaskElement() {
        TodoPage todoPage = new TodoPage(driver);
        todoPage.addNewElement(newTaskText);
        todoPage.markLastElement();
        todoPage.toBin();

        String deletedElementText = todoPage.getLastElementText();
        System.out.println("Result: Is the element '" + deletedElementText + "' still in the list? "
                + todoPage.isElementInList(deletedElementText));
    }
}
