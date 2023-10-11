public class Player {
    public String Name;
    public int score;

    public Player(String n, int s){
        this.Name = n;
        this.score = s;
    }
    public void setName(String s){
        Name=s;
    }
    public String getName(){
        return Name;
    }

}
