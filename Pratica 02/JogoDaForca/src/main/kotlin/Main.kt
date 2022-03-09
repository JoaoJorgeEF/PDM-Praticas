fun main(args: Array<String>) {
    val jogo = Jogo("Exame", "Necessário para atendimentos médicos", 7)

    println("|-------------- JOGO DA FORCA --------------|")
    println("A Palavra a adivinhar tem ${jogo.numeroDeLetras()} letras, dentre as quais ${jogo.numeroDeLetrasDistintas()} são distintas")
    println("Dica: ${jogo.dica}")
    while(!jogo.acabou){
        println("Palavra: " + jogo.layout)
        println("Você tem ${jogo.tentativas} tentativas, e está na ${jogo.tentativaAtual}ª")
        var letra = readLine()!!
        jogo.jogar(letra)
    }

    if (jogo.verificarVitoria()){
        println("Você ganhou, parabéns! A palavra secreta era ${jogo.palavra}")
    } else{
        println("Não foi dessa vez...")
    }
    println("|------------------ FIM! -------------------|")
}