import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void veiculoCabine(Cabine cabine){
            Random random = new Random();
            int chance  = random.nextInt(99);
            if(chance >=50){
            Veiculo v = Veiculo.gerarNovoVeiculo();
            cabine.entraNaCabine(v);
            }       
    }
    public static void main(String[] args){
        // int aux = 0;
        Scanner sc = new Scanner(System.in);

        ArrayList<Cabine> pedagio = new ArrayList<>();

        ArrayList<Atendimento> atendimentos = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Cabine c = new Cabine();
            Atendimento a = new Atendimento(c);
            pedagio.add(c);
            atendimentos.add(a);
        }

        // System.out.println(atendimentos);
        // System.out.println(pedagio);
        
        while(true){
            for(int i = 0; i < 5; i ++){
                Cabine aux = pedagio.get(i);
                if(aux.getTamanho() == 0){
                    veiculoCabine(aux);
                }else{
                    atendimentos.get(i).removeCarro();
                    veiculoCabine(aux);
                }
            }
            System.out.println("Atendimentos: "+atendimentos);

            System.out.println("cabines: " + pedagio);
            System.out.println("Digite 'y' para continuar: ");
            String letra = sc.next();
            if(letra.toLowerCase() != "y"){
                break;
            }
        } 
        sc.close();
        
        /*
        while(true){
            for(Cabine cabine :pedagio){
                Random random = new Random();
                int chance  = random.nextInt(99);
                if(chance >=50){
                Veiculo v = Veiculo.gerarNovoVeiculo();
                cabine.entraNaCabine(v);
                }       
            }

            System.out.println("cabines: " + pedagio);
            System.out.println("Digite 'y' para continuar: ");
            String letra = sc.next();
        }*/
    }
}
