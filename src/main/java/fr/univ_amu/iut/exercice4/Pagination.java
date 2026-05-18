package fr.univ_amu.iut.exercice4;

import java.util.ArrayList;
import java.util.List;

/// Kata 4 - Pagination.
///
/// Kata algorithmique avec beaucoup de cas limites. Idéal pour pratiquer la
/// **discipline TDD** : on active les tests dans l'ordre (du plus simple au plus
/// complexe) et on résiste à la tentation d'anticiper.
public class Pagination {

  private final int courant;
  private final int total;

  public Pagination(int courant, int total) {
    this.courant = courant;
    this.total = total;
  }

  private List<Integer> pagesAAfficher() {
    List<Integer> retour = new ArrayList<>();
    if (total <= 7) retour.addAll(List.of(1, 2, 3, 4, 5, 6, 7)); // on affiche toutes les pages
    else if (courant == 1) retour.addAll(List.of(1, courant + 1, total));
    else if (courant == total) retour.addAll(List.of(1, courant - 1, total));
    else retour.addAll(List.of(1, courant - 1, courant, courant + 1, total));
    return retour;
  }

  private String formatPage(int page) {
    if (page == courant) return ("(" + page + ")");
    else return ("" + page);
  }

  private String separateurEntre(int x, int x1) {
    if (x - x1 == 1) return " ";
    else return " ... ";
  }

  /// Retourne la représentation textuelle de la barre de pagination.
  ///
  /// Format : pages séparées par des espaces, page courante entre parenthèses,
  /// `...` pour combler les trous quand il y a plus de 7 pages au total.
  public String afficher() {
    StringBuilder sortie = new StringBuilder();
    // TODO kata 4 : construire la chaîne de pagination selon les règles
    // du README. Activez les tests dans l'ordre, ils vous guident :
    // - d'abord le cas "total <= 7" (affichage complet)
    // - puis le cas "beaucoup de pages" avec gestion des ellipses
    List<Integer> pages = pagesAAfficher();
    int tmp = 0;
    for (int i = 1; i <= total; i++) {
      if (pages.contains(i)) {
        if (i == 1) {
          tmp = i;
          sortie.append(formatPage(i));
        } else {
          sortie.append(separateurEntre(tmp, i) + formatPage(i));
          tmp = i;
        }
      }
      ;
    }
    return sortie.toString();
  }
}
