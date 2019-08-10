package pl.krystian;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Konfiguracja.setUp();
        for(int i = 0; i<=10000; i++) {
            System.out.println(i);
            Konfiguracja.dodaj("Tomek", "Noobek");
        }
        }
}
