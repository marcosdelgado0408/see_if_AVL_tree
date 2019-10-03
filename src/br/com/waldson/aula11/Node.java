package br.com.waldson.aula11;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Boolean hasLeft(){return this.left != null;}
    public Boolean hasRight(){return this.right != null;}


    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void insert(Node node) {
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.insert(node);
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }


    public int altura(){

        int alturaDireita = 0, alturaEsquerda = 0;

        if(this.left != null){
            alturaEsquerda = this.left.altura();
        }
        if(this.right != null){
            alturaDireita = this.right.altura();
        }

        /* esse max vai retornar o maior numero entre 
           alturaDireita e alturaEsquerda*/
        return 1 + Math.max(alturaDireita,alturaEsquerda); 
         

    }



    //Preciso verirficar o balanceamento em cada nó da Árvore

    /*Uma árvore binária balanceada (AVL) é uma
    árvore binária na qual as alturas das duas
    subárvores de todos os nós nunca difere em mais
    de 1.*/

    /*Se a altura esquerda do nó menos a altura direira do nó,
    for diferente de 1,-1 ou 0, a árvore não está balanceada*/

    public String Balanceamento() {


        int altura_esquerda, altura_direita;

        if(this.left == null && this.right != null){
            altura_esquerda = 0;
            altura_direita = this.right.altura();

            double diferenca = altura_esquerda - altura_direita;
            System.out.println("diferenca : " + diferenca);


            if(diferenca > 0 || diferenca < -1){
                return "Árvore não está balanceada"; // se não retornar aqui, retorna fora
            }

            this.right.Balanceamento();

        }

       else if (this.right == null && this.left != null){
            altura_direita = 0;
            altura_esquerda = this.left.altura();


            double diferenca = altura_esquerda - altura_direita;
            System.out.println("diferenca : " + diferenca);

            if(diferenca > 0 || diferenca < -1){
                return "Árvore não está balanceada"; // se não retornar aqui, retorna fora
            }

            this.left.Balanceamento();

        }

        else if(this.right != null && this.left != null){

            altura_direita = this.right.altura();
            altura_esquerda = this.left.altura();


            double diferenca = altura_esquerda - altura_direita;
            System.out.println("diferenca : " + diferenca);

            if(diferenca > 0 || diferenca < -1){
                return "Árvore não está balanceada"; // se não retornar aqui, retorna fora
            }

            this.left.Balanceamento();
            this.right.Balanceamento();
        }



        return "Árvore balanceada";

    }



}
