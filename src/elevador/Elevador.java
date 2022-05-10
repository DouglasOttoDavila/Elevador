/* (1,5) Crie uma classe denominada Elevador para armazenar as informações de um elevador dentro de um prédio. A classe deve armazenar o andar atual (térreo = 0), total de andares no prédio, excluindo, capacidade do elevador, e quantas pessoas estão presentes nele.

A classe deve também disponibilizar os seguintes métodos:

Inicializa: que deve receber como parâmetros a capacidade do elevador e o total de andares no prédio (os elevadores sempre começam no térreo e vazios);
Entra: para acrescentar uma pessoa no elevador (só deve acrescentar se ainda houver espaço)
Sai: para remover uma pessoa no elevador (só deve remover se houver alguém dentro dele)
Sobe: para subir um andar (não deve subir se já estiver no último andar);
Desce: para descer um andar (não deve descer se já estiver no térreo);
Encapsular todos os atributos da classe (crie os métodos set e get). */

package elevador;

public class Elevador {
    
    Commons com = new Commons();
    ConsoleHelper consoleHelper = new ConsoleHelper();

    // VARIÁVEIS
    private int andares;
    private int andar[];
    private int capacidade;
    private int pessoas[];
    private int andarAtual;
    private int contPessoas;

    // CONSTRUTORES
    public int getAndares() {
        return andares;
    }

    public void setAndares(int andares) {
        this.andares = andares;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    // MÉTODOS
    public void inicializa(){
        com.limparTela();
        /* for (int i = 0; i < 20; i++) {
            consoleHelper.animate(i + "");
            //simulate a piece of task
            Thread.sleep(400);
        } */
        this.andar = new int[this.andares];
        this.pessoas = new int[this.capacidade];
        this.andarAtual = 0;
        this.contPessoas = 0;
        System.out.println("| Inicialização...");
        System.out.println("| Andares: "+andar.length);
        System.out.println("| Andar atual: " + this.andarAtual);
        System.out.println("| Capacidade: "+pessoas.length);
        System.out.println("| Lotação atual: " + this.contPessoas);
    }

    public String ext(int andarAtual){
        return NumeroPorExtenso.get(andarAtual);
    }

    public void entra(){
        if (this.contPessoas >= pessoas.length){
            com.limparTela();
            System.out.println("AVISO: O elevador está lotado!\nA lotação máxima de " + pessoas.length + "("+this.ext(pessoas.length)+") pessoas foi atingida.");
            com.aguardaInput();
        } else {
            this.pessoas[this.contPessoas] = 1;
            this.contPessoas++;
            com.limparTela();
            System.out.println("O passageiro ingressou no elevador com sucesso!\nA lotação atual é de " + this.contPessoas + "("+this.ext(this.contPessoas) + ") pessoas.");
            com.aguardaInput();
        }
    }

    public void sai(){
        if (this.contPessoas == 0){
            com.limparTela();
            System.out.println("AVISO: Não há passageiros no elevador.");
            com.aguardaInput();
        } else {
            for (int i = 0; i < this.contPessoas - 1; i++) {
                this.pessoas[i] = this.pessoas[i + 1];
            }
            this.contPessoas--;
            System.out.println("O passageiro saiu do elevador.\nA lotação atual é de " + this.contPessoas + " ("+this.ext(this.contPessoas) + ") pessoas.");
            com.aguardaInput();
        }

    }

    public void sobe(){
        if (this.andarAtual >= andar.length){
            com.limparTela();
            System.out.println("AVISO: O elevador já está no último andar!");
            com.aguardaInput();
        } else {
            this.andar[this.andarAtual] = 1;
            this.andarAtual++;
            com.limparTela();
            System.out.println("O elevador subiu com sucesso!\nO andar atual é: " + this.andarAtual + " ("+this.ext(this.andarAtual) + ").");
            com.aguardaInput();
        }
    }

    public void desce(){
        if (this.andarAtual <= 0){
            com.limparTela();
            System.out.println("AVISO: O elevador já está no térreo.");
            com.aguardaInput();
        } else {
            for (int i = 0; i < this.andarAtual - 1; i++) {
                this.andar[i] = this.andar[i + 1];
            }
            this.andarAtual--;
            com.limparTela();
            System.out.println("O elevador desceu com sucesso.\nO andar atual é: " + this.andarAtual + " ("+this.ext(this.andarAtual) + ").");
            com.aguardaInput();
        }
    }
    
}
