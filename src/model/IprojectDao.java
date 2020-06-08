package model;

import beans.Project;
import config.Database;
import interfaces.Iproject;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IprojectDao implements Iproject {


    Database database = new Database() ;
    @Override
    public int add(Project pr) {
        String sql  = "INSERT INTO projects VALUES (NULL,?,?,?,?,?,?,?,?)  "  ;

        int ok = 0  ;
        try {
            database.initPrepare(sql);
            database.getPstm().setString(1,pr.getName());
            database.getPstm().setString(2 ,pr.getStartDate().toString());
            database.getPstm().setString(3,pr.getEndDate().toString());
            database.getPstm().setString(4 , pr.getType());
            database.getPstm().setString(5,pr.getDescription());
            database.getPstm().setInt(6, pr.getUser().getId());
            database.getPstm().setInt(7, pr.getStatus());
            database.getPstm().setInt(8, pr.getIllustration());
            ok = database.executeMaj() ;
        }catch (Exception e )
        {
            e.printStackTrace();
        }

        return ok;
    }

    @Override
    public int update(Project pr) {
        return 0;
    }

    @Override
    public int delete(Project pr) {
        return 0;
    }

    @Override
    public Project get(int id) {
        return null;
    }

    @Override
    public List<Project> getAll() {

        List<Project> projectList = new ArrayList<>() ;
        String sql = "SELECT * FROM projects  " ;
     try {
         database.initPrepare(sql);
         ResultSet resultSet = database.executeSelect() ;
         while (resultSet.next()) {
             Project project = new Project() ;
             project.setId(resultSet.getInt(1));
             project.setName(resultSet.getString(2));
             project.setStartDate(LocalDate.parse(resultSet.getString(3)));
             project.setEndDate(LocalDate.parse(resultSet.getString(4)));
             project.setType(resultSet.getString(5));
             project.setDescription(resultSet.getString(6));
             project.setUser(new IuserDao().get(resultSet.getInt(7)));

             project.setStatus(resultSet.getInt(8));
             project.setIllustration(resultSet.getInt(9));

             projectList.add(project) ;
         }



     }catch (Exception e) {
         e.printStackTrace();

     }
        return projectList;
    }
}
