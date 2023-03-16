
package gof;
import java.util.Scanner;
import java.util.Random;

public class FightRoyale {
	static int ataquePlayer() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Escolha seu Ataque");
		System.out.println("(1) - Soco");
		System.out.println("(2) - Especial");
		return leitor.nextInt();
	}
	
	static int ataqueCPU() {
		Random gerador = new Random();
		return gerador.nextInt(3)+1;
	}
	
	static void imprimeHP(int hpPlayer, int hpCPU, int contagemEspeciais) {
		System.out.println("==================");
		System.out.println(" HP Player:" + hpPlayer);
		System.out.println(" HP CPU:" + hpCPU);
		System.out.println("Contagem Especiais:" + contagemEspeciais);
		System.out.println("==================");
	}
	
	static int batalha() {
		int hpPlayer = 150;
		int hpCPU = 11;
		int contagemEspecial = 5;
		int escolhaAtaque;
		int i = 0;
		
		while(hpPlayer > 0) {
			hpCPU = 10 + i;
			
			System.out.println("=-=-=-=-=-=-=-=-=-");
			System.out.println("Inimigo" + i);
			System.out.println("=-=-=-=-=-=-=-=-=-\n");
		
			while(hpPlayer > 0 && hpCPU > 0) {
				imprimeHP(hpPlayer, hpCPU, contagemEspecial);
				escolhaAtaque = ataquePlayer();
				switch(escolhaAtaque) {
				case 1:
					System.out.println("Player aplicou um soco.");
					hpCPU -= 7;
					break;
				case 2:
					System.out.println("Player aplicou um Especial");
					hpCPU -= 20;
					contagemEspecial --;
					break;
					default:
						System.out.println("Opção Invalida");
						break;
				}
				if(hpCPU > 0) {
					escolhaAtaque = ataqueCPU();
					switch(escolhaAtaque) {
					case 1:
						System.out.println("Inimigo aplicou um Soco");
						hpPlayer -= 2 + (int)(i/10);
						break;
					case 2:
						System.out.println("Inimigo aplicou um Chute");
						hpPlayer -= 3 + (int)(i/10);
						break;
					case 3:
						System.out.println("Inimigo aplicou um Especial");
						hpPlayer -= 4 + (int)(i/20);
						break;
					}
					
				}
				else {
					System.out.println("Inimigo Derrotado.");
				}
			}
			if(hpPlayer > 0) {
				hpPlayer += 5;
				if(hpPlayer > 150) {
					hpPlayer = 150;
				}
				if(i % 10 == 0) {
					contagemEspecial++;
					if(contagemEspecial > 5) {
						contagemEspecial = 5;
					}
				}
			}
			
			i++;
		}
		return i;
	}
	
	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int continua = 1;
		int recorde = 0;
		while(continua ==1) {
			
			int pontos = batalha();
			System.out.println("Usuario chegou a" + pontos + "pontos."); 
			if(pontos>recorde) {
				recorde = pontos;
			}
			System.out.println("RECORDE ATUAL = " + recorde);
			
			System.out.println("Fim do Jogo. Deseja Continuar? (1) Sim (2) Não");
			continua = leitor.nextInt();
		}
	}
}
