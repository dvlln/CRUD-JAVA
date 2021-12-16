package home;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Allan
 */
public class PessoaTM extends AbstractTableModel{
    private List<Pessoa> linhas;
    private String[] colunas = new String[]{"Nome","Endereco","Cidade","Telefone","Data_Nascimento","Idade","Peso","Altura","CPF","RG"};
    
    public PessoaTM() {
        linhas = new ArrayList<Pessoa>();
    }
    
    public PessoaTM(List<Pessoa> lista) {
        linhas = new ArrayList<Pessoa>(lista);
    }
    
    @Override
    public int getColumnCount() {        
        return colunas.length;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 5:
                return Integer.class;
            case 6, 7:
                return Double.class;
            default:
                return String.class;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa p = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getNome();
            case 1:
                return p.getEndereco();
            case 2:
                return p.getCidade();
            case 3:
                return p.getTelefone();
            case 4:
                return p.getDataNascimento();
            case 5:
                return p.idade(p.getDataNascimento());
            case 6:
                return p.getPeso();
            case 7:
                return p.getAltura();
            case 8:
                return p.getCPF();
            case 9:
                return p.getRG();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    //modifica na linha e coluna especificada
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Pessoa p = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado

        switch (columnIndex) { // Seta o valor do campo respectivo
            case 0:
                p.setNome(aValue.toString());
                break;
            case 1:
                p.setEndereco(aValue.toString());
                break;
            case 2:
                p.setCidade(aValue.toString());
                break;
            case 3:
                p.setTelefone(aValue.toString());
                break;
            case 4:
                p.setDataNascimento(aValue.toString());
                break;
            case 6:
                p.setPeso(Double.parseDouble(aValue.toString()));
                break;
            case 7:
                p.setAltura(Double.parseDouble(aValue.toString()));
                break;
            case 8:
                p.setCPF(aValue.toString());
                break;
            case 9:
                p.setRG(aValue.toString());
                break;
            default:
                throw new IndexOutOfBoundsException("Isto não deveria acontecer...");
        }
        fireTableCellUpdated(rowIndex, columnIndex);
     }
    
    //modifica na linha especificada
    public void setValueAt(Pessoa aValue, int rowIndex) {
        Pessoa p = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado
        
        p.setNome(aValue.toString());
        p.setEndereco(aValue.toString());
        p.setCidade(aValue.toString());
        p.setTelefone(aValue.toString());
        p.setDataNascimento(aValue.toString());
        p.setPeso(Double.parseDouble(aValue.toString()));
        p.setAltura(Double.parseDouble(aValue.toString()));
        p.setCPF(aValue.toString());
        p.setRG(aValue.toString());
        
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 6);
        fireTableCellUpdated(rowIndex, 7);
        fireTableCellUpdated(rowIndex, 8);
        fireTableCellUpdated(rowIndex, 9);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Pessoa getPessoa(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    public void addPessoa(Pessoa f) {
        // Adiciona o registro.
        linhas.add(f);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    /* Remove a linha especificada. */
    public void remove(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Cliente ao final dos registros. */
    public void addLista(List<Pessoa> f) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        linhas.addAll(f);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    /* Remove todos os registros. */
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    /* Verifica se este table model esta vazio. */
    public boolean isEmpty() {
        return linhas.isEmpty();
    }
}
