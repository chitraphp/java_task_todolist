import java.time.LocalDateTime;

import org.junit.*;
import static org.junit.Assert.*;

public class ToDoListUnitTest {
  @Rule
  public ClearRule  clearRule= new ClearRule();

  @Test
  public void todolist_instantiatesCorrectly_true() {
    ToDoList myTask = new ToDoList("Mow the lawn");
    assertEquals(true, myTask instanceof ToDoList);
  }

  @Test
 public void todolist_instantiatesWithDescription_true() {
   ToDoList myTask = new ToDoList("Mow the lawn");
   assertEquals("Mow the lawn", myTask.getDescription());
 }

 @Test
  public void isCompleted_isFalseAfterInstantiaon_false() {
    ToDoList myTask = new ToDoList("Mow the lawn");
    assertEquals(false, myTask.isCompleted());
  }

  @Test
  public void getCreateAt_instantiatesWithCurrentTime_today() {
    ToDoList myTask = new ToDoList("Mow the lawn");
    assertEquals(LocalDateTime.now().getDayOfWeek(), myTask.getCreatedAt().getDayOfWeek());
  }

  @Test
    public void all_returnsAllInstancesOfTask_true() {
      ToDoList firstTask = new ToDoList("Mow the lawn");
      ToDoList secondTask = new ToDoList("Buy groceries");
      assertTrue(ToDoList.getAll().contains(firstTask));
      assertTrue(ToDoList.getAll().contains(secondTask));
    }

    @Test
      public void newId_tasksInstantiateWithAnID_true() {
        ToDoList firstTask = new ToDoList("Mow the lawn");
        ToDoList secondTask = new ToDoList("Buy groceries");
        assertEquals(ToDoList.getAll().size(), secondTask.getId());
      }

      @Test
    public void find_returnsNullWhenNoTaskFound_null() {
      assertTrue(ToDoList.find(999) == null);
    }

    @Test
    public void clear_emptiesAllTasksFromArrayList() {
    ToDoList myTask = new ToDoList("Mow the lawn");
    ToDoList.clear();
    assertEquals(ToDoList.getAll().size(), 0);
  }

}
