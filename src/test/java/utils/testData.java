package utils;


public enum testData {
    BRANDDETAILS("Tommy Hilfiger", "The request succeeded");


//    CREATED(201, "A new resource was created"),
//    BAD_REQUEST(400, "Missing required field: name"),
//    UNAUTHORIZED(401, "Invalid access token"),
//    NOT_FOUND(404, "Cannot Find Requested Resource"),
//    NO_CONTENT(204, "No content to send in the response body");

    public final String name;
    public final String msg;


    testData(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }
}
