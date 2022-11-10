package code_fourni.exo_1et2;

import code_fourni.exo_1et2.pile.Pile;

public class Exercices1et2
{
    public static void main(String[] args)
    {
        Pile pile = new Pile();

        
        if (pile.estvide())
            System.out.println("vide");
        pile.empiler(12);
        pile.empiler(3);
        pile.empiler(15);
        //pile.affiche();
        System.out.println("en rec");
        pile.raperrecaffiche();
        pile.depiler();
        System.out.println("sommet : " + pile.sommet());
        pile.affiche();
        pile = pile.inverser();
        pile.affiche();
        pile.vidange();

        // test de inserer;
        pile.empiler(50);
        pile.empiler(30);
        pile.empiler(20);
        System.out.println("Insertion");
        pile.inserer(40, 2);
        pile.inserer(60, 4);
        pile.inserer(10, 0);
        pile.affiche();     // normalement (10,20,30,40,50,60)    avec le sommet à gauche et le fond à droite
        
    }
}
