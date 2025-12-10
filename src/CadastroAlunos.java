import java.util.Scanner;

public class CadastroAlunos {
        public static void main(String[] args) {
            int opcao = 0;
            Scanner sc = new Scanner(System.in);

            String[] turmas = new String[5];
            String[][] alunos = new String[5][5];
            //o segundo é o tanto de aluno cadastrado em turma
            int[][] idade = new int[5][5];
            //primeiro referencia ID turma, segundo referência aluno
            double[][][] notas = new double[5][5][2];
            int turmaEscolhida;

            while (opcao != 8){
                System.out.println("-----------------------------------");
                System.out.println("Bem vindo ao gerenciador de turmas!");
                System.out.println("O que deseja fazer?");
                System.out.println(" 1 - Cadastrar Turma");
                System.out.println(" 2 - Cadastrar Aluno");
                System.out.println(" 3 - Listar Turmas");
                System.out.println(" 4 - Listar Alunos de Uma Turma");
                System.out.println(" 5 - Mostrar Relatório da Turma");
                System.out.println(" 6 - Buscar aluno pelo nome");
                System.out.println(" 7 - Editar nota de aluno");
                System.out.println(" 8 - Sair");
                System.out.println("-----------------------------------");
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao){
                    case 1: //Cadastrar turma

                        //Mensagem de erro se todas as turmas estiverem cheias
                        System.out.println(turmas[(turmas.length-1)] != null? "TODAS AS TURMAS ESTÃO CHEIAS!\n\n" : "" );

                        for (int i = 0; i < turmas.length; i++) {
                            if (turmas[i] == null){
                                System.out.println("Cadastrando a turma " + (i+1));
                                System.out.println("Qual vai ser o nome da turma?");
                                turmas[i] = sc.nextLine();
                                System.out.println("Perfeito! Turma " + turmas[i] + " cadastrada\n\n");
                                break;
                            }

                        }
                        break;
                    case 2: //Cadastrar aluno
                        if (turmas[0] == null){ //Vendo se possui turma para cadastrar
                            System.out.println("Nenhuma turma cadastrada!\n\n");
                            break;
                        }

                        System.out.println("Perfeito! Escolha a turma que quer cadastrar o aluno:");

                        //Aqui ele lista todas as turmas
                        for (int i = 0; i < turmas.length; i++) {
                            if (turmas[i] == null){
                                break;
                            }
                            System.out.println((i+1) + ". " + turmas[i]);
                        }

                        //aqui ele pergunta qual a turma
                        turmaEscolhida = Integer.parseInt(sc.nextLine())-1;

                        //Tem vaga na turma?
                        if (alunos[turmaEscolhida][(alunos[turmaEscolhida].length-1)] != null){
                            System.out.println("TURMA LOTADA\n\n");
                            break;
                        }
                        for (int i = 0; i < alunos[turmaEscolhida].length; i++) {
                            if (alunos[turmaEscolhida][i] == null){ //Quando chegar no proximo valor nulo, ele cadastra
                                System.out.println("Cadastrando aluno " + (i+1));
                                System.out.println("Qual o nome dele?");
                                alunos[turmaEscolhida][i] = sc.nextLine();
                                System.out.println("Qual a idade dele?");
                                idade[turmaEscolhida][i] = Integer.parseInt(sc.nextLine());
                                for (int j = 0; j < notas[turmaEscolhida][i].length; j++) {
                                    System.out.println("Insira a nota " + (i+1));
                                    notas[turmaEscolhida][i][j] = Double.parseDouble(sc.nextLine());
                                }
                                System.out.println("ALUNO CADASTRADO COM SUCESSO!!");
                                System.out.println("Deseja Cadastrar mais algum aluno nessa turma?");
                                System.out.println("1. Sim          2. Não");
                                if (Integer.parseInt(sc.nextLine()) == 2){ //Ele pode continuar cadastrando
                                    System.out.println("Encerrando cadastro de alunos");
                                    break;
                                }
                            }
                        }
                        System.out.println("\n\n");
                        break;

                    case 3: //Listar Turmas
                        if (turmas[0] == null){ //Vendo se possui turma para cadastrar
                            System.out.println("Nenhuma turma cadastrada!\n\n");
                            break;
                        }
                        System.out.println("LISTANDO TURMAS: \n");
                        for (int i = 0; i < turmas.length; i++) {
                            if (turmas[i] == null){
                                break;
                            }
                            System.out.println("Turma " + (i+1) + ": " + turmas[i]);
                        }
                        System.out.println("\n\n");
                        break;

                    case 4: //Listar Alunos
                        if (turmas[0] == null){ //Vendo se possui turma para cadastrar
                            System.out.println("Nenhuma turma cadastrada!\n\n");
                            break;
                        }
                        System.out.println("De qual turma quer listar? ");
                        for (int i = 0; i < turmas.length; i++) {
                            if (turmas[i] == null){
                                break;
                            }
                            System.out.println((i+1) + ". " + turmas[i]);
                        }
                        turmaEscolhida = Integer.parseInt(sc.nextLine())-1;
                        if (alunos[turmaEscolhida][0] == null){
                            System.out.println("NENHUM ALUNO ENCONTRADO\n\n");
                            break;
                        }

                        for (int i = 0; i < alunos[turmaEscolhida].length; i++) {
                            if (alunos[turmaEscolhida][i] != null){//verifica se existe aluno
                                System.out.println("Aluno " + (i+1));
                                System.out.println("Nome: " + alunos[turmaEscolhida][i]);
                                System.out.println("Idade: " + idade[turmaEscolhida][i]);
                                System.out.print("Notas: ");
                                for (int j = 0; j < notas[turmaEscolhida][i].length; j++) {
                                    System.out.print(notas[turmaEscolhida][i][j] + " ");
                                }
                                System.out.println("\n--------------------------------");
                            }
                        }
                        System.out.println("\n\n");
                        break;
                    case 5: //Mostrar relatório
                        if (turmas[0] == null){ //Vendo se possui turma
                            System.out.println("Nenhuma turma cadastrada!\n\n");
                            break;
                        }
                        System.out.println("Você quer mostrar o relatório de qual turma?\n");
                        for (int i = 0; i < turmas.length; i++) {
                            if (turmas[i] == null){
                                break;
                            }
                            System.out.println("Turma " + (i+1) + ": " + turmas[i]);
                        }
                        turmaEscolhida = Integer.parseInt(sc.nextLine())-1;
                        System.out.print("Média geral da turma: ");

                        //CALCULO DA MÉDIA
                        double media = 0;
                        int qtdAlunos = 0;
                        for (int i = 0; i < notas[turmaEscolhida].length; i++) {
                            if(alunos[turmaEscolhida][i] == null){
                                break;
                            }
                            for (int j = 0; j < notas[turmaEscolhida][i].length; j++) {
                                media += notas[turmaEscolhida][i][j];
                            }
                            qtdAlunos++;
                        }
                        System.out.println(media/qtdAlunos);

                        //Vendo qtd alunos reprovados e aprovados, maior e menor média
                        int alunosAprovados = 0, alunosRecuperacao = 0, alunosReprovado = 0;
                        double maiorMedia = 0, menorMedia = 100;
                        int alunoMaior = 0, alunoMenor = 0;
                        for (int i = 0; i < notas[turmaEscolhida].length; i++) {
                            if(alunos[turmaEscolhida][i] == null){
                                break;
                            }
                            double mediaAluno = 0;
                            for (int j = 0; j < notas[turmaEscolhida][i].length; j++) {
                                mediaAluno += notas[turmaEscolhida][i][j];//soma a média do aluno
                            }
                            mediaAluno = mediaAluno/notas[turmaEscolhida][i].length;//divide pela qtd de notas

                            //Verifica a situação do aluno
                            if (mediaAluno >= 7.0){
                                alunosAprovados++;
                            }
                            else if(mediaAluno >= 5.0){
                                alunosRecuperacao++;
                            }
                            else {
                                alunosReprovado++;
                            }

                            //VERIFICANDO MAIOR E MENOR NOTA
                            if (mediaAluno > maiorMedia){
                                maiorMedia = mediaAluno;
                                alunoMaior = i;
                            } else if (mediaAluno < menorMedia) {
                                menorMedia = mediaAluno;
                                alunoMenor = i;
                            }
                        }
                        System.out.println("Alunos aprovados: " + alunosAprovados);
                        System.out.println("Alunos de recuperação: " + alunosRecuperacao);
                        System.out.println("Alunos reprovados: " + alunosReprovado);

                        System.out.println("Aluno com maior média: " + alunos[turmaEscolhida][alunoMaior]);
                        System.out.println("Aluno com menor média: " + alunos[turmaEscolhida][alunoMenor]);

                        System.out.println("\n\n");
                        break;
                    case 6: //Buscar aluno pelo nome
                        System.out.println("Perfeito! Qual o nome do aluno que quer buscar?");
                        String alunoBuscado = sc.nextLine();
                        for (int i = 0; i < turmas.length; i++) {
                            for (int j = 0; j < alunos[i].length; j++) {
                                if (alunoBuscado.equalsIgnoreCase(alunos[i][j])){
                                    System.out.println("Aluno Encontrado!");
                                    System.out.println("Ele está na turma " + (i+1) + ": " + turmas[i]);
                                }
                            }
                        }
                        break;
                    case 7: //Editar nota
                        if (turmas[0] == null){ //Vendo se possui turma para cadastrar
                            System.out.println("Nenhuma turma cadastrada!\n\n");
                            break;
                        }
                        System.out.println("De qual turma quer listar? ");
                        for (int i = 0; i < turmas.length; i++) {
                            if (turmas[i] == null){
                                break;
                            }
                            System.out.println((i+1) + ". " + turmas[i]);
                        }

                        turmaEscolhida = Integer.parseInt(sc.nextLine())-1;

                        if (alunos[turmaEscolhida][0] == null){
                            System.out.println("NENHUM ALUNO ENCONTRADO\n\n");
                            break;
                        }
                        System.out.println("De qual aluno quer editar a nota?");
                        for (int i = 0; i < alunos[turmaEscolhida].length; i++) {
                            if (alunos[turmaEscolhida][i] != null){
                                System.out.println("Aluno " + (i+1));
                            }
                        }
                        int alunoEditar = Integer.parseInt(sc.nextLine())-1;
                        for (int i = 0; i < notas[turmaEscolhida][alunoEditar].length; i++) {
                            System.out.println("Digite a nova nota " + (i+1));
                            notas[turmaEscolhida][alunoEditar][i] = Double.parseDouble(sc.nextLine());
                        }
                        break;
                    case 8: //Sair
                        System.out.println("Encerrando programa...");
                        break;
                    default:
                        System.out.println("Escolha uma opção válida!\n\n");
                }
            }

            sc.close();
        }
    }
