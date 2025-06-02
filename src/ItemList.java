import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;

public class ItemList implements Handler {

    // This class implements the Handler interface to handle HTTP requests
    // and respond with a list of clothing items.

    // The items array holds the clothing items to be listed.
    private Clothing[] items;

    // Constructor to initialize the ItemList with an array of Clothing items.
    public ItemList(Clothing[] items) {
        this.items = items;
    }

    // The accept method is called when a request is received.
    public void accept(ServerRequest serverRequest, ServerResponse serverResponse) {
        serverResponse.status(Http.Status.OK_200);
        serverResponse.headers().put("Content-Type", "text/plain", "charset=UTF-8");
        StringBuilder result = new StringBuilder();
        for (Clothing item : items) {
            // Append each item's description to the result.
            result.append(item).append("\n");
        }
        serverResponse.send(result.toString());
    }
}
