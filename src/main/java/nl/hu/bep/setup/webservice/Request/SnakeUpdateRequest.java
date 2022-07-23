package nl.hu.bep.setup.webservice.Request;

public class SnakeUpdateRequest {
    private String color;
    private String head;
    private String tail;

    public SnakeUpdateRequest(String color, String head, String tail) {
        this.color = color;
        this.head = head;
        this.tail = tail;
    }
    public SnakeUpdateRequest(){

    }

    public String getColor() {
        return color;
    }

    public String getHead() {
        return head;
    }

    public String getTail() {
        return tail;
    }

    public void setColour(String color) {
        this.color = color;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
