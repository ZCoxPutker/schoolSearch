package schoolsearch.model;

public class Response {

    private Object payload;

    public Response(Object payload) {
        this.payload = payload;
    }

    public Object getPayload() { return payload; }

    public void setPayload(Object payload) {this.payload = payload; }
}
