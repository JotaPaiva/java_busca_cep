package modelo;

import com.google.gson.Gson;
import modelo.Endereco;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCEP {

    public Endereco buscaEndereco(String cep) {

        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();
        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Endereco.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String retornaDados(Endereco endereco) {
        return  "\n" + "CEP: " + endereco.cep() + "\n" +
                "Logradouro: " + endereco.logradouro() + "\n" +
                "Bairro: " + endereco.bairro() + "\n" +
                "Cidade: " + endereco.localidade() + "\n" +
                "Estado: " + endereco.uf();
    }

}
