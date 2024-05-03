import java.util.*;

class Pessoa {
    private String nome;
    private String telefone;
    private String profissao;
    private Endereco endereco;

    public Pessoa(String nome, String telefone, String profissao, Endereco endereco) {
        this(nome, telefone);
        this.profissao = profissao;
        this.endereco = endereco;
    }

    public Pessoa(String nome, String telefone) {
        System.out.println("Invoked Person constructor");
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getProfissao() {
    	return profissao;
    }

    public Optional<Endereco> getEndereco() {
        return Optional.ofNullable(endereco);
    }
}

class Endereco {
    private Pais pais;

    public Endereco(Pais pais) {
        this.pais = pais;
    }

    public Optional<Pais> getPais() {
        return Optional.ofNullable(pais);
    }
}

class Pais {
    private String codigo;

    public Pais(String codigo) {
        this.codigo = codigo;
    }

    public Optional<String> getCodigo() {
        return Optional.ofNullable(codigo);
    }
}

public class Opcional {	
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Fulano", "123456789");
		Pessoa p2 = new Pessoa("Ciclano", "123456789", "Professor", new Endereco(new Pais("BR")));
		// java.lang.NullPointerException
		// System.out.println(p.getProfissao().length());
        if (p1.getEndereco().isPresent()) {
            Endereco e = p1.getEndereco().get();
            if (e.getPais().isPresent()) {
                Pais p = e.getPais().get();
                if (p.getCodigo().isPresent()) {
                    System.out.println(p.getCodigo().get());
                } else {
                    System.out.println("Apátrida");
                }
            } else {
                System.out.println("Apátrida");
            }
        } else {
            System.out.println("Apátrida");
        }
		System.out.println(p1.getEndereco()
                             .flatMap(Endereco::getPais)
                             .flatMap(Pais::getCodigo)
                             .orElse("Apátrida"));
        System.out.println(p2.getEndereco()
                             .flatMap(Endereco::getPais)
                             .flatMap(Pais::getCodigo)
                             .orElse("Apátrida"));
	}	
}

