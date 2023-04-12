import java.util.Scanner;

public class MiniBanco {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        String nome = "Igor Vidal";
        String tipoDaConta = "Corrente";
        double saldo = 1000.00 ;

        System.out.printf(""" 
                ************************************************************
                Dados iniciais do Cliente:
                
                Nome:              %s
                Tipo da conta:     %s
                Saldo Inicial:     R$ %.2f
                ************************************************************
                """, nome, tipoDaConta, saldo);
        String menu = """
                
                Operações
                
                1- Consultar saldo
                2- Depositar valor
                3- Transferir valor
                4- Sair
                
                Digite a opção desejada: 
                """;
        int entrada = 0;   // Vai ler o Nº digitado e guardar
        while(entrada !=4 ){
            System.out.println(menu);
             entrada = leitura.nextInt();

        if (entrada == 1){
            System.out.printf("R$ %.2f",saldo);
        } else if (entrada == 2){
            System.out.println("Digite o valor que deseja depositar:");
            double valorDeposito = leitura.nextDouble();
            saldo += valorDeposito;
            System.out.printf("Saldo atualizado em: R$ %.2f",saldo);

        }
            //transferencia pix

            if (entrada == 3) {
            double valorTransferencia = 0;
            System.out.println("Digite o valor para a transferencia:");
            valorTransferencia = leitura.nextDouble();
            while(valorTransferencia > saldo){
                System.out.println("Valor insuficiente para transferencia");
                System.out.println("Digite novamente o valor para a transferencia:");
                valorTransferencia = leitura.nextDouble();
            }

                double novoSaldo = saldo - valorTransferencia;

            // consome a nova linha em branco
            leitura.nextLine();

            System.out.println("Digite o nome para quem irá receber");
            String nomeTransferencia = leitura.nextLine();

            System.out.printf("""
            Você enviou R$ %.2f para %s.
            Saldo restante na conta: R$ %.2f
            """, valorTransferencia, nomeTransferencia, novoSaldo);
            saldo = novoSaldo;

            }

        }
        System.out.println("""
                             *****************************
                                operação finalizada
                                Desconectando do sitema
                             *****************************3
                           """);

    }

}
