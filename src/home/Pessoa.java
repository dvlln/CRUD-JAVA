package home;
/**
 *
 * @author Allan
 */
public class Pessoa {    
    private String nome;
    private String endereco;
    private String cidade;
    private String telefone;
    private String dataNascimento;
    private double peso;
    private double altura;
    private String cpf;
    private String rg;

    public Pessoa(){};
    
    public Pessoa(String nome, String endereco, String cidade, String telefone, double peso, String cpf, String rg) {
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
        this.peso = peso;
        this.cpf = cpf;
        this.rg = rg;
    }
    
    public int idade(String dtnasc){
        int idade=0;
        Data d = new Data();
        
        int diaNasc = Integer.parseInt(dtnasc.split("/")[0]);
        int mesNasc = Integer.parseInt(dtnasc.split("/")[1]);
        int anoNasc = Integer.parseInt(dtnasc.split("/")[2]);
        
        if(d.getMes()<=mesNasc){
                if(d.getDia()<diaNasc){
                    idade = d.getAno()-anoNasc-1;
                }
        }else{
            idade = d.getAno()-anoNasc;
        }
        return idade;
    }
    
    // <editor-fold defaultstate="collapsed" desc="GETTERS && SETTERS">
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getRG() {
        return rg;
    }

    public void setRG(String rg) {
        this.rg = rg;
    }
    // </editor-fold> 
}
