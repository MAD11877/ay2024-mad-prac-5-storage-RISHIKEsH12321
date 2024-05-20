package sg.edu.np.mad.madpractical5;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(String n, String d, int i, boolean f){
        this.name = n;
        this.description = d;
        this.id = i;
        this.followed = f;
    }

    public User(String n, String d, boolean f){
        this.name = n;
        this.description = d;
        this.followed = f;
    }

    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
    }
    public void setUserName(String productname) {
        this.name = productname;
    }
    public String getUserName() {
        return this.name;
    }
    public void setUserDescription(String description) {
        this.description = description;
    }
    public String getUserDescription() {
        return this.description;
    }
    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
    public boolean getFollowed() {
        return this.followed;
    }



}