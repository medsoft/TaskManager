package interfaces;

import beans.Project;

import java.util.List;

public interface Iproject {

    public  int add (Project pr) ;
    public  int update (Project pr) ;
    public  int delete (Project pr) ;
    public Project get (int id) ;
    public List<Project> getAll () ;
}
