/**
 * @author subrenat
 */
public class File
{    
    // ici :
    // - la classe interne (et privée) pour stocker une cellule
    // - la référence sur la première cellule

    private class Cell
    {
        public int val;
        public Cell next;
    }

    Cell first ;
    Cell last;

    // constructeur (méthode de base)
    public File()
    {
        first = null;
        last = null;
    }
    // test pile vide (méthode de base)

    public boolean estvide()
    {
        return (first == null);
    }

    // ampiler : ajouter un élément au sommet (méthode de base)

    public void empiler(int v)
    {
        Cell c = new Cell();
        c.val =v;
        c.next = first;
        first = c;
    }

    // dépiler : supprimer le sommet de pile (méthode de base)
    // la pile ne doit pas être vide

    public void depiler()
    {
        if(!estvide())
        {
            first = first.next;
        }
    }

    // récupérer le sommet de la pile (méthode de base)
    // l'élément N'est PAS dépilé
    // la pile ne doit pas être vide

    public int sommet()
    {
        if(!estvide())
        {
            return first.val;
        }

        return 0;
    }

    // vider : retire tous les éléments (méthode de haut niveau)

    public void vidange()
    {
       first = null;
    }
    // affiche (méthode de haut niveau, mais compliquée et peu efficace si on n'utilise que les méthodes de base)
    // Aussi parcourt-on les cellules de la liste en les affichant au fur et à mesure
    // L'affichage doit être vertical avec le sommet est en haut de l'affichage

    public void affiche()
    {
        Cell current = first;
        do
        {
            System.out.println(current.val);
            current = current.next;
        }while(!(current == null));

    }

    public void raperrecaffiche()
    {
        recaffiche(first);
    }
    // même méthode mais en récursif
    private void recaffiche(Cell ce)
    {
        if(ce.next == null)
        {
            System.out.println(ce.val);
        }
        else
        {
            System.out.println(ce.val);
            recaffiche(ce.next);
        }
    }

    // retourne la pile (méthode de haut niveau)
    public Pile videinto()
    {
        File P = new File();
        Cell current = first;
        while(current != null)
        {
            P.empiler(current.val);
            current = current.next;
        }
        vidange();
        return P;
    }

    public File inverser()
    {
        File P1 = new File();
        P1 = videinto();
        File P2 = new File();
        P2 = P1.videinto();
        return P2.videinto();

        // Inverse les valeur d'une File
    }

    public void inserer(int value,int index)
    {
        File P1 = new File();
        
        for(int i = 0; i < index; i ++)
        {
            if(first != null)
            {
                P1.empiler(first.val);
                depiler();
            }
        }
        empiler(value);
        while(!P1.estvide())
        {
            //empiler(P1.first);
            P1.depiler();
        }
    }
    
    // inserer à une position donnée : méthode incorrecte pour une pile dont on ne manipule
    // que le sommet théoriquement ; juste pour faire des manipulations de pointeurs
    // Si la pile a N éléments, les positions correctes vont de 0 à N inclus
    // On suppose la position correcte (i.e. la pile suffisamment remplie)
    //TODO
}
