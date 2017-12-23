package evt;

import java.io.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * Klasse zur Realisierung eines Irrgarten-Lösers
 *
 * @version 1.0 vom 22.09.2008
 * @author Daniel Garmann
 */

public class Irrgarten {
    // Anfang Attribute
    private char[][] feld;       // Irrgartenfeld
    private int startX;          // Startpunkt-x
    private int startY;          // Startpunkt y
    private int zielX;           // Zielpunkt
    private int zielY;
    private int breite, hoehe;   // Breite und Höhe des Irrgartens
    private Graphics g = null;   // Ausgabe-Graphics-Komponente (Gui)
    // Ende Attribute

    /**
     *  parameterloser Konstruktor
     */
    public Irrgarten() { }

    /**
     *  Konstruktor mit Ausgabe-Container
     *  @param cp Container für Ausgabe
     */
    public Irrgarten(Graphics g) {
        this.g = g;              // Graphics-Komponente setzen
    }

    // Anfang Methoden

    /**
     *  Getter für die x-Koordinate der Startposition
     *  @return x-Koordinate Startposition
     */
    public int getStartX() {
        return startX;
    }

    /**
     *  Getter für die y-Koordinate der Startposition
     *  @return y-Koordinate Startposition
     */
    public int getStartY() {
        return startY;
    }

    /**
     *  Getter für die x-Koordinate der Zielposition
     *  @return x-Koordinate Zielposition
     */
    public int getZielX() {
        return zielX;
    }

    /**
     *  Getter für die y-Koordinate der Zielposition
     *  @return y-Koordinate Zielposition
     */
    public int getZielY() {
        return zielY;
    }


