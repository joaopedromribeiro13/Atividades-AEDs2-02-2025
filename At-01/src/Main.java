class Livro {
    private long isbn;
    private String titulo;
    private String autorPrincipal;
    private String segundoAutor;
    private String categoria;
    private String descricao;
    private int anoPublicacao;
    private int qtdPaginas;
    private double notaAvaliacao;
    private int qtdAvaliacoes;

    public Livro() {
        this.isbn = 0;
        this.titulo = "";
        this.autorPrincipal = "";
        this.segundoAutor = "";
        this.categoria = "";
        this.descricao = "";
        this.anoPublicacao = 0;
        this.qtdPaginas = 0;
        this.notaAvaliacao = 0.0;
        this.qtdAvaliacoes = 0;
    }

    public Livro(String titulo, String autorPrincipal, int anoPublicacao) {
        this();
        this.titulo = titulo;
        this.autorPrincipal = autorPrincipal;
        this.anoPublicacao = anoPublicacao;
    }

    public long getIsbn() { return isbn; }
    public void setIsbn(long isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutorPrincipal() { return autorPrincipal; }
    public void setAutorPrincipal(String autorPrincipal) { this.autorPrincipal = autorPrincipal; }

    public String getSegundoAutor() { return segundoAutor; }
    public void setSegundoAutor(String segundoAutor) { this.segundoAutor = segundoAutor; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public int getQtdPaginas() { return qtdPaginas; }
    public void setQtdPaginas(int qtdPaginas) { this.qtdPaginas = qtdPaginas; }

    public double getNotaAvaliacao() { return notaAvaliacao; }
    public void setNotaAvaliacao(double notaAvaliacao) { this.notaAvaliacao = notaAvaliacao; }

    public int getQtdAvaliacoes() { return qtdAvaliacoes; }
    public void setQtdAvaliacoes(int qtdAvaliacoes) { this.qtdAvaliacoes = qtdAvaliacoes; }

    public Livro clone() {
        Livro copia = new Livro();
        copia.isbn = this.isbn;
        copia.titulo = this.titulo;
        copia.autorPrincipal = this.autorPrincipal;
        copia.segundoAutor = this.segundoAutor;
        copia.categoria = this.categoria;
        copia.descricao = this.descricao;
        copia.anoPublicacao = this.anoPublicacao;
        copia.qtdPaginas = this.qtdPaginas;
        copia.notaAvaliacao = this.notaAvaliacao;
        copia.qtdAvaliacoes = this.qtdAvaliacoes;
        return copia;
    }

    public void ler(String linha) {
        String[] partes = linha.split("\\|");
        this.isbn = Long.parseLong(partes[0]);
        this.titulo = partes[1];
        this.autorPrincipal = partes[2];
        this.segundoAutor = partes[3];
        this.categoria = partes[4];
        this.descricao = partes[5];
        this.anoPublicacao = Integer.parseInt(partes[6]);
        this.qtdPaginas = Integer.parseInt(partes[7]);
        this.notaAvaliacao = Double.parseDouble(partes[8]);
        this.qtdAvaliacoes = Integer.parseInt(partes[9]);
    }

    public void imprimir() {
        MyIO.println(this.toString());
    }

    public String toString() {
        return autorPrincipal + 
               (segundoAutor.isEmpty() ? "" : ", " + segundoAutor) +
               ". " + titulo + ". " + anoPublicacao + ". ISBN: " + isbn + ".";
    }
}

public class Main {
    public static void main(String[] args) {
        MyIO.setCharset("ISO-8859-1");

        int n = MyIO.readInt();
        Livro[] livros = new Livro[n];

        for (int i = 0; i < n; i++) {
            String linha = MyIO.readLine();
            livros[i] = new Livro();
            livros[i].ler(linha);
        }

        String stop = MyIO.readLine();
        if (stop == null) stop = "";
        
        String entrada = MyIO.readLine();
        
        while (!entrada.equals("FIM")) {
            String[] dados = entrada.split(";");
            String titulo = dados[0];
            int ano = Integer.parseInt(dados[1].trim());
            String autor = dados[2];

            for (int i = 0; i < n; i++) {
                Livro l = livros[i];
                if (l.getTitulo().equals(titulo) &&
                    l.getAnoPublicacao() == ano &&
                    l.getAutorPrincipal().equals(autor)) {
                        l.imprimir();
                }
            }
        entrada = MyIO.readLine();
        }
    }
}