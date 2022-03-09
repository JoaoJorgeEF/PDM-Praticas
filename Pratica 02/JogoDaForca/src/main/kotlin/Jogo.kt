import java.util.*

class Jogo(val palavra: String, val dica: String, val tentativas: Int) {
    var layout: String
    var tentativaAtual: Int
    var acabou: Boolean

    init{
        this.layout = ""
        this.tentativaAtual = 1
        this.acabou = false
        for (i in 0 until palavra.length) this.layout += "_"
    }

    fun numeroDeLetras(): Int{
        return palavra.length
    }

    fun numeroDeLetrasDistintas(): Int {
        return palavra.lowercase().chars().distinct().count().toInt()
    }

    fun jogar(letra: String): Boolean{
        if (this.acabou) return false

        for ((index, item) in palavra.lowercase().withIndex()){
            if (letra.lowercase() == item.toString()) {
                layout = layout.substring(0, index) + letra.uppercase() + layout.substring(index + 1)
            }
        }

        if (!layout.contains("_") || this.tentativaAtual == this.tentativas) acabou = true
        ++tentativaAtual

        return true
    }

    fun verificarVitoria(): Boolean{
        if (!layout.contains("_") && tentativaAtual <= tentativas) return true
        return false
    }
}