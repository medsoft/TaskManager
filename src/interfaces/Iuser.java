package interfaces;

import beans.User;

import java.util.List;

public interface Iuser {

    public User getLogin (String username , String password )  ;
    public  User get (int id ) ;
    public List<User> getTaskByUser (int id) ;
    public List<User> getAll () ;
}
