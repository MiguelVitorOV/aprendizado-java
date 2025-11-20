import java.util.Scanner;

public class CrudSimples {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        String[] clientes = new String[1];
        int opcao = 0;
        int clienteAtual;
        int clienteExcluido;

        //Loop até o usuário querer sair
        while (opcao != 4) {
            System.out.println("\n======== Menu ========");
            System.out.println("1. Cadastrar Clientes");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Excluir Clientes");
            System.out.println("4. Encerrar programa");
            System.out.println("======================");

            //vendo a opcao do usuario, Integer.parseInt foi como achei para corrigir o erro do \n ao usar nextInt
            opcao = Integer.parseInt(input.nextLine());
            switch (opcao) {
                case 1:
                    System.out.println("Quantos clientes quer cadastrar?");

                    //se não tem cliente cadastrado
                    if (clientes[0] == null) {
                        clientes = new String[Integer.parseInt(input.nextLine())];
                        //ver qual cliente ele vai começar adicionando
                        clienteAtual = 0;
                    }
                    else {
                        //caso tenha cliente cadastro ele faz uma copia dos clientes cadastrados, inicializa
                        // o novo array de cliente e ai copia o backup pro array do cliente, assim podendo
                        //adicionar mais clientes
                        String clientesBackup[] = clientes.clone();
                        clienteAtual = clientes.length;
                        clientes = new String[clientes.length + Integer.parseInt(input.nextLine())];
                        System.arraycopy(clientesBackup, 0, clientes, 0, clienteAtual);
                    }
                    for (int i = clienteAtual; i < clientes.length; i++) {
                        System.out.printf("Cadastrando o cliente %d, qual é o nome dele?\n", (i+1));
                        clientes[i] = input.nextLine();
                    }

                    System.out.println("Clientes cadastrados com sucesso!");
                    break;
                case 2:
                    if (clientes[0] == null) {
                        System.out.println("Nenhum cliente foi encontrado!");
                        break;
                    }
                    System.out.println("Listando todos os clientes!");
                    for (int i = 0; i < clientes.length; i++) {
                        System.out.printf("Cliente %d: %s\n", (i+1), clientes[i]);
                    }
                    break;
                case 3:
                    System.out.println("Qual cliente deseja excluir? ");
                    clienteExcluido = Integer.parseInt(input.nextLine()) - 1;
                    clientes[clienteExcluido] = null;
                    String clientesBackup[] = new String[clientes.length];
                    if (clienteExcluido == clientes.length){
                        clientes = new String[clientesBackup.length-1];
                        System.arraycopy(clientesBackup, 0, clientes, 0, clientes.length);
                        break;
                    }
                    if (clienteExcluido == 0){
                        clientes = new String[1];
                        break;
                    }
                    for (int i = 0; i < clientes.length-1; i++) {
                        clientesBackup[i] = clientes[i];
                        if(clientesBackup[i] == null ){
                            clientesBackup[i] = clientes[i+1];
                            clientes[i+1] = null;
                        }
                    }
                    clientes = new String[clientesBackup.length-1];
                    System.arraycopy(clientesBackup, 0, clientes, 0, clientes.length);
                    break;
                case 4:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Escolha uma opção válida!\n\n");

            }
        }

        input.close();
    }
}
