import java.util.ArrayList;
import java.util.Random;

public class Atendimento {
    private Cabine cabine;
    private ArrayList<Veiculo> relatorioVeiculo;
    private ArrayList<Integer> tempoAtendimento;
    private ArrayList<Double> valorPagoVeiculo;
    private double valorTotal;

    public Atendimento(Cabine cabine){
        relatorioVeiculo = new ArrayList<>();
        tempoAtendimento = new ArrayList<>();
        valorPagoVeiculo = new ArrayList<>();
        this.cabine = cabine;
        this.valorTotal = 0f;
    }

    public void removeCarro(){
        Veiculo aux = cabine.saiDaCabine();
        valorPago();
        relatorioVeiculo(aux);
        tempoDeAtendimento();
    }

    public void tempoDeAtendimento(){
        Random random = new Random();
        int tempo  = random.nextInt(60);
        tempoAtendimento.add(tempo);
    }

    public void valorPago(){
        if(cabine.getInicio().getTipo() == TipoVeiculo.CARRO){
            valorPagoVeiculo.add(3.00);
            valorTotal += 3.00;
        }else if(cabine.getInicio().getTipo() == TipoVeiculo.CAMINHAO){
            valorPagoVeiculo.add(10.00);
            valorTotal += 10.00;
        }else{
            valorPagoVeiculo.add(1.00);
            valorTotal += 1.00;
        }
    }

    public void relatorioVeiculo(Veiculo v){
        this.relatorioVeiculo.add(v);
    }

    public String toString() {
        String aux = "veiculos {";
        for(int i = 0; i < relatorioVeiculo.size(); i ++){
            aux = aux + "[ " + relatorioVeiculo.get(i) + "," +  tempoAtendimento.get(i) + "," +  valorPagoVeiculo.get(i) + " ]";
        }
        aux += "}";
        return aux + " Valor Total: " + valorTotal +"; \n";
    }


}
