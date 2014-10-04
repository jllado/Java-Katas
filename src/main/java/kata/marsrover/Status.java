package kata.marsrover;

public class Status {

    private String direction = "";

    public String position() {
        return "0,0";
    }

    public String direction() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
