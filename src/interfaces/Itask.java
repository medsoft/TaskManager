package interfaces;

import beans.Task;

import java.util.List;

public interface Itask {

    public int add (Task ts ) ;
    public  Task get (int id ) ;
    public  List<Task> getTaskByProject (int id ) ;
    public List<Task> getAll () ;
}
