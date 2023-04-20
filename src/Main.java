import java.util.Scanner;

public class Main {
    public static final double SALARIO_MINIMO = 1320;
    public static String printaNome(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite seu nome completo: ");
        return scan.nextLine();
    }
    public static String CargoColaborador(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Qual é o seu cargo? ");
        return scan.nextLine();
    }
    public static String DataAdmissao() {
        Scanner scan = new Scanner(System.in);
        int dia = 0, mes = 0, ano = 0;
        int x = 0;
        int y = 0;
        int j = 0;
        while(x==0) {
            System.out.println("Qual o dia da sua admissão? (Digite números entre 1 e 31)");
            dia = scan.nextInt();
            x = 1;
            if (dia <= 0 || dia > 31)
                x = 0;
        }
        while(y==0) {
            System.out.println("Qual o mês da sua admissão? (Digite números entre 1 e 12)");
            mes = scan.nextInt();
            y = 1;
            if(mes<1 || mes>12)
                y = 0;
        }
        while(j==0) {
            System.out.println("Qual o ano da sua admissão? (Digite números entre 2016 e 2023)");
            ano = scan.nextInt();
            j = 1;
            if(ano<2016 || ano>2023)
                j = 0;
        }
        return dia+"/"+mes+"/"+ano;
    }
    public static String MesReferencia(){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String mes = "";
        while(x==0) {
            System.out.println("Qual é o mês de referência da folha de pagamento? (Responda em números de 1 a 12)");
            int nmes = scan.nextInt();
            switch (nmes) {
                case 1 -> {
                    mes = "Janeiro";
                    x = 1;
                }
                case 2 -> {
                    mes = "Fevereiro";
                    x = 1;
                }
                case 3 -> {
                    mes = "Março";
                    x = 1;
                }
                case 4 -> {
                    mes = "Abril";
                    x = 1;
                }
                case 5 -> {
                    mes = "Maio";
                    x = 1;
                }
                case 6 -> {
                    mes = "Junho";
                    x = 1;
                }
                case 7 -> {
                    mes = "Julho";
                    x = 1;
                }
                case 8 -> {
                    mes = "Agosto";
                    x = 1;
                }
                case 9 -> {
                    mes = "Setembro";
                    x = 1;
                }
                case 10 -> {
                    mes = "Outubro";
                    x = 1;
                }
                case 11 -> {
                    mes = "Novembro";
                    x = 1;
                }
                case 12 -> {
                    mes = "Dezembro";
                    x = 1;
                }
                default -> System.out.println("Mês inválido!");
            }
        }
        return mes;
    }
    public static double CalculoSalarioBruto(String nomeColaborador){
        Scanner scan = new Scanner(System.in);
        System.out.print(nomeColaborador+", qual é seu salário bruto? R$");
        return scan.nextDouble();
    }
    public static int DiasTrabalhadosSemana(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Você trabalha quantos dias por semana? ");
        return scan.nextInt();
    }
    public static double CalculoSalarioHora(double salarioBruto, int diasTrabalhadosSemana){
        Scanner scan = new Scanner(System.in);
        System.out.println("Que horas você começa a trabalhar?(ex: 8) ");
        int HoraInicial = scan.nextInt();
        System.out.println("Que horas você sai do trabalho?(ex: 17) ");
        int HoraFinal = scan.nextInt();
        int CargaHorariaDiaria = HoraFinal - HoraInicial;
        System.out.println("Qual é a duração em horas do seu período de descanso diariamente? ");
        int PeriodoDescansoDiario = scan.nextInt();
        int CHSemanal = (CargaHorariaDiaria-PeriodoDescansoDiario)*diasTrabalhadosSemana;
        int CHMensal = CHSemanal*5;
        return salarioBruto/CHMensal;
    }
    public static boolean DireitoPericulosidade(){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        boolean retorno = false;
        while(x == 0){
            System.out.println("O seu cargo lhe dá direito de adicional por periculosidade? (Digite 1 para 'Sim' e 2 para 'Não') ");
            int resp = scan.nextInt();
            if(resp==1){
                retorno = true;
                x=1;
            }
            if(resp==2){
                x=1;
            }
        }
        return retorno;
    }
    public static double CalculoInsalubridade(String nomeColaborador){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int y = 0;
        double retorno = 0;
        while(x == 0) {
            System.out.println(nomeColaborador + ", você tem direito ao adicional de insalubridade? (Digite 1 para 'Sim' e 2 para 'Não') ");
            int resp = scan.nextInt();
            if(resp == 1){
                y = 1;
                x = 1;
            }
            if(resp==2)x=1;
        }
        while(y==1){
            System.out.println("Qual o seu grau de risco? (Digite 1 para 'Baixo', 2 para 'Médio' e 3 para 'Alto')");
            int resp2 = scan.nextInt();
            if(resp2==1){
                retorno = SALARIO_MINIMO*0.1;
                y=0;
            }
            if(resp2==2){
                retorno = SALARIO_MINIMO*0.2;
                y=0;
            }
            if (resp2==3){
                retorno = SALARIO_MINIMO*0.4;
                y=0;
            }
        }
        return retorno;
    }
    public static double CalculoValeTransporte(double salarioBruto){
        Scanner scan = new Scanner(System.in);
        double retorno = 0;
        double limite = salarioBruto*0.06;
        System.out.print("Quanto você recebeu de vale transporte? R$");
        double resp = scan.nextDouble();
        if(resp<=limite)
            retorno = resp;
        else retorno = limite;
        return retorno;
    }
    public static double CalculoValeAlimentacao(int diasTrabalhadosSemana){
        int CHMensal = diasTrabalhadosSemana*5;
        return CHMensal*24;
    }
    public static double CalculoDescontoINSS(double salarioBruto){
        double DescontoTotal = 0;
        double faixa1 = 97.65;
        double faixa2 = 114.24;
        double faixa3 = 154.28;
        double faixa4 = 511.07;
        if(salarioBruto<=1302)
            DescontoTotal = salarioBruto*0.075;
        if(salarioBruto>1302 && salarioBruto<=2571.29)
            DescontoTotal = faixa1 + ((salarioBruto-1302)*0.09);
        if(salarioBruto>2571.29 && salarioBruto<=3856.94)
            DescontoTotal = faixa1+faixa2+((salarioBruto-2571.29)*0.12);
        if(salarioBruto>3856.94 && salarioBruto<=7507.49)
            DescontoTotal = faixa1+faixa2+faixa3+((salarioBruto-3856.94)*0.14);
        if(salarioBruto>7507.49)
            DescontoTotal = faixa1+faixa2+faixa3+faixa4;
        return DescontoTotal;
    }
    public static double CalculoDescontoFGTS(double salarioBruto){
        return salarioBruto * 0.08;
    }
    public static double CalculoDescontoIRRF(double salarioBruto){
        Scanner scan = new Scanner(System.in);
        double DescontoTotal = 0, vdep;
        double SalarioBase = salarioBruto-CalculoDescontoINSS(salarioBruto);
        System.out.print("Quantos dependentes você possui? ");
        double dep = scan.nextDouble();
        if(dep>0) {
            vdep = dep * 189.59;
            SalarioBase -= vdep;
        }
        if(SalarioBase > 1903.98 && SalarioBase <= 2826.65)
            DescontoTotal = (SalarioBase*0.075)-142.8;
        if(SalarioBase > 2826.65 && SalarioBase <= 3751.05)
            DescontoTotal = (SalarioBase*0.15)-354.8;
        if(SalarioBase > 3751.05 && SalarioBase <= 4664.68)
            DescontoTotal = (SalarioBase*0.225)-636.13;
        if(SalarioBase > 4664.68)
            DescontoTotal = (SalarioBase*0.275)-869.36;
        return DescontoTotal;
    }
    public static double CalculoSalarioLiquido(double salarioBruto, boolean direitoPericulosidade,double calculoInsalubridade, double valeTransporte, double calculoIRRF){
        double SalarioLiquido = salarioBruto;
        double addPericulosidade = salarioBruto * 0.3;
        if(direitoPericulosidade)
            SalarioLiquido += addPericulosidade;
        SalarioLiquido += calculoInsalubridade;
        SalarioLiquido -= valeTransporte;
        SalarioLiquido -= CalculoDescontoINSS(salarioBruto);
        SalarioLiquido -= CalculoDescontoFGTS(salarioBruto);
        SalarioLiquido -= calculoIRRF;

        return SalarioLiquido;
    }
    public static void Relatorio(String nomeColaborador, String cargoColaborador, String dataAdmissao, String mesReferencia, double salarioBruto, double salarioHora,boolean direitoPericulosidade, double calculoInsalubridade, double valeTransporte, double valeAlimentacao, double calculoIRRF){
        double Periculosidade = salarioBruto * 0.3;
        /*
         Informações Obrigatórias da Folha de Pagamento
         - Nome do colaborador;
         - Data de admissão;
         - Mês de referência;
         - Cargo do colaborador;
         - Salário do colaborador;
         - Descrição de todos os proventos, por exemplo: salário, adicionais, comissões, DSR e outros se houver;
         - Descrição de todos os descontos, por exemplo: INSS, IRRF, FGTS, vale transporte, vale-refeição, faltas, atrasos e outros se houver;
         - Valor bruto do salário;
         - Valor do salário por hora;
         - Valor líquido do salário;
         - Base de cálculo INSS/FGTS/IRRF.
         */
        System.out.println("\n\n\nRelatório:\n\n\n");
        System.out.println("Nome do colaborador: "+nomeColaborador);
        System.out.println("Data de admissão: "+dataAdmissao);
        System.out.println("Mês de Referência: "+mesReferencia);
        System.out.println("Cargo do colaborador: "+cargoColaborador);
        System.out.printf("O salário do colaborador é R$%.2f\n",salarioBruto);
        //proventos
        System.out.printf("\nPROVENTOS:\n1- Salário Bruto: R$%.2f\n2- Vale Refeição(Benefício Gratuito): R$%.2f\n",salarioBruto,valeAlimentacao);
        if(calculoInsalubridade>0)
            System.out.printf("3- Insalubridade: R$%.2f\n", calculoInsalubridade);
        if(direitoPericulosidade)
            System.out.printf("4- Periculosidade: R$%.2f\n",Periculosidade);
        //descontos
        System.out.printf("\nDESCONTOS:\n1- INSS: R$%.2f\n2- IRRF: R$%.2f\n3- FGTS: R$%.2f\n4- Vale Transporte: R$%.2f\n",CalculoDescontoINSS(salarioBruto),calculoIRRF, CalculoDescontoFGTS(salarioBruto), valeTransporte);
        System.out.printf("\nValor bruto do salário: R$%.2f\n",salarioBruto);
        System.out.printf("Valor do salário por hora: R$%.2f\n", salarioHora);
        System.out.printf("Valor líquido do salário: R$%.2f\n", CalculoSalarioLiquido(salarioBruto,direitoPericulosidade,calculoInsalubridade,valeTransporte, calculoIRRF));
        double CalcIRRF = salarioBruto - calculoIRRF;
        double CalcINSS = CalculoDescontoINSS(salarioBruto);
        double CalcFGTS = CalculoDescontoFGTS(salarioBruto);
        System.out.printf("Base de cálculo INSS: R$%.2f - R$%.2f = R$%.2f\n",salarioBruto,CalcINSS,(salarioBruto-CalcINSS));
        System.out.printf("Base de cálculo FGTS: R$%.2f - R$%.2f = R$%.2f\n",salarioBruto,CalcFGTS,(salarioBruto-CalcFGTS));
        System.out.printf("Base de cálculo IRRF: R$%.2f - R$%.2f = R$%.2f\n",salarioBruto,calculoIRRF,CalcIRRF);
    }
    public static void main(String[] args) {
        String nomeColaborador = printaNome();
        String cargoColaborador = CargoColaborador();
        String dataAdmissao = DataAdmissao();
        String mesReferencia = MesReferencia();
        double salarioBruto = CalculoSalarioBruto(nomeColaborador);
        int diasTrabalhadosSemana = DiasTrabalhadosSemana();
        double salarioHora = CalculoSalarioHora(salarioBruto,diasTrabalhadosSemana);
        boolean direitoPericulosidade = DireitoPericulosidade();
        double calculoInsalubridade = CalculoInsalubridade(nomeColaborador);
        double valeTransporte = CalculoValeTransporte(salarioBruto);
        double valeAlimentacao = CalculoValeAlimentacao(diasTrabalhadosSemana);
        double calculoIRRF = CalculoDescontoIRRF(salarioBruto);
        Relatorio(nomeColaborador,cargoColaborador,dataAdmissao,mesReferencia, salarioBruto, salarioHora, direitoPericulosidade, calculoInsalubridade, valeTransporte, valeAlimentacao,calculoIRRF);
    }
}