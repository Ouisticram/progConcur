package prog.concur.projet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import prog.concur.projet.server.TelnetServerBasNiveau;
import prog.concur.projet.client.TelnetClient;

/**
 * Hello world!
 *
 */
public class App 
{
	
	/**
    * Charge la liste des propriétés contenu dans le fichier spécifié
    *
    * @param filename le fichier contenant les propriétés
    * @return un objet Properties contenant les propriétés du fichier
    */
   public static Properties load(String filename) throws IOException, FileNotFoundException{
      Properties properties = new Properties();

      FileInputStream input = new FileInputStream(filename);
      try{
         properties.load(input);
         return properties;
      }
      finally{
         input.close();
      }
   }
    public static void main( String[] args )
    {
    	 try{
             // chargement des propriétés
             Properties prop = App.load("config.properties");

             // Affichage des propriétés
             // Récupère la propriété ma.cle
             // Si la propriété n'existe pas, retourne la valeur par défaut "vide"
             String implementation = prop.getProperty("implementation", "vide");
             String nbConnexion = prop.getProperty("nbConnexion", "vide");
             int nbConn = Integer.valueOf(nbConnexion);
             String inactivite = prop.getProperty("inactivite", "vide");
             int inact = Integer.valueOf(inactivite);
             String port = prop.getProperty("port", "vide");
             int p = Integer.valueOf(port);
             System.out.println("implementation: "+implementation+" nbConnexion: "+nbConn+" inactivite: "+inact+" port: "+p);
             new Thread(new TelnetServerBasNiveau(nbConn, inact, p)).start();
             new TelnetClient(p);
    	 }
          catch(Exception e){
             e.printStackTrace();
          }
    }
}
