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

        System.out.println("Vidange");
        // test de inserer;
        System.out.println("empile 50");
        pile.empiler(50);
        System.out.println("empile 30");
        pile.empiler(30);
        System.out.println("empile 20");
        pile.empiler(20);
        System.out.println("Insertion");
        System.out.println("40");
        pile.inserer(40, 2);
        System.out.println("empile 60");
        pile.inserer(60, 4);
        System.out.println("empile 10");
        pile.inserer(10, 0);
        pile.affiche();     // normalement (10,20,30,40,50,60)    avec le sommet à gauche et le fond à droite
        
    }
}
