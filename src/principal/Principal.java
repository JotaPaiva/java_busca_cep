package principal;

import modelo.ConsultaCEP;
import modelo.Endereco;
import modelo.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ConsultaCEP consulta = new ConsultaCEP();

        System.out.print("Insira o CEP que você deseja buscar: ");
        var cep = scanner.next();

        Endereco novoEndereco = consulta.buscaEndereco(cep);

        System.out.println(consulta.retornaDados(novoEndereco));

        GeradorDeArquivo gerador = new GeradorDeArquivo();
        gerador.salvaJson(novoEndereco);

    }

}
