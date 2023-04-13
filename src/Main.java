import java.util.Scanner;

public class Main {
    public static final double SALARIO_MINIMO = 1320;
    public static final String NOME_COLABORADOR = printaNome();
    public static final String CARGO_COLABORADOR = CargoColaborador();
    public static final String DATA_ADMISSAO = DataAdmissao();
    public static final String MES_REFERENCIA = MesReferencia();
    public static final double SALARIO_BRUTO = CalculoSalarioBruto();
    public static final int DIAS_TRABALHADOS_SEMANA = DiasTrabalhadosSemana();
    public static final double SALARIO_HORA = CalculoSalarioHora();
    public static final boolean DIREITO_PERICULOSIDADE = DireitoPericulosidade();
    public static final double CALCULO_INSALUBRIDADE = CalculoInsalubridade();
    public static final double VALE_TRANSPORTE = CalculoValeTransporte();
    public static final double VALE_ALIMENTACAO = CalculoValeAlimentacao();
    public static final double CALCULO_IRRF = CalculoDescontoIRRF();
    public static String printaNome(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite seu nome completo: ");
        String nome = scan.nextLine();
        return nome;
    }
    public static String CargoColaborador(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Qual é o seu cargo? ");
        String cargo = scan.nextLine();
        return cargo;
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
        String data = dia+"/"+mes+"/"+ano;
        return data;
    }
    public static String MesReferencia(){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        String mes = "";
        while(x==0) {
            System.out.println("Qual é o mês de referência da folha de pagamento? (Responda em números de 1 a 12)");
            int nmes = scan.nextInt();
            switch (nmes) {
                case 1:
                    mes = "Janeiro";
                    x = 1;
                    break;
                case 2:
                    mes = "Fevereiro";
                    x = 1;
                    break;
                case 3:
                    mes = "Março";
                    x = 1;
                    break;
                case 4:
                    mes = "Abril";
                    x = 1;
                    break;
                case 5:
                    mes = "Maio";
                    x = 1;
                    break;
                case 6:
                    mes = "Junho";
                    x = 1;
                    break;
                case 7:
                    mes = "Julho";
                    x = 1;
                    break;
                case 8:
                    mes = "Agosto";
                    x = 1;
                    break;
                case 9:
                    mes = "Setembro";
                    x = 1;
                    break;
                case 10:
                    mes = "Outubro";
                    x = 1;
                    break;
                case 11:
                    mes = "Novembro";
                    x = 1;
                    break;
                case 12:
                    mes = "Dezembro";
                    x = 1;
                    break;
                default:
                    System.out.println("Mês inválido!");
            }
        }
        return mes;
    }
    public static double CalculoSalarioBruto(){
        Scanner scan = new Scanner(System.in);
        System.out.print(NOME_COLABORADOR+", qual é seu salário bruto? R$");
        double SalarioBruto = scan.nextDouble();
        return SalarioBruto;
    }
    public static int DiasTrabalhadosSemana(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Você trabalha quantos dias por semana? ");
        int DiasTrabalhadosSemana = scan.nextInt();
        return DiasTrabalhadosSemana;
    }
    public static double CalculoSalarioHora(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Que horas você começa a trabalhar?(ex: 8) ");
        int HoraInicial = scan.nextInt();
        System.out.println("Que horas você sai do trabalho?(ex: 17) ");
        int HoraFinal = scan.nextInt();
        int CargaHorariaDiaria = HoraFinal - HoraInicial;
        System.out.println("Qual é a duração em horas do seu período de descanso diariamente? ");
        int PeriodoDescansoDiario = scan.nextInt();
        int CHSemanal = (CargaHorariaDiaria-PeriodoDescansoDiario)*DIAS_TRABALHADOS_SEMANA;
        int CHMensal = CHSemanal*5;
        double SalarioHora = SALARIO_BRUTO/CHMensal;
        return SalarioHora;
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
    public static double CalculoInsalubridade(){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int y = 0;
        double retorno = 0;
        while(x == 0) {
            System.out.println(NOME_COLABORADOR + ", você tem direito ao adicional de insalubridade? (Digite 1 para 'Sim' e 2 para 'Não') ");
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
    public static double CalculoValeTransporte(){
        Scanner scan = new Scanner(System.in);
        double retorno = 0;
        double limite = SALARIO_BRUTO*0.06;
        System.out.print("Quanto você recebeu de vale transporte? R$");
        double resp = scan.nextDouble();
        if(resp<=limite)
            retorno = resp;
        else retorno = limite;
        return retorno;
    }
    public static double CalculoValeAlimentacao(){
        int CHMensal = DIAS_TRABALHADOS_SEMANA*5;
        return CHMensal*24;
    }
    public static double CalculoDescontoINSS(){
        double DescontoTotal = 0;
        double faixa1 = 97.65;
        double faixa2 = 114.24;
        double faixa3 = 154.28;
        double faixa4 = 511.07;
        if(SALARIO_BRUTO<=1302)
            DescontoTotal = SALARIO_BRUTO*0.075;
        if(SALARIO_BRUTO>1302 && SALARIO_BRUTO<=2571.29)
            DescontoTotal = faixa1 + ((SALARIO_BRUTO-1302)*0.09);
        if(SALARIO_BRUTO>2571.29 && SALARIO_BRUTO<=3856.94)
            DescontoTotal = faixa1+faixa2+((SALARIO_BRUTO-2571.29)*0.12);
        if(SALARIO_BRUTO>3856.94 && SALARIO_BRUTO<=7507.49)
            DescontoTotal = faixa1+faixa2+faixa3+((SALARIO_BRUTO-3856.94)*0.14);
        if(SALARIO_BRUTO>7507.49)
            DescontoTotal = faixa1+faixa2+faixa3+faixa4;
        return DescontoTotal;
    }
    public static double CalculoDescontoFGTS(){
        return SALARIO_BRUTO * 0.08;
    }
    public static double CalculoDescontoIRRF(){
        Scanner scan = new Scanner(System.in);
        double DescontoTotal = 0, vdep;
        double SalarioBase = SALARIO_BRUTO-CalculoDescontoINSS();
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
    public static double CalculoSalarioLiquido(){
        double SalarioLiquido = SALARIO_BRUTO;
        double addPericulosidade = SALARIO_BRUTO * 0.3;
        if(DIREITO_PERICULOSIDADE)
            SalarioLiquido += addPericulosidade;
        SalarioLiquido += CALCULO_INSALUBRIDADE;
        SalarioLiquido -= VALE_TRANSPORTE;
        SalarioLiquido -= CalculoDescontoINSS();
        SalarioLiquido -= CalculoDescontoFGTS();
        SalarioLiquido -= CALCULO_IRRF;

        return SalarioLiquido;
    }
    public static void Relatorio(){
        double Periculosidade = SALARIO_BRUTO * 0.3;
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
        System.out.println("Nome do colaborador: "+NOME_COLABORADOR);
        System.out.println("Data de admissão: "+DATA_ADMISSAO);
        System.out.println("Mês de Referência: "+MES_REFERENCIA);
        System.out.println("Cargo do colaborador: "+CARGO_COLABORADOR);
        System.out.printf("O salário do colaborador é R$%.2f\n",SALARIO_BRUTO);
        //proventos
        System.out.printf("\nPROVENTOS:\n1- Salário Bruto: R$%.2f\n2- Vale Refeição(Benefício Gratuito): R$%.2f\n",SALARIO_BRUTO,VALE_ALIMENTACAO);
        if(CALCULO_INSALUBRIDADE>0)
            System.out.printf("3- Insalubridade: R$%.2f\n", CALCULO_INSALUBRIDADE);
        if(DIREITO_PERICULOSIDADE == true)
            System.out.printf("4- Periculosidade: R$%.2f\n",Periculosidade);
        //descontos
        System.out.printf("\nDESCONTOS:\n1- INSS: R$%.2f\n2- IRRF: R$%.2f\n3- FGTS: R$%.2f\n4- Vale Transporte: R$%.2f",CalculoDescontoINSS(),CALCULO_IRRF, CalculoDescontoFGTS(), VALE_TRANSPORTE);
        System.out.printf("\nValor bruto do salário: R$%.2f\n",SALARIO_BRUTO);
        System.out.printf("Valor do salário por hora: R$%.2f\n", SALARIO_HORA);
        System.out.printf("Salário líquido do colaborador: R$%.2f\n", CalculoSalarioLiquido());
        double CalcIRRF = SALARIO_BRUTO - CALCULO_IRRF;
        double CalcINSS = CalculoDescontoINSS();
        double CalcFGTS = CalculoDescontoFGTS();
        System.out.printf("Base de cálculo INSS: R$%.2f - R$%.2f = R$%.2f\n",SALARIO_BRUTO,CalcINSS,(SALARIO_BRUTO-CalcINSS));
        System.out.printf("Base de cálculo FGTS: R$%.2f - R$%.2f = R$%.2f\n",SALARIO_BRUTO,CalcFGTS,(SALARIO_BRUTO-CalcFGTS));
        System.out.printf("Base de cálculo IRRF: R$%.2f - R$%.2f = R$%.2f\n",SALARIO_BRUTO,CALCULO_IRRF,CalcIRRF);
    }
    public static void main(String[] args) {
        Relatorio();
    }
}