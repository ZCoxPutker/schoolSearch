package schoolsearch.model;

public class SchoolResponse {

    private Object payload;

    public SchoolResponse(Object payload) {
        this.payload = payload;
    }

    public Object getPayload() { return payload; }

    public void setPayload(Object payload) {this.payload = payload; }
}
