package model;

import beans.User;
import config.Database;
import interfaces.Iuser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IuserDao  implements Iuser {

    /*
    Fonction de connection
     */
    Database database =  new Database() ;
    @Override
    public User getLogin(String username, String password) {
        User  user = null ;
        String sql  =  "SELECT * from users WHERE username = ? AND password = ? " ;

        try {

            database.initPrepare(sql);
            database.getPstm().setString(1,username);
            database.getPstm().setString(2,password);
            ResultSet resultSet  = database.executeSelect() ;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setPost(resultSet.getString(5));
                user.setStatus(resultSet.getInt(6));
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
        return user ;

    }

    /*
    recupere un utilisateur
     */
    @Override
    public User get(int id) {
        User user  = null ;
        String sql =  "SELECT * FROM users WHERE id = ? " ;

      try {
          database.initPrepare(sql);
          database.getPstm().setInt(1,id);
          ResultSet resultSet = database.executeSelect() ;
          if (resultSet.next()){
              user = new User() ;
              user.setId(resultSet.getInt(1));
              user.setUsername(resultSet.getString(2));
              user.setEmail(resultSet.getString(3));
              user.setPassword(resultSet.getString(4));
              user.setPost(resultSet.getString(5));
              user.setStatus(resultSet.getInt(6));
          }
      }catch (Exception e)
      {
          e.printStackTrace();
      }
        return user;
    }

    @Override
    public List<User> getTaskByUser(int id) {
        return null;
    }

    /*
    fetch all users in the table users
     */
    @Override
    public List<User> getAll() {
        List<User> userList =  new ArrayList<>() ;
        String sql = "SELECT * FROM users " ;
        try {
            database.initPrepare(sql);
            ResultSet resultSet =  database.executeSelect() ;
            if (resultSet.next()){
                User user = new User()  ;
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                user.setPost(resultSet.getString(5));
                user.setStatus(resultSet.getInt(6));

                userList.add(user) ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }
}
