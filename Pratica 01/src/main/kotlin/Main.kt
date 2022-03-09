fun main(args: Array<String>) {
    val jogo = Jogo("Exame", "Necessário para atendimentos médicos", 8)

    println("|-------------- JOGO DA FORCA --------------|")
    println("A Palavra a adivinhar tem ${jogo.numeroDeLetras()} letras, dentre as quais ${jogo.numeroDeLetrasDistintas()} são distintas")
    println("Dica: ${jogo.dica}")
    while(!jogo.acabou){
        println("Palavra: " + jogo.palavraEscondida)
        println("Você tem ${jogo.tentativas} tentativas, e está na ${jogo.tentativaAtual}ª")
        var letra = readLine()!!
        jogo.verificarLetra(letra)
    }
    println("|------------------ FIM! -------------------|")
}