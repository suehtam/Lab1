import java.util.Scanner;
public class Lab2
{
    public static void main(String[] args) 
    {
        parimpar();
    }
    public static void jokenpo(int item) 
    {
        switch (item) 
        {
            case 1:
            System.out.print("PEDRA - ");
            break;
            case 2:
            System.out.print("PAPEL - ");
            break;
            case 3:
            System.out.print("TESOURA - ");
            break;
        }
    }
    public static int jogada(int escolha) 
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Pedra (1), Papel (2), Tesoura (3)? ");
        escolha = in.nextInt();
        return escolha;
    }
    public static void parimpar() 
    {
        String vencedor;
        int jogador1 = 0, jogador2 = 0, continuar = 1, min = 0, max = 3;
        Scanner in = new Scanner(System.in);
        while (continuar == 1) 
        {
            jogador1 = jogada(jogador1);
            while (jogador1 < min || jogador1 > max)
            {
                System.out.println("entrada invalida");
                jogador1 = jogada(jogador1);
            }
            jogador2 = jogada(jogador2);
            while ((jogador2 < min || jogador2 > max)) 
            {
                System.out.println("entrada invalida");
                jogador2 = jogada(jogador1);
            }
            jokenpo(jogador1);
            jokenpo(jogador2);
            vencedor = VerificarVencedor(jogador1, jogador2);
            System.out.println("\n" + vencedor);
            if(vencedor == "empate")
            {
                parimpar();
            } 
            System.out.println("");
            System.out.println("------------------------------------------------");
            System.out.print("deseja continuar? 1 -> SIM. -1 -> NAO : ");
            continuar = in.nextInt();
            System.out.println("");
            System.out.println("------------------------------------------------");
        }
    }
    public static String VerificarVencedor(int jog1, int jog2)
    {
        int res;
        final int num_itens = 3;
        res = Math.abs((num_itens + jog1 - jog2) % num_itens);
        if (res > 0 && res <= (num_itens / 2))
        {
            return "Jogador 1 Ganhou!";
        } 
        else if (res > (num_itens / 2))
        {
            return "Jogador 2 Ganhou!";
        }
        else
        {
            return "empate";
        }
    }
}