package beans;

import java.time.LocalDate;

public class Project {

    private int  id ;
    private String name  ;
    private LocalDate startDate ;
    private LocalDate endDate ;
    private String type ;
    private String description ;
    private int status ;
    private int Illustration  ;
    private User user  ;

    public Project () {}



    public Project(int id, String name, LocalDate startDate, LocalDate endDate, String type, String description , int status, int illustration, User user) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.description  =  description  ;
        this.status = status;
        Illustration = illustration;
        this.user = user;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIllustration() {
        return Illustration;
    }

    public void setIllustration(int illustration) {
        Illustration = illustration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", Illustration=" + Illustration +
                ", user=" + user +
                '}';
    }
}
