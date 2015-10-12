import java.util.Arrays;

public class LeCadeau {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//int[] tab = {40,40,40};
		int[] tab = new int[20000];
		
		for(int i=0;i<tab.length;i++){
			tab[i]=(int)(Math.random()*10000000);
		}
		
		int nbPersonne = tab.length;
		int prix = (int)(Math.random()*1000000000);

		Arrays.sort(tab);
		for(int i=0;i<tab.length;i++){
			System.out.print(tab[i]+",");
		}
		System.out.println();

		int[] res = new int[nbPersonne];
		int somme = 0;
		for (int i = 0; i < nbPersonne; i++) {
			res[i] = 0;
			somme += tab[i];
			if (somme >= prix) {
				break;
			}
		}

		// cas impossible
		if (somme < prix) {
			System.out.println("IMPOSSIBLE");
			return;
		}

		int level = 0;
		somme = 0;
		boolean flag = false;
		int reste=0;
		for (int i = 0; i < tab.length && somme < prix; i++) {
			if (!flag) {
				int x = (tab[i] - level) * (tab.length - i);
				if (somme + x <= prix) {
					somme += x;
					res[i] = tab[i];
					level = tab[i];
				} else {
					int quotient = (prix - somme) / (tab.length - i);
					reste = (prix - somme) % (tab.length - i);

					level += quotient;
					flag = true;

				}
			}
			if (flag) {
				res[i] = level + (i>=tab.length-reste ? 1 : 0 );
			}

		}
		somme=0;
		for(int i=0;i<res.length;i++){
			somme+=res[i];
			System.out.print(res[i]+",");
		}
		System.out.println("\nsomme : "+somme);

	}
	

}