    /**
     * Methode zum laden der Datensätze aus einer Textdatei
     * @param dateiname Dateiname, aus der geladen werden soll
     */
    public void ausDateiLaden(String dateiname) {
        File datei = new File(dateiname);
        String dateiString = "";
        try {
            FileReader reader = new FileReader(datei);
            BufferedReader puffer = new BufferedReader(reader);
            String s = puffer.readLine();
            while (s != null) {
                dateiString = dateiString + s + ",";               // erst mal alles Komma-getrennt in einen String
                s = puffer.readLine();
            }
            reader.close();

            String[] zeilen = dateiString.split(",");          // dann in einzelne Zeilen aufteilen
            hoehe = zeilen.length;                             // Höhe = Anzahl der Zeilen
            breite = zeilen[0].length();                       // Breite = Länge einer Zeile
            feld = new char[breite][hoehe];                    // und dann alle Felder setzen
            for (int x = 0; x < breite; x++) {
                for (int y = 0; y < hoehe; y++) {
                    char c = zeilen[y].charAt(x);
                    feld[x][y] = c;
                    if (c == 'S') {                                // evtl. Startposition merken
                        startX = x;
                        startY = y;
                    } else if (c == 'Z') {                         // evtl. Zielposition merken
                        zielX = x;
                        zielY = y;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht vorhanden");
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

    /**
     * Methode ausgeben des Irrgartens auf einer Graphics-Komponente
     * @param g Graphics-Komponente, auf dem ausgegeben werden soll
     */
    public void ausgeben(Graphics g) {
        g.setClip(0,0,300,300);

        double breitex = g.getClipBounds().getWidth() / breite;
        double breitey = g.getClipBounds().getHeight() / hoehe;

        for (int x = 0; x < breite; x++) {
            for (int y = 0; y < hoehe; y++) {
                switch (feld[x][y]) {
                    case ' ': g.setColor(Color.WHITE); break;
                    case '#': g.setColor(Color.BLACK); break;
                    case 'S': g.setColor(Color.GREEN); break;
                    case 'Z': g.setColor(Color.RED); break;
                    case '*': g.setColor(Color.GREEN); System.out.println("in ausgeben"); break;
                    case '-': g.setColor(Color.ORANGE); break;
                }
                g.fillRect((int)(x*breitex),(int)(y*breitey),(int)breitex+1,(int)breitey+1);
            }
        }
    }

    /**
     * Methode ausgeben des Irrgartens auf den internen Container
     */

    public void ausgeben() {
        if (g != null)
            ausgeben(g);
    }

    /**
     * rekursive Methode zum suchen und markieren eines Weges
     * @param x aktuelle x-Position bei der Suche
     * @param y aktuelle y-Position bei der Suche
     */
    private boolean suche(int x, int y) {

        return false;
    }

    private boolean allesMarkieren() {


        return true;
    }

    /**
     * Methode zum suchen und markieren eines Weges per Breitensuche
     * @param x aktuelle x-Position bei der Suche
     * @param y aktuelle y-Position bei der Suche
     */
    private boolean sucheInDieBreite(int x, int y) {
        Queue<Feld> q = new Queue<>();

        q.enqueue(new Feld(x, y));

        do {
            Feld f = q.front();
            feld[f.getX()][f.getY()] = '*';

            if ((f.getX() + 1 <= feld[0].length) && feld[f.getX() + 1][f.getY()] == ' ') {
                q.enqueue(new Feld(f.getX() + 1, f.getY()));
                feld[f.getX() + 1][f.getY()] = '*';
            }  else if ((f.getY() + 1) <= feld[0].length && feld[f.getX()][f.getY() + 1] == ' ') {
                q.enqueue(new Feld(f.getX(), f.getY() + 1));
                feld[f.getX()][f.getY() + 1] = '*';
            }  else if ((f.getX() - 1) >= 0 && feld[f.getX() - 1][f.getY()] == ' ') {
                q.enqueue(new Feld(f.getX() - 1, f.getY()));
                feld[f.getX() - 1][f.getY()] = '*';
            } else if ((f.getY() - 1) >= 0 && feld[f.getX()][f.getY() - 1] == ' ') {
                q.enqueue(new Feld(f.getX(), f.getY() - 1));
                feld[f.getX()][f.getY() - 1] = '*';
            } else {
                feld[f.getX()][f.getY()] = '-';
                q.dequeue();
            }
        } while (!q.isEmpty() && (q.front() != new Feld(zielX, zielY)));

        if (q.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Methode zum suchen und markieren eines Weges per Breitensuche
     * @param x aktuelle x-Position bei der Suche
     * @param y aktuelle y-Position bei der Suche
     */
    private boolean sucheInDieTiefe(int x, int y) {
        Stack<Feld> s = new Stack<>();

        s.push(new Feld(x, y));

        do {
            Feld f = s.top();
            feld[f.getX()][f.getY()] = '*';

            if ((f.getX() + 1) <= feld.length && feld[f.getX() + 1][f.getY()] == ' ') {
                s.push(new Feld(f.getX() + 1, f.getY()));
                feld[f.getX() + 1][f.getY()] = '*';
            }  else if ((f.getY() + 1) <= feld[0].length && feld[f.getX()][f.getY() + 1] == ' ') {
                s.push(new Feld(f.getX(), f.getY() + 1));
                feld[f.getX()][f.getY() + 1] = '*';
            }  else if ((f.getX() - 1) >= 0 && feld[f.getX() - 1][f.getY()] == ' ') {
                s.push(new Feld(f.getX() - 1, f.getY()));
                feld[f.getX() - 1][f.getY()] = '*';
            } else if ((f.getY() - 1) >= 0 && feld[f.getX()][f.getY() - 1] == ' ') {
                s.push(new Feld(f.getX(), f.getY() - 1));
                feld[f.getX()][f.getY() - 1] = '*';
            } else {
                s.pop();
            }
        } while (!s.isEmpty() && (s.top() != new Feld(zielX, zielY)));

        if (s.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Methode zum lösen des Irrgartens. Der richtige Weg wird durch * markiert.
     */
    public void loesen_Tiefensuche() {
        sucheInDieTiefe(startX, startY);
    }

    /**
     * Methode zum lösen des Irrgartens. Der richtige Weg wird durch * markiert.
     */
    public void loesen_Breitensuche() {
        sucheInDieBreite(startX, startY);
    }

    // Ende Methoden
}
