package code_fourni.exo_5_et_plus;

/**
 * @author subrenat
 */
public class Pile
{
    private class Cellule
    {
        int elt;
        Cellule next;
    }
    private Cellule first;


    // constructeur (méthode de base)
    public Pile()
    {
        this.first = null;
    }

    // test pile vide (méthode de base)
    public boolean isVide()
    {
        return (this.first == null);
    }

    // ajouter un élément au sommet (méthode de base)
    public void empiler(int elt)
    {
        Cellule cell = new Cellule();
        cell.elt = elt;
        cell.next = this.first;
        this.first = cell;
    }

    // supprimer le sommet de pile (méthode de base)
    // la pile ne doit pas être vide
    // le ramasse-miettes récupèrera la cellule retirée (c'est beaucoup plus compliqué en C)
    public void depiler()
    {
        this.first = this.first.next;
    }

    // récupérer le sommet de la pile (méthode de base)
    // l'élément N'est PAS dépilé
    // la pile ne doit pas être vide
    public int sommet()
    {
        return this.first.elt;
    }

    // retire tous les éléments (méthode de haut niveau)
    // on peut l'écrire en utilisant uniquement les méthodes de base
    // - plus facile à écrire, moins de risque de bug
    // - indépendant de la structure de données
    // - éventuellement moins efficace (ce qui est le cas ici)
    public void vider()
    {
        while (! this.isVide())
            this.depiler();
    }

    // on joue avec le ramasse-miettes
    public void vider_efficace()
    {
        this.first = null;
    }

    // affiche (méthode de haut niveau, mais compliquée et peu efficace si on n'utilise que les méthodes de base)
    // le sommet est en haut de l'affichage
    public void afficher()
    {
        System.out.println("Affichage pile");
        Cellule current = this.first;
        while(current != null)
        {
            System.out.printf("| %2d |\n", current.elt);
            current = current.next;
        }
        System.out.println("+----+");
    }

    // récursif
    private void afficher_rec(Cellule cell)
    {
        if (cell == null)
            System.out.println("+----+");
        else
        {
            System.out.printf("| %2d |\n", cell.elt);
            afficher_rec(cell.next);
        }
    }
    public void afficher_rec()
    {
        System.out.println("Affichage pile");
        afficher_rec(this.first);
    }

    // retourne la pile (méthode de haut niveau)
    public void inverser()
    {
        // to do si vous avez envie
        // soit on l'écrit uniquement avec les méthodes de base : assez facile et peu efficace
        // on on retourne tout le chaînage : efficace et délicat
    }
    
    // Méthode incorrecte pour une pile dont on ne manipule que le sommet
    // théoriquement ; juste pour faire des manipulations de pointeurs
    // Si la pile a N éléments, les positions correctes vont de 0 à N inclus
    // On suppose la position correcte (i.e. la pile suffisamment remplie)
    public void inserer(int elt, int pos)
    {
        if (pos == 0)
            this.empiler(elt);
        else
        {
            Cellule cell = new Cellule();
            cell.elt = elt;
            Cellule prec = this.first;
            for (int i = 1; i < pos; i++)
                prec = prec.next;
            cell.next = prec.next;
            prec.next = cell;
        }
    }

    // Exercice 5
    public static void pairImpair()
    {
        Pile A = new Pile();
        Pile B = new Pile();
        Pile C = new Pile();

        A.empiler(8);
        A.empiler(1);
        A.empiler(3);
        A.empiler(6);
        A.empiler(4);
        A.empiler(2);
        A.empiler(7);

        A.afficher();

        //TODO code pour séparer les nombres pairs et impairs

        A.afficher();     // normalement (7,3,1)    avec le sommet à gauche et le fond à droite
        B.afficher();     // normalement (2,4,6,8)  même remarrque
        C.afficher();     // normalement vide
    }

    // exercice 6 : calcule la valeur d'une expression postfixe (supposée bien formée)
    public static int postfixe(String s)
    {
        //TODO
        //  - il faut utiliser une pile d'entiers
        //  - char c = s.charAt(2);  // récupère le 3me caractère de la chaine
        //  - if ((c >= '0') && (c <= '9'))   // permet de savoir si c'est un chiffre
        //  - int n = c - '0';   // transforme le caractère en entier

        return 0;
    }

    // exercice 7 si vous êtes motivé
    // la solution la plus simple est récursive
    public static int prefixe(String s)
    {
        return 0;
    }

    public static void main(String[] args)
    {
        pairImpair();

        System.out.println(postfixe("89+74-*") + "  ( 51 normalement)");
        System.out.println(postfixe("8974+-*") + " (-16 normalement)");

        System.out.println(prefixe("*+89-74") + "  ( 51 normalement)");
        System.out.println(prefixe("*8-9+74") + " (-16 normalement)");
   }
}
