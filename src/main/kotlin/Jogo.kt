import java.util.*

class Jogo(val palavra: String, val dica: String, val tentativas: Int, var tentativaAtual: Int = 1, var palavraEscondida: String = "", var acabou: Boolean = false) {

    init{
        for (i in 0 until palavra.length) palavraEscondida += "_"
    }

    fun numeroDeLetras(): Int{
        return palavra.length
    }

    fun numeroDeLetrasDistintas(): Int {
        return palavra.lowercase().chars().distinct().count().toInt()
    }

    fun verificarLetra(letra: String) {
        for ((index, item) in palavra.lowercase().withIndex()){
            if (letra.lowercase() == item.toString()) {
                palavraEscondida = palavraEscondida.substring(0, index) + letra.uppercase() + palavraEscondida.substring(index + 1)
            }
        }
        if (!palavraEscondida.contains("_")) {
            acabar()
            return
        }
        incrementaTentativa()

    }

    private fun incrementaTentativa(){
        ++tentativaAtual
        if (tentativaAtual == tentativas) acabar()
    }

    private fun acabar() {
        acabou = true
        if (palavraEscondida.contains("_")) println("Perdeu :/ Tente novamente. A palavra era ${palavra}")
        else println("VOCÊ GANHOU EM ${tentativaAtual} TENTATIVAS, PARABÉNS :D. A palavra era ${palavra}")
    }
}