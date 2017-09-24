package by.home.client;


import by.home.model.Message;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        Invocation prepareRequestForYear = prepareRequestForYear(2015);
        Response response = prepareRequestForYear.invoke();
        System.out.println(response);
    }

    private static Invocation prepareRequestForYear(int year) {
        Client client = ClientBuilder.newClient();
        return client.target("http://localhost:8080/webapi")
                .path("messages")
                .queryParam("year", year)
                .request(MediaType.APPLICATION_JSON)
                .buildGet();

    }
}
