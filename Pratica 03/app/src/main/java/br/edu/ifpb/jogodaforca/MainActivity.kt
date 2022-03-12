package br.edu.ifpb.jogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.edu.ifpb.jogodaforca.R.id.palavra

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Jogo
    private lateinit var banco: BancoDePalavras
    private lateinit var palavra: TextView
    private lateinit var dica: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.banco = BancoDePalavras()
        this.jogo = Jogo(this.banco.palavra(), this.banco.dica(), 8)

        this.palavra = findViewById(R.id.palavra)
        this.dica = findViewById(R.id.dica)

        this.palavra.text = this.jogo.palavra
        this.dica.text = this.jogo.dica
    }
}