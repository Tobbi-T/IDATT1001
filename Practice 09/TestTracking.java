import java.util.ArrayList;

class TestTracking {
  public static void main(String[] args) {
    Student t = new Student("Ole", 1);
    Student h = new Student("Jonas", 5);
    Student j = new Student("Bjørn", 3);

    TaskView tv = new TaskView("BIDATA");
    tv.addStudent(t);
    tv.addStudent(h);
    tv.addStudent(j);

    System.out.printf("Antall studenter registrert: %d\n", tv.getNumberOfStudents());
    for (Student s : tv.getStudentList()) {
      System.out.printf("Antall oppgaver %s har løst: %d\n", s.getName(), s.getTasksApproved());
    }

    System.out.println("Legger til 2 oppgaver på Tobias");
    t.incTasksApproved(2);
    for (Student s : tv.getStudentList()) {
      System.out.printf("Antall oppgaver %s har løst: %d\n", s.getName(), s.getTasksApproved());
    }
  }
}

class Student {
  private final String name;
  private int tasksApproved;

  public Student(String name, int tasksApproved) {
    this.name = name;
    this.tasksApproved = tasksApproved;
  }

  public Student(String name) {
    this.name = name;
    this.tasksApproved = 0;
  }

  public Student(Student s) {
    this.name = s.name;
    this.tasksApproved = s.tasksApproved;
  }

  public String getName() {
    return name;
  }

  public int getTasksApproved() {
    return tasksApproved;
  }

  public void incTasksApproved(int increment) {
    tasksApproved += increment;
  }

  public String toString() {
    return "Student{" + "name='" + name + '\'' + ", tasksApproved=" + tasksApproved + '}';
  }
}

class TaskView {
  private final String name;
  private final ArrayList<Student> students = new ArrayList<>();

  public TaskView(String name) {
    this.name = name;
  }

  public void addStudent(Student s) {
    students.add(s);
  }

  public Student getStudent(int index) {
    return new Student(students.get(index));
  }

  public Student[] getStudentList() {
    return students.toArray(new Student[0]);
  }

  public int getNumberOfStudents() {
    return students.toArray().length;
  }

  public String toString() {
    return "TaskView{" + "name='" + name + '\'' + ", students=" + students + '}';
  }
}
