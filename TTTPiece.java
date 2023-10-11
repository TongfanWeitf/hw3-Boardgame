//ttt pieces including X and O
public class TTTPiece implements Cell{
    String Name;
    int id;
    public TTTPiece(int i){
        this.setId(i);
    }
    @Override
    public String getName(){
        return Name;
    }
    @Override
    public void setId(int i){
        id = i;
        if (id == 0){
            Name = " ";
        }else if (id == 1){
            Name = "X";
        }else if (id == -1){
            Name = "O";
        }
    }
    @Override
    public int getId(){
        return id;
    }

}
