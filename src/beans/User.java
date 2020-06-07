package beans;


public  class  User {

    private  int id  ;
    private  String username  ;
    private  String email ;
    private  String password  ;
    private  String post  ;
    private  int status  ;

    public  User () { }

    public User(int id, String username, String email, String password, String post, int status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.post = post;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}