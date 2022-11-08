package code_fourni.exo_4;

/**
 * @author subrenat
 */
public class PileChar
{
    private class Cellule
    {
        char elt;
        Cellule next;
    }
    private Cellule first;


    // constructeur (méthode de base)
    public PileChar()
    {
        this.first = null;
    }

    // test pile vide (méthode de base)
    public boolean isVide()
    {
        return (this.first == null);
    }

    // ajouter un élément au somme (méthode de base)
    public void empiler(char elt)
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
    public char sommet()
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

    // affiche (méthode de haut niveau)
    // le sommet est en haut de l'affichage
    public void afficher()
    {
        System.out.println("Affichage pile");
        Cellule current = this.first;
        while(current != null)
        {
            System.out.printf("| %c |\n", current.elt);
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
            System.out.printf("| %c |\n", cell.elt);
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
        // to do
        // soit on l'écrit uniquement avec les méthodes de base : assez facile et peu efficace
        // on on retourne tout le chaînage : efficace et délicat
    }
    
    // Méthode incorrecte pour une pile dont on ne manipule que le sommet
    // théoriquement ; juste pour faire des manipulations de pointeurs
    // Si la pile a N éléments, les positions correctes vont de 0 à N inclus
    // On suppose la position correcte (i.e. la pile suffisamment remplie)
    public void inserer(char elt, int pos)
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

    // indique si une expression est correctement parenthésée
    public static boolean parentheses(String s)
    {
        //TODO
        return false;
    }

    public static void main(String[] args)
    {
        boolean ok;
        ok = parentheses("x(yz[w])[az](n)");
        System.out.println("==" + ok + "  (true  attendu)");
        ok = parentheses("[(])");
        System.out.println("==" + ok + " (false attendu)");
        ok = parentheses("(([])");
        System.out.println("==" + ok + " (false attendu)");
        ok = parentheses("([]))");
        System.out.println("==" + ok + " (false attendu)");
    }
}
