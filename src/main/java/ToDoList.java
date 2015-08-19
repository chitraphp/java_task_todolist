import java.time.LocalDateTime;
import java.util.ArrayList;

public class ToDoList {
  private static ArrayList<ToDoList> instances = new ArrayList<ToDoList>();

  private String mDescription;
  private LocalDateTime mCreatedAt;
  private boolean mCompleted;
  private int mId;

  public ToDoList(String description) {
    mDescription = description;
    mCreatedAt = LocalDateTime.now();
    mCompleted = false;
    instances.add(this);
    mId = instances.size();
  }

  public String getDescription() {
    return mDescription;
  }

  public boolean isCompleted() {
    return mCompleted;
  }

  public LocalDateTime getCreatedAt() {
    return mCreatedAt;
  }

  public int getId() {
    return mId;
  }

  public void completeTask() {
    mCompleted = true;
  }

  public static ArrayList<ToDoList> getAll() {
    return instances;
  }

  public static ToDoList find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

  public static void clear() {
    instances.clear();
  }

  
}
