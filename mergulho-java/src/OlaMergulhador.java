public class OlaMergulhador {
    public static void main(String[] args) {
        System.out.println("Olá, merguhador!");
        //comentar linha: ctrl + /
        /*comentar em bloco: ctrl + shift + / */

        String nomeCompleto;
        nomeCompleto = "Sergio Caique da Silva";

        System.out.println("Nome: " + nomeCompleto);

        int idade;
        idade = 20;

        System.out.println("Idade: " + idade);

        double peso;
        peso = 75.0d;

        System.out.println("Peso: " + peso);

        float taxa = 1_295.0f;

        boolean compraAprovada = false;

        boolean maiorDeIdade = idade > 18;
        System.out.println(maiorDeIdade);
    }
}
