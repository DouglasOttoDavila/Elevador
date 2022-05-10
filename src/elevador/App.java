/* (1,5) Crie uma classe denominada Elevador para armazenar as informações de um elevador dentro de um prédio. A classe deve armazenar o andar atual (térreo = 0), total de andares no prédio, excluindo, capacidade do elevador, e quantas pessoas estão presentes nele.

A classe deve também disponibilizar os seguintes métodos:

Inicializa: que deve receber como parâmetros a capacidade do elevador e o total de andares no prédio (os elevadores sempre começam no térreo e vazios);
Entra: para acrescentar uma pessoa no elevador (só deve acrescentar se ainda houver espaço)
Sai: para remover uma pessoa no elevador (só deve remover se houver alguém dentro dele)
Sobe: para subir um andar (não deve subir se já estiver no último andar);
Desce: para descer um andar (não deve descer se já estiver no térreo);
Encapsular todos os atributos da classe (crie os métodos set e get). */

package elevador;

import java.util.Scanner;

public class App {

    

    public static void main(String[] args) throws Exception {

        Elevador elev = new Elevador();
        Commons com = new Commons();

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe a quantidade de andares: ");
        int andares = scan.nextInt();
        elev.setAndares(andares);
        System.out.println("Informe a capacidade do elevador (max. pessoas): ");
        int capacidade = scan.nextInt();
        elev.setCapacidade(capacidade);
        elev.inicializa();
        
        int opcao = 0;

        while (opcao >= 0) {
            com.limparTela();
            System.out.println("| Sistema de Gerenciamento do Elevador v1.0 |");
            System.out.println("Selecione a opção desejada:");
            System.out.println("\n1 - Entrar\n2 - Sair\n3 - Subir\n4 - Descer\n5 - Sair");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    elev.entra();
                    break;

                case 2:
                    elev.sai();
                    break;

                case 3:
                    elev.sobe();
                    break;

                case 4:
                    elev.desce();
                    break;

                case 5:
                    opcao = -1;
                    break;
            
            }
            
        }
        scan.close();
    }
}   
