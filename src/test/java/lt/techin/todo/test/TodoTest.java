package lt.techin.todo.test;

import lt.techin.todo.TodoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodoTest extends BaseTest {

//1.Prideti "Darbu saraso" elementa:
//    Atidarykite "Darbu saraso" puslapi ir pridekite nauja darbo uzduoti.
//    Patikrinkite, ar prideta darbo uzduotis atsirado sarase.
    @Test
    void addNewTaskElement() {
        TodoPage todoPage = new TodoPage(driver);

        String newTaskText = "isplauti indus";
        palaukti();

        int taskCountBefore = todoPage.isNewElementOnTheList();
        System.out.println("Result: Number of tasks before is: "+taskCountBefore);

        todoPage.addNewElement(newTaskText);
        palaukti();

        int taskCountAfter = todoPage.isNewElementOnTheList();
        Assertions.assertEquals(taskCountBefore + 1, taskCountAfter, "Naujas elementas nebuvo pridėtas į sąrašą");
        System.out.println("Result: Number of tasks after is: "+taskCountAfter);

        String actual=todoPage.getLastElementText();
        palaukti();
        Assertions.assertEquals(newTaskText, actual);
    }
//    2. Pazymeti "Darbu saraso" elementa kaip "Atlikta":
//    Pazymekite esama darbo uzduoti kaip atlikta.
//    Patikrinkite ar elemento busena pasikeite i "atlikta".
//    Patikrinkite ar kitu elementu busena nepasikeite.

@Test
public void markTaskElementAsCompleted() {
    TodoPage todoPage = new TodoPage(driver);

    todoPage.markLastElement();
    palaukti();




}

//    3. Istrinti "Darbu saraso" elementa:
//    Istrinkite konkretu darbo uzduoties elementa is saraso.
//        Isitikinkite, kad istrinto elemento nebera sarase.



}
