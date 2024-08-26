import java.util.*;

public class Main {
  public static void main(String[] args) {
    Random gerador = new Random();
    Scanner teclado = new Scanner(System.in);

    
    ArrayList<String> BancoDePalavras1 = new ArrayList<>();
    BancoDePalavras1.add("incendiar");
    BancoDePalavras1.add("condescender");
    BancoDePalavras1.add("remediar");
    BancoDePalavras1.add("perguntar");
    BancoDePalavras1.add("constatar");
    BancoDePalavras1.add("deglutir");
    BancoDePalavras1.add("digladiar");
    BancoDePalavras1.add("compartilhar");

    ArrayList<String> BancoDePalavras2 = new ArrayList<>();
    BancoDePalavras2.add("cleptomaniaco");
    BancoDePalavras2.add("destruidor");
    BancoDePalavras2.add("horripilante");
    BancoDePalavras2.add("desequilibrado");
    BancoDePalavras2.add("dissimulado");
    BancoDePalavras2.add("incompetente");
    BancoDePalavras2.add("perfeccionista");
    BancoDePalavras2.add("neurotico");

    ArrayList<String> BancoDePalavras3 = new ArrayList<>();
    BancoDePalavras3.add("guarda-chuva");
    BancoDePalavras3.add("algarismo");
    BancoDePalavras3.add("bumerangue");
    BancoDePalavras3.add("bicarbonato");
    BancoDePalavras3.add("ascensao");
    BancoDePalavras3.add("crepusculo");
    BancoDePalavras3.add("travesseiro");
    BancoDePalavras3.add("zumbido");
    BancoDePalavras3.add("camuflagem");


    ArrayList<String> tentativas = new ArrayList<>();
    ArrayList<String> escolhas = new ArrayList<>();
String palavra = "";
char tentativa;
int erros = 0, op = 0, resposta;
String[] desenho = new String [7];
    desenho[0]= "| |==========||\n| |          \n| |           \n| |          \n| |          \n| |\n_______________";
    desenho[1]= "| |==========||\n| |          ||\n| |           O\n| |          \n| |          \n| |\n_______________";
    desenho[2]= "| |==========||\n| |          ||\n| |           O\n| |           |\n| |          \n| |\n_______________";
    desenho[3]= "| |==========||\n| |          ||\n| |           O\n| |          /|\n| |          \n| |\n_______________";
    desenho[4]= "| |==========||\n| |          ||\n| |           O\n| |          /|\\\n| |          \n| |\n_______________";
    desenho[5]= "| |==========||\n| |          ||\n| |           O\n| |          /|\\\n| |          /  \n| |\n_______________  ";
    desenho[6]= "| |==========||\n| |          ||\n| |           O\n| |          /|\\\n| |          / \\\n| |\n_______________";
do{
  op = 0;
  erros = 0;
  palavra = "";
  tentativas.clear();
  escolhas.clear();
int contador = 0;
System.out.print("\nREGRAS:\n");
  System.out.println("-Número máximo de tentativas falhas: 6;");
  System.out.println("-Se a palavra conter um travessão ('-'), deverá escrever ele também;");
  System.out.println("-Caso digite mais de uma letra, a primeira delas será considerada;");
  System.out.println("-As tentativas falhas  de cada partida serão registradas.\n");
  System.out.println("\nEscolha um tema: ");
  System.out.println("Verbos - 1");
  System.out.println("Características - 2");
  System.out.println("Aleatório - 3");
  
  do{System.out.print("\nResposta: ");
  resposta = teclado.nextInt();
  System.out.print("\n");

  if(resposta == 1){
  palavra += BancoDePalavras1.get(gerador.nextInt(BancoDePalavras1.size()));
  }
  else if(resposta == 2){
    palavra += BancoDePalavras2.get(gerador.nextInt(BancoDePalavras2.size()));
    }
  else if(resposta == 3){
    palavra += BancoDePalavras3.get(gerador.nextInt(BancoDePalavras3.size()));
  }
    else{
    System.out.println("Resposta inválida. Tente novamente.");
    }
  }while(resposta != 1 && resposta != 2 && resposta != 3);
  
  String[] temporaria = new String[palavra.length()];
      for(int l = 0; l < palavra.length(); l++){
  temporaria[l] = "_";
        }
  
if(String.valueOf(tentativas) != palavra){
    System.out.println(desenho[0]);
}
    do{ 
    System.out.print("\nPalavra: ");
    for(String partes : temporaria){
      System.out.print(partes);
    }
      System.out.print("\nTentativas: ");
      for(String partes : tentativas){
        System.out.print(partes + "-");
      }
    
      
do{
      System.out.print("\nEscolha uma letra: ");
        tentativa = teclado.next().toLowerCase().charAt(0);

  
  
if(tentativas.contains(String.valueOf(tentativa))){
  System.out.print("\nVocê já tentou essa letra antes. Escolha outra."); 
}
  else if(escolhas.contains(String.valueOf(tentativa))){
    System.out.print("\nVocê já escolheu essa letra antes. Escolha outra."); 
  }
  
  
  }while((tentativas.contains(String.valueOf(tentativa))) == true || escolhas.contains(String.valueOf(tentativa)) );
      
  if((tentativas.contains(String.valueOf(tentativa))) == false && palavra.contains(String.valueOf(tentativa)) == false){
        tentativas.add(String.valueOf(tentativa));
  }
    if(escolhas.contains(String.valueOf(tentativa)) == false){
      escolhas.add(String.valueOf(tentativa));
    }
      
System.out.println("\n");
    
if(palavra.contains(String.valueOf(tentativa)) == true && contador != palavra.length()){
  System.out.println(desenho[erros]);
  for(int n = 0; n < palavra.length(); n++){
    if(palavra.charAt(n) == tentativa){
      temporaria[n] = String.valueOf(tentativa);
        contador++;
}

  }
}
    
  if(palavra.contains(String.valueOf(tentativa)) == false){
    erros++;
    System.out.println(desenho[erros]);
    if(tentativa == '-'){
      System.out.println("\nA palavra escolhida não possuí '" + tentativa + "'.");
    }
    else{
      System.out.println("\nA palavra escolhida não possuí a letra " + tentativa + ".");
    }
  }
      }while(erros < 6 && String.valueOf(temporaria).equals(palavra) == false && contador != palavra.length());
    
  if(erros == 6){
    System.out.print("\nVocê perdeu :(, o número máximo de erros foi atingido. A palavra escolhida era " + palavra + ".");
    System.out.print("\nDeseja jogar novamente?(sim = 1, não = 2): ");
        op = teclado.nextInt();
  }
  else{
    System.out.print("\nParabéns, você acertou! a palavra escolhida é " + palavra + ".\nDeseja jogar novamente?(sim = 1, não = 2): ");
    op = teclado.nextInt();
  }
  
  }while(op != 2);
  
  }
}