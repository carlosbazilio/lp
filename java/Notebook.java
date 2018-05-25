import java.util.ArrayList;

public class Notebook extends Eletronico {
	boolean leitor_dvd;
	ArrayList<Hd> hds;

	public Notebook(boolean d, ArrayList<Hd> h, String f, String m, int c) {
		super(f, m, c);
		this.leitor_dvd = d; this.hds = h;
	}
}

