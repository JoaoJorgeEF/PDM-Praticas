package br.edu.ifpb.jogodaforca

class BancoDePalavras {
    val palavras: LinkedHashMap<String, String>
    lateinit var sorteada: String

    init{
        this.palavras = linkedMapOf()
        this.montaPalavras()
        this.sorteia()
    }

    fun palavra(): String{
        return this.sorteada
    }

    fun dica(): String{
        return this.palavras.get(this.sorteada).toString()
    }

    private fun montaPalavras() {
        this.palavras.put("Exame", "Que é feito por um médico")
        this.palavras.put("Android", "Sistema Operacional Mobile")
        this.palavras.put("Banana", "Fruta amarela")
        this.palavras.put("Macaco", "Animal parecido com o humano")
        this.palavras.put("Carro", "Utilizado para locomoção")
    }

    private fun sorteia() {
        this.sorteada = this.palavras.keys.random()
    }
}